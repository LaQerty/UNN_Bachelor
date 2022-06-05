package Client;

import Server.prt1.Proto;
import Server.prt1.ProtoServerGrpc;
import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        ProtoServerGrpc.ProtoServerBlockingStub clientGRPC = ProtoServerGrpc.newBlockingStub(channel);
        Empty empty = Empty.newBuilder().build();
        Scanner console = new Scanner(System.in);
        String Userword = "";
        System.out.println("Chose your option:\n 1 - user\n 2 - admin\n");
        Userword = console.nextLine();
        if("1".equals(Userword)){
            System.out.println("Hi, user, enter your name: ");
            String name = console.nextLine();
            System.out.println("Hi, user, enter your email: ");
            String email = console.nextLine();
            while(Userword != "exit"){
                System.out.println("Сhoose function: \n 1 - add new request \n 2 - check status by id \n 3 - complited \n"
                        + "4 - reopen \n");
                Userword = console.nextLine();
                switch(Userword){
                    case "1":
                        System.out.println("Enter text: ");
                        String text = console.nextLine();
                        System.out.println("Enter date: ");
                        String date = console.nextLine();
                        Proto.newZaprosRequest req = Proto.newZaprosRequest.newBuilder().setName(name).setText(text).setDate(date).setEmail(email).build();
                        Proto.newZaprosResponse res = clientGRPC.newZapros(req);
                        System.out.println("ID: " + res.getId());
                        break;
                    case "2":
                        System.out.println("Enter id: ");
                        int id = Integer.valueOf(console.nextLine());
                        Proto.getStatusRequest req1 = Proto.getStatusRequest.newBuilder().setId(id).build();
                        Proto.getStatusResponse res1 = clientGRPC.getStatus(req1);
                        System.out.println("Status: " + res1.getStatus());
                        break;
                    case "3":
                        System.out.println("Enter id: ");
                        int id1 = Integer.valueOf(console.nextLine());
                        Proto.compliteRequest req2 = Proto.compliteRequest.newBuilder().setId(id1).build();
                        Proto.compliteResponse res2 = clientGRPC.complite(req2);
                        System.out.println(res2.getRes());
                        break;
                    case "4":
                        System.out.println("Enter id: ");
                        int id2 = Integer.valueOf(console.nextLine());
                        System.out.println("Enter reOpen mark: ");
                        String mark = console.nextLine();
                        Proto.reOpenRequest req3 = Proto.reOpenRequest.newBuilder().setId(id2).setText(mark).build();
                        Proto.reOpenResponse res3 = clientGRPC.reOpen(req3);
                        System.out.println(res3.getRes());
                        break;
                    default: 
                        System.out.println("Not correct!");
                        break;
                }
            }
        } else if("2".equals(Userword)){
            System.out.println("Hi, admin!\n");
            while(Userword != "exit"){
                System.out.println("Сhoose function: \n 1 - all request \n 2 - at work \n 3 - done \n");
                Userword = console.nextLine();
                switch(Userword){
                    case "1":
                        Proto.getAllResponse res = clientGRPC.getAll(empty);
                        System.out.println(res.getRes());
                        break;
                    case "2":
                        System.out.println("Enter id: ");
                        int id = Integer.valueOf(console.nextLine());
                        Proto.atWorkRequest req1 = Proto.atWorkRequest.newBuilder().setId(id).build();
                        Proto.atWorkResponse res1 = clientGRPC.atWork(req1);
                        System.out.println(res1.getRes());
                        break;
                    case "3":
                        System.out.println("Enter id: ");
                        int id1 = Integer.valueOf(console.nextLine());
                        Proto.doneRequest req2 = Proto.doneRequest.newBuilder().setId(id1).build();
                        Proto.doneResponse res2 = clientGRPC.done(req2);
                        System.out.println(res2.getRes());
                        break;
                    default: 
                        System.out.println("Not correct!");
                        break;
                }
            }
        }
        console.close();
    }
}
