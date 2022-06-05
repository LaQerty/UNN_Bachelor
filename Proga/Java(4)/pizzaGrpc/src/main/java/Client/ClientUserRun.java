package Client;

import Server.prt1.Proto;
import Server.prt1.ProtoServerGrpc;
import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ClientUserRun {
    public static void main(String[] args) {
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 8000).usePlaintext().build();
        ProtoServerGrpc.ProtoServerBlockingStub clientGRPC = ProtoServerGrpc.newBlockingStub(channel);
        Empty request = Empty.newBuilder().build();
        Scanner cons = new Scanner(System.in);
        String userWord = "";
        while(userWord != "exit"){
            System.out.println("You login like user!\nСhoose option: \n 1 - get all pizza \n2 - make order \n3 - check order status \n");
            userWord = cons.nextLine();
            switch(userWord){
                case"1":
                    Proto.getAllPizzaResponse res = clientGRPC.getAllPizza(request);
                    System.out.println(res.getRes());
                    break;
                case"2":
                    System.out.println("Enter pizza`s IDS(throught space): \n");
                    String ids = cons.nextLine();
                    System.out.println("Enter pizza`s count(throught space): \n");
                    String counts = cons.nextLine();
                    String []i = ids.split(" ");
                    String []c = counts.split(" ");
                    if(i.length != c.length) {
                        System.out.println("Uncorrectly!\n");
                    } else {
                        Proto.makeOrderRequest req1 = Proto.makeOrderRequest.newBuilder().setId(ids).setCount(counts).build();
                        Proto.makeOrderResponse res1 = clientGRPC.makeOrder(req1);
                        System.out.println(res1.getRes() + "\n");
                    }
                    break;

                case"3":
                    System.out.println("Enter order`s ID: \n");
                    int id = Integer.valueOf(cons.nextLine());
                    Proto.checkOrderRequest req2 = Proto.checkOrderRequest.newBuilder().setId(id).build();
                    Proto.checkOrderResponse res2 = clientGRPC.checkOrder(req2);
                    System.out.println(res2.getRes());
                    break;
                default: 
                    System.out.println("Uncorrectly!");
                    break;
            }
        }
        cons.close();
    }
}
