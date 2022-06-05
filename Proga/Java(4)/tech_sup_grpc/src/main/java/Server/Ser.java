package Server;

import Server.prt1.Proto;
import Server.prt1.ProtoServerGrpc;
import Struct.Tec_sup;
import com.google.protobuf.Empty;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ser extends ProtoServerGrpc.ProtoServerImplBase {
    ArrayList<Tec_sup> tec = new ArrayList();
    int id = -1;
    
    @Override
    public void newZapros(Proto.newZaprosRequest request, StreamObserver<Proto.newZaprosResponse> response) {
        id++;
        tec.add(new Tec_sup(request.getName(),request.getEmail(),request.getDate(), request.getText()));
        Proto.newZaprosResponse resp = Proto.newZaprosResponse.newBuilder().setId(id).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void getStatus(Proto.getStatusRequest request, StreamObserver<Proto.getStatusResponse> response) {
        Proto.getStatusResponse resp = Proto.getStatusResponse.newBuilder().setStatus(tec.get(request.getId()).getStatus()).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void complite(Proto.compliteRequest request, StreamObserver<Proto.compliteResponse> response) {
        tec.get(request.getId()).status = 1;
        Proto.compliteResponse resp = Proto.compliteResponse.newBuilder().setRes("New status: " + tec.get(request.getId()).getStatus()).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void reOpen(Proto.reOpenRequest request, StreamObserver<Proto.reOpenResponse> response) {
        tec.get(request.getId()).status = 2;
        tec.get(request.getId()).text += "\nReOpen mark: " + request.getText();
        Proto.reOpenResponse resp = Proto.reOpenResponse.newBuilder().setRes("New status: " + tec.get(request.getId()).getStatus()).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void getAll(Empty request, StreamObserver<Proto.getAllResponse> response) {
        String res ="";
        int q = 0;
        for(Tec_sup i : tec){
            res+= "ID: " + q + "\n" + i.toString();
            q++;
        }
        Proto.getAllResponse resp = Proto.getAllResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void atWork(Proto.atWorkRequest request, StreamObserver<Proto.atWorkResponse> response) {
        tec.get(request.getId()).status = 3;
        Proto.atWorkResponse resp = Proto.atWorkResponse.newBuilder().setRes("New status: " + tec.get(request.getId()).getStatus()).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void done(Proto.doneRequest request, StreamObserver<Proto.doneResponse> response) {
        tec.get(request.getId()).status = 4;
        Proto.doneResponse resp = Proto.doneResponse.newBuilder().setRes("New status: " + tec.get(request.getId()).getStatus()).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(8080).addService(new Ser()).build();
            server.start();
            System.out.println("HI, i`am server!");
            try {
                server.awaitTermination();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Ser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Ser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
