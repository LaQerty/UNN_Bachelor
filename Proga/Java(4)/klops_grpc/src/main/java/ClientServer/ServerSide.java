package ClientServer;

import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import ClientServer.prt1.Proto;
import ClientServer.prt1.ProtoServerGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSide extends ProtoServerGrpc.ProtoServerImplBase{
    Game game = new Game();
    
    @Override
    public void registerPlayer(Empty request, StreamObserver<Proto.RegisterPlayerResponse> response) {
        int id = game.addNewPlayer();
        Proto.RegisterPlayerResponse resp = Proto.RegisterPlayerResponse.newBuilder().setId(id).build();
        response.onNext(resp);
        response.onCompleted();
    }
    @Override
    public void getField(Empty request, StreamObserver<Proto.getFielResponse> response) {
        Proto.getFielResponse resp = Proto.getFielResponse.newBuilder().setField(game.getField()).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void isMyTurn(Proto.isMyTurnRequest request, StreamObserver<Proto.isMyTurnResponse> response) {
        boolean res = game.isMyTurn(request.getId());
        Proto.isMyTurnResponse resp = Proto.isMyTurnResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void canSetCell(Proto.canSetCellRequest request, StreamObserver<Proto.canSetCellResponse> response) {
        boolean res = game.canSetCell(request.getX(),request.getY(),request.getId());
        Proto.canSetCellResponse resp = Proto.canSetCellResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void setCell(Proto.setCellRequest request, StreamObserver<Proto.setCellResponse> response) {
        String res = game.setCell(request.getX(),request.getY(),request.getId());
        Proto.setCellResponse resp = Proto.setCellResponse.newBuilder().setRes(res).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void endTurn(Empty request, StreamObserver<Proto.endTurnResponse> response) {
        game.endTurn();
        Proto.endTurnResponse resp = Proto.endTurnResponse.newBuilder().setRes("Your turn end").build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    @Override
    public void isGameEnded(Empty request, StreamObserver<Proto.isGameEndedResponse> response) {
        Proto.isGameEndedResponse resp = Proto.isGameEndedResponse.newBuilder().setRes(game.isGameEnded()).build();
        response.onNext(resp);
        response.onCompleted();
    }
    
    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(8080).addService(new ServerSide()).build();
            server.start();
            System.out.println("Start Server!");
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
