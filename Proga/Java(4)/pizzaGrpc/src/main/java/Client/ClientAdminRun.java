package Client;

import Server.prt1.Proto;
import Server.prt1.ProtoServerGrpc;
import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;


public class ClientAdminRun {
    public static void main(String[] args) {
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 8000).usePlaintext().build();
        ProtoServerGrpc.ProtoServerBlockingStub clientGRPC = ProtoServerGrpc.newBlockingStub(channel);
        Empty request = Empty.newBuilder().build();
        Scanner cons = new Scanner(System.in);
        String userWord = "";
        while(userWord != "exit"){
            System.out.println("You login like admin!\nСhoose option: \n 1 - get all pizza \n2 - add new pizza \n3 - delete pizza \n"
                    + "4 - change status to 'At work' \n5 - change status to 'Done' \n");
            userWord = cons.nextLine();
            switch(userWord){
                case"1":
                    Proto.getAllPizzaResponse res = clientGRPC.getAllPizza(request);
                    System.out.println(res.getRes());
                    break;
                case"2":
                    System.out.println("Enter pizza`s name: \n");
                    String name = cons.nextLine();
                    System.out.println("Enter pizza`s description: \n");
                    String about = cons.nextLine();
                    System.out.println("Enter pizza`s price: \n");
                    int p = Integer.valueOf(cons.nextLine());
                    Proto.addNewPizzaRequest req1 = Proto.addNewPizzaRequest.newBuilder().setName(name).setAbout(about).setPrice(p).build();
                    Proto.addNewPizzaResponse res1 = clientGRPC.addNewPizza(req1);
                    System.out.println("ID: " + res1.getId() + "\n");
                    break;
                case"3":
                    System.out.println("Enter pizza`s ID: \n");
                    int id = Integer.valueOf(cons.nextLine());
                    Proto.deletePizzaRequest req2 = Proto.deletePizzaRequest.newBuilder().setId(id).build();
                    Proto.deletePizzaResponse res2 = clientGRPC.deletePizza(req2);
                    System.out.println(res2.getRes());
                    break;
                case"4":
                    System.out.println("Enter order`s ID: \n");
                    int id1 = Integer.valueOf(cons.nextLine());
                    Proto.changeStatusToAtWorkRequest req3 = Proto.changeStatusToAtWorkRequest.newBuilder().setId(id1).build();
                    Proto.changeStatusToAtWorkResponse res3 = clientGRPC.changeStatusToAtWork(req3);
                    System.out.println(res3.getRes());
                    break;
                case"5":
                    System.out.println("Enter order`s ID: \n");
                    int id2 = Integer.valueOf(cons.nextLine());
                    Proto.changeStatusToDoneRequest req4 = Proto.changeStatusToDoneRequest.newBuilder().setId(id2).build();
                    Proto.changeStatusToDoneResponse res4 = clientGRPC.changeStatusToDone(req4);
                    System.out.println(res4.getRes());
                    break;
                default: 
                    System.out.println("Uncorrectly!");
                    break;
            }
        }
        cons.close();
    }
}
