package ClientServer;

import ClientServer.prt1.Proto;
import ClientServer.prt1.ProtoServerGrpc;
import DataBase.Note;
import DataBase.Note.File;
import com.google.protobuf.Empty;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSide extends ProtoServerGrpc.ProtoServerImplBase{
    public int random(){
        return (int)(Math.random()*10000);
    }
    HashMap<Integer, Note> db = new HashMap();
    HashMap<Integer, String> marks = new HashMap();
    
    @Override
    public void addNote(Proto.addNoteRequest request, StreamObserver<Proto.addNoteResponse> response) {
        int id = -1;
        while (db.keySet().contains(id) || id == -1) {
            id = random();
        }
        db.put(id,new Note(request.getName(), request.getText()));
        Proto.addNoteResponse resp = Proto.addNoteResponse.newBuilder().setId(id).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void addMarkToNote(Proto.addMarkToNoteRequest request, StreamObserver<Proto.addMarkToNoteResponse> response) {
        String strArr[] = request.getMarks().split(" ");
        int[] m = new int[strArr.length];
        for(int i = 0 ; i < strArr.length; i++)
            m[i] = Integer.parseInt(strArr[i]);
        String res = "";
        if(db.containsKey(request.getId())){
            db.get(request.getId()).addMarks(m);
            res = "Success";
        } else res = "Cant find this note";
        Proto.addMarkToNoteResponse resp = Proto.addMarkToNoteResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void addFileToNote(Proto.addFileToNoteRequest request, StreamObserver<Proto.addFileToNoteResponse> response) {
        String res = "";
        if(db.containsKey(request.getId())){
            db.get(request.getId()).addFile(request.getName(), request.getFile());
            res = "Success";
        } else res = "Cant find this note";
        Proto.addFileToNoteResponse resp = Proto.addFileToNoteResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void addNewMark(Proto.addNewMarkRequest request, StreamObserver<Proto.addNewMarkResponse> response) {
        int id = -1;
        while (marks.keySet().contains(id) || id == -1) {
            id = random();
        }
        marks.put(id, request.getName());
        Proto.addNewMarkResponse resp = Proto.addNewMarkResponse.newBuilder().setId(id).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void getFile(Proto.getFileRequest request, StreamObserver<Proto.getFileResponse> response) {
        String res = "";
        if(db.containsKey(request.getId())) {
            for( File f: db.get(request.getId()).files){
                if(f.name.equals(request.getName()))
                    try {
                        res = new String(f.file, "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if( res == "")
                res = "Cant find this file";
        } else res = "Cant find this note";
        Proto.getFileResponse resp = Proto.getFileResponse.newBuilder().setFile(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void deleteMark(Proto.deleteMarkRequest request, StreamObserver<Proto.deleteMarkResponse> response) {
        String res = "";
        if(marks.containsKey(request.getId())){
            marks.remove(request.getId());
            res = "Success";
        } else res = "Cant find this mark";
        Proto.deleteMarkResponse resp = Proto.deleteMarkResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void getAllMark(Empty request, StreamObserver<Proto.getAllMarkResponse> response) {
        String res = "";
        for(int i : marks.keySet())
            res+= "ID: " + i + " - "+ marks.get(i) + "\n";
        Proto.getAllMarkResponse resp = Proto.getAllMarkResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void getAllNote(Empty request, StreamObserver<Proto.getAllNoteResponse> response) {
        String res = "";
        for(int i : db.keySet())
            res+= "ID: " + i + " - "+ db.get(i).name + "\n";
        Proto.getAllNoteResponse resp = Proto.getAllNoteResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void findNote(Proto.findNoteRequest request, StreamObserver<Proto.findNoteResponse> response) {
        String res = "";
        if(marks.containsKey(request.getId())){
            for(int i : db.keySet()) {
                if(db.get(i).marks.contains(request.getId()))
                    res+= "ID: " + i + " - "+ db.get(i).name + "\n";
            }
        } else res = "Cant find this mark";
        Proto.findNoteResponse resp = Proto.findNoteResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
        
    
    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(8080).addService(new ServerSide()).build();
            server.start();
            System.out.println("Server started!");
            try {
                server.awaitTermination();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
