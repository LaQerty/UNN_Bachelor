package ClientServer;

import com.google.protobuf.Empty;
import ClientServer.prt1.Proto;
import ClientServer.prt1.ProtoServerGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import labStruct.Lab;

public class Serv extends ProtoServerGrpc.ProtoServerImplBase{
    ArrayList<Lab> labs = new ArrayList();
    int count = -1;
    
    @Override
    public void addFile(Proto.addFileRequest request, StreamObserver<Proto.addFileResponse> response) {
        labs.add(new Lab(request.getName(), request.getLab()));
        count++;
        Proto.addFileResponse resp = Proto.addFileResponse.newBuilder().setId(count).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void getIdForEstimate(Proto.getIdForEstimateRequest request, StreamObserver<Proto.getIdForEstimateResponse> response) {
        int[] ids = {0,0,0};
        int[] min = {35,35,35};
        String name = request.getName();
        for(int i = 0; i < labs.size(); i++){
            if(!labs.get(i).owner.equals(name)){
                for(int j = 0; j < 3; j++){
                    if(labs.get(i).estimators.size() <= min[j]){
                        min[j] = labs.get(i).estimators.size();
                        ids[j] = i;
                    }
                }
            }
        }
        Proto.getIdForEstimateResponse resp = Proto.getIdForEstimateResponse.newBuilder().setId1(ids[0]).setId2(ids[1]).setId3(ids[2]).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void getFile(Proto.getFileRequest request, StreamObserver<Proto.getFileResponse> response) {
        int id = request.getId();
        String res;
        try {
            res = new String(labs.get(id).lab, "UTF-8");
            Proto.getFileResponse resp = Proto.getFileResponse.newBuilder().setLab(res).build();
            response.onNext(resp);
            response.onCompleted();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Serv.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    @Override
    public void setMark(Proto.setMarkRequest request, StreamObserver<Proto.setMarkResponse> response) {
        int id = request.getId();
        String res = labs.get(id).setMark(request.getName(), request.getMark());
        Proto.setMarkResponse resp = Proto.setMarkResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void getAverageMark(Proto.getAverageMarkRequest request, StreamObserver<Proto.getAverageMarkResponse> response) {
        int id = request.getId();
        int res = labs.get(id).getAverageMark();
        Proto.getAverageMarkResponse resp = Proto.getAverageMarkResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void getAllLab(Empty request, StreamObserver<Proto.getAllLabResponse> response) {
        String names = "";
        for(Lab l : labs){
            names += l.owner + ",";
        }
        Proto.getAllLabResponse resp = Proto.getAllLabResponse.newBuilder().setName(names).setId(count).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void getAllMark(Proto.getAllMarkRequest request, StreamObserver<Proto.getAllMarkResponse> response) {
        int id = request.getId();
        String names = "";
        String marks = "";
        for(int i = 0; i < labs.get(id).estimators.size(); i++) {
            names += labs.get(id).estimators.get(i) + ",";
            marks += labs.get(id).grades.get(i).toString() + ",";
        }
        Proto.getAllMarkResponse resp = Proto.getAllMarkResponse.newBuilder().setName(names).setMark(marks).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(8080).addService(new Serv()).build();
            server.start();
            System.out.println("Server started!");
            try {
                server.awaitTermination();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Serv.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Serv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
