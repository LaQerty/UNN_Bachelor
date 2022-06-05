package Server;

import Server.prt1.Proto;
import Server.prt1.ProtoServerGrpc;
import com.google.protobuf.Empty;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import pizza.Pizza;

public class ServerRun extends ProtoServerGrpc.ProtoServerImplBase {
    HashMap<Integer, Pizza> shop = new HashMap();
    int pizzaId = 0;
    int orderId = -1;
    HashMap<Integer, String> orders = new HashMap();
    
    @Override
    public void getAllPizza(Empty request, StreamObserver<Proto.getAllPizzaResponse> response) {
        String res = "";
        for(int p : shop.keySet()){
            res+="ID: " + p + "\n"; 
            res+=shop.get(p).toString();
        }
        Proto.getAllPizzaResponse resp = Proto.getAllPizzaResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void addNewPizza(Proto.addNewPizzaRequest request, StreamObserver<Proto.addNewPizzaResponse> response) {
        pizzaId++;
        shop.put(pizzaId,new Pizza(request.getName(), request.getAbout(), request.getPrice()));
        Proto.addNewPizzaResponse resp = Proto.addNewPizzaResponse.newBuilder().setId(pizzaId).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void deletePizza(Proto.deletePizzaRequest request, StreamObserver<Proto.deletePizzaResponse> response) {
        String res = "";
        if(shop.containsKey(request.getId())){
            shop.remove(request.getId());
            res+="Success\n";
        } else res+="Not found!\n";
        
        Proto.deletePizzaResponse resp = Proto.deletePizzaResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void changeStatusToDone(Proto.changeStatusToDoneRequest request, StreamObserver<Proto.changeStatusToDoneResponse> response) {
        String res = "";
        if(orders.containsKey(request.getId())){
            if(orders.get(request.getId()) != "Done"){
                res+="Success\n";
                orders.remove(request.getId());
                orders.put(request.getId(), "Done");
            } else res+="Already done!\n";
        } else res+="Not found!\n";
        
        Proto.changeStatusToDoneResponse resp = Proto.changeStatusToDoneResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void changeStatusToAtWork(Proto.changeStatusToAtWorkRequest request, StreamObserver<Proto.changeStatusToAtWorkResponse> response) {
        String res = "";
        if(orders.containsKey(request.getId())){
            if(orders.get(request.getId()) != "Done" && orders.get(request.getId()) != "At work"){
                res+="Success\n";
                orders.remove(request.getId());
                orders.put(request.getId(), "At work");
            } else res+="Already at work or done!\n";
        } else res+="Not found!\n";
        
        Proto.changeStatusToAtWorkResponse resp = Proto.changeStatusToAtWorkResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void makeOrder(Proto.makeOrderRequest request, StreamObserver<Proto.makeOrderResponse> response) {
        orderId++;
        orders.put(orderId, "New");
        String res = "";
        int p = 0;
        String []ids = request.getId().split(" ");
        String []counts = request.getCount().split(" ");
        for(int i = 0; i < ids.length; i++){
            if(shop.containsKey(Integer.valueOf(ids[i]))){
                p+=shop.get(Integer.valueOf(ids[i])).price * Integer.valueOf(counts[i]);
            } else res+= "Pizza with ID: " + Integer.valueOf(ids[i]) + " not found!\n";
        }
        res+="Order ID: " + orderId + " Price: " + p + "Ru \n";
        Proto.makeOrderResponse resp = Proto.makeOrderResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void checkOrder(Proto.checkOrderRequest request, StreamObserver<Proto.checkOrderResponse> response) {
        String res = "";
        if(orders.containsKey(request.getId())){
            res+="Status: " + orders.get(request.getId()) + "\n";
        } else res+= "This order not found!\n";
        Proto.checkOrderResponse resp = Proto.checkOrderResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(8000).addService(new ServerRun()).build();
            server.start();
            System.out.println("Server started!");
            try {
                server.awaitTermination();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ServerRun.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
