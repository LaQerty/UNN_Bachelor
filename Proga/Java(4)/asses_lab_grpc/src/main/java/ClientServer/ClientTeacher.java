package ClientServer;

import ClientServer.prt1.Proto;
import ClientServer.prt1.ProtoServerGrpc;
import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;

public class ClientTeacher {
    public static void main(String[] args) {
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        ProtoServerGrpc.ProtoServerBlockingStub clientGRPC = ProtoServerGrpc.newBlockingStub(channel);
        Scanner scan = new Scanner(System.in);
        String str = "";
        Empty request = Empty.newBuilder().build();
        while(str != "exit"){
            System.out.println(" You login like teacher. Сhoose option: \n 1)allLabs \n 2)getAllMarks \n 3)getFile \n 4)getAverageMark \n");
            str = scan.nextLine();
            switch (str) {
                case "allLabs":
                    Proto.getAllLabResponse res1 = clientGRPC.getAllLab(request);
                    String[] names = res1.getName().split(",");
                    int count = res1.getId();
                    for(int i = 0; i <= count; i++){
                        System.out.println("Name: " + names[i] + " ID: " + i + "\n");
                    }
                    break;
                case "getAllMarks":
                    System.out.println("Write lab`s id: ");
                    String i = scan.nextLine();
                    int id = Integer.valueOf(i);
                    Proto.getAllMarkRequest req2 = Proto.getAllMarkRequest.newBuilder().setId(id).build();
                    Proto.getAllMarkResponse res2 = clientGRPC.getAllMark(req2);
                    String[] names1 = res2.getName().split(",");
                    String[] marks = res2.getMark().split(",");
                    for(int j = 0; j < marks.length; j++){
                        System.out.println("Estimator: " + names1[j] + ", mark: " + marks[j] + "\n");
                    }
                    break;
                case "getFile":
                    System.out.println("Write lab`s id: ");
                    String i1 = scan.nextLine();
                    int id1 = Integer.valueOf(i1);
                    Proto.getFileRequest req3 = Proto.getFileRequest.newBuilder().setId(id1).build();
                    Proto.getFileResponse res3 = clientGRPC.getFile(req3);
                    System.out.println("Lab`s text: " + res3.getLab());
                    break;
                case "getAverageMark":
                    System.out.println("Write lab`s id: ");
                    String i2 = scan.nextLine();
                    int id2 = Integer.valueOf(i2);
                    Proto.getAverageMarkRequest req4 = Proto.getAverageMarkRequest.newBuilder().setId(id2).build();
                    Proto.getAverageMarkResponse res4 = clientGRPC.getAverageMark(req4);
                    System.out.println("Average mark: " + res4.getRes());
                    break;
                default:
                    System.out.println("Uncorrectly");
                    break;    
            }
        }
    }
}
