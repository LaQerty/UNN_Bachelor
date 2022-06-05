package ClientServer;

import ClientServer.prt1.Proto;
import ClientServer.prt1.ProtoServerGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;

public class ClientChild {
    public static void main(String[] args) {
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        ProtoServerGrpc.ProtoServerBlockingStub clientGRPC = ProtoServerGrpc.newBlockingStub(channel);
        Scanner scan = new Scanner(System.in);
        String str = "";
        while(str != "exit"){
            System.out.println(" You login like children. Сhoose option: \n 1)addFile \n 2)get3Id \n 3)getFile \n 4)setMark \n 5)getAverageMark \n");
            str = scan.nextLine();
            switch (str) {
                case "addFile":
                    System.out.println("Write your name: ");
                    String name = scan.nextLine();
                    System.out.println("Write text from your lab: ");
                    String lab = scan.nextLine();
                    Proto.addFileRequest req1 = Proto.addFileRequest.newBuilder().setName(name).setLab(lab).build();
                    Proto.addFileResponse res1 = clientGRPC.addFile(req1);
                    System.out.println("You add file with id: " + res1.getId());
                    break;
                case "get3Id":
                    System.out.println("Write your name: ");
                    String name1 = scan.nextLine();
                    Proto.getIdForEstimateRequest req2 = Proto.getIdForEstimateRequest.newBuilder().setName(name1).build();
                    Proto.getIdForEstimateResponse res2 = clientGRPC.getIdForEstimate(req2);
                    System.out.println("You can estimate lab with id: " + res2.getId1() + "," + res2.getId2() + "," + res2.getId3());
                    break;
                case "getFile":
                    System.out.println("Write lab`s id: ");
                    String i = scan.nextLine();
                    int id = Integer.valueOf(i);
                    Proto.getFileRequest req3 = Proto.getFileRequest.newBuilder().setId(id).build();
                    Proto.getFileResponse res3 = clientGRPC.getFile(req3);
                    System.out.println("Lab`s text: " + res3.getLab());
                    break;
                case "setMark":
                    System.out.println("Write lab`s id: ");
                    String i1 = scan.nextLine();
                    int id1 = Integer.valueOf(i1);
                    System.out.println("Write your name: ");
                    String name2 = scan.nextLine();
                    System.out.println("Write mark: ");
                    String m = scan.nextLine();
                    int mark = Integer.valueOf(m);
                    Proto.setMarkRequest req4 = Proto.setMarkRequest.newBuilder().setId(id1).setName(name2).setMark(mark).build();
                    Proto.setMarkResponse res4 = clientGRPC.setMark(req4);
                    System.out.println(res4.getRes());
                    break;
                case "getAverageMark":
                    System.out.println("Write lab`s id: ");
                    String i2 = scan.nextLine();
                    int id2 = Integer.valueOf(i2);
                    Proto.getAverageMarkRequest req5 = Proto.getAverageMarkRequest.newBuilder().setId(id2).build();
                    Proto.getAverageMarkResponse res5 = clientGRPC.getAverageMark(req5);
                    System.out.println("Average mark: " + res5.getRes());
                    break;
                default:
                    System.out.println("Uncorrectly");
                    break;    
            }
        }
    }
}
