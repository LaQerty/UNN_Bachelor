package ClientServer;

import ClientServer.prt1.Proto;
import ClientServer.prt1.ProtoServerGrpc;
import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Client {
    public static void main(String[] args) {
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        ProtoServerGrpc.ProtoServerBlockingStub clientGRPC = ProtoServerGrpc.newBlockingStub(channel);
        Scanner scan = new Scanner(System.in);
        String str = "";
        int id = -1;
        Empty request = Empty.newBuilder().build();
        Proto.isGameEndedResponse responce = clientGRPC.isGameEnded(request);
        boolean isGameEnd = false;
        isGameEnd = responce.getRes();
        Proto.RegisterPlayerResponse res = clientGRPC.registerPlayer(request);
        id = res.getId();
        System.out.println("You`r id: " + id);
        while(!isGameEnd){
            str = scan.nextLine(); 
            Proto.getFielResponse res1 = clientGRPC.getField(request);
            System.out.println(res1.getField());
            boolean flag = false;
            Proto.isMyTurnRequest req1 = Proto.isMyTurnRequest.newBuilder().setId(id).build();
            Proto.isMyTurnResponse res3 = clientGRPC.isMyTurn(req1);
            if(res3.getRes()){
                for(int i =0; i< 3; i++){
                    str = scan.nextLine();
                    int x = getMoveFromString(str)[0];
                    int y = getMoveFromString(str)[1];
                    Proto.canSetCellRequest req2 = Proto.canSetCellRequest.newBuilder().setX(x).setY(y).setId(id).build();
                    Proto.canSetCellResponse res4 = clientGRPC.canSetCell(req2);
                    if(res4.getRes()){
                        Proto.setCellRequest req3 = Proto.setCellRequest.newBuilder().setX(x).setY(y).setId(id).build();
                        Proto.setCellResponse res5 = clientGRPC.setCell(req3);
                        System.out.println(res5.getRes());
                    } else {
                        System.out.println("Uncorectly");
                        i--;
                    }
                }
                Proto.endTurnResponse res6 = clientGRPC.endTurn(request);
                System.out.println(res6.getRes());
                Proto.isGameEndedResponse res7 = clientGRPC.isGameEnded(request);
                isGameEnd = res7.getRes();
                if(isGameEnd){
                    System.out.println("You win!");
                }
            } else System.out.println("Wait!");
        }
    }
    public static int[] getMoveFromString(String word) {
        int[] res = {-1, -1};
        char str[] = word.toCharArray();
        int num1 = (int)str[0];
        int num2 = (int)str[1];
        if(num1 < 107 & num1 > 96)
            res[0]=num1-97;
        if(num2 < 58 & num2 > 47)
            res[1]=num2-48;
        return res;
    }
}
