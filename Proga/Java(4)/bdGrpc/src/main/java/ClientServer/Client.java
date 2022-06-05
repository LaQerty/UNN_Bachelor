package ClientServer;

import ClientServer.prt1.Proto;
import ClientServer.prt1.ProtoServerGrpc;
import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        ProtoServerGrpc.ProtoServerBlockingStub clientGRPC = ProtoServerGrpc.newBlockingStub(channel);
        Empty request = Empty.newBuilder().build();
        Scanner scan = new Scanner(System.in);
        String word = "";
        while(word != "exit"){
            System.out.println("Сhoose \n 1 - add new note \n 2 - add mark to note \n 3 - add file to note \n"
                    + "4 - add new mark \n 5 - get file \n 6 - delete mark \n 7 - all mark \n 8 - all note \n"
                    + "9 - find note by mark \n");
            word = scan.nextLine();
            switch(word){
                case "1":
                    System.out.println("Enter note`s name \n");
                    String name = scan.nextLine();
                    System.out.println("Enter note`s text \n");
                    String text = scan.nextLine();
                    Proto.addNoteRequest req = Proto.addNoteRequest.newBuilder().setName(name).setText(text).build();
                    Proto.addNoteResponse res = clientGRPC.addNote(req);
                    System.out.println("ID: " + res.getId());
                    break;
                case "2":
                    System.out.println("Enter note`s id \n");
                    int id = Integer.valueOf(scan.nextLine());
                    System.out.println("Enter mark`s ids(through a space) \n");
                    String maId = scan.nextLine();
                    Proto.addMarkToNoteRequest req1 = Proto.addMarkToNoteRequest.newBuilder().setId(id).setMarks(maId).build();
                    Proto.addMarkToNoteResponse res1 = clientGRPC.addMarkToNote(req1);
                    System.out.println(res1.getRes());
                    break;
                case "3":
                    System.out.println("Enter note`s id \n");
                    int id1 = Integer.valueOf(scan.nextLine());
                    System.out.println("Enter file`s name: \n");
                    String fName = scan.nextLine();
                    System.out.println("Enter file`s text: \n");
                    String fText = scan.nextLine(); 
                    Proto.addFileToNoteRequest req2 = Proto.addFileToNoteRequest.newBuilder().setId(id1).setName(fName).setFile(fText).build();
                    Proto.addFileToNoteResponse res2 = clientGRPC.addFileToNote(req2);
                    System.out.println(res2.getRes());
                    break;
                case "4":
                    System.out.println("Enter mark`s name \n");
                    String mName = scan.nextLine();
                    Proto.addNewMarkRequest req3 = Proto.addNewMarkRequest.newBuilder().setName(mName).build();
                    Proto.addNewMarkResponse res3 = clientGRPC.addNewMark(req3);
                    System.out.println("ID: " + res3.getId());
                    break;
                case "5":
                    System.out.println("Enter note`s id \n");
                    int id2 = Integer.valueOf(scan.nextLine());
                    System.out.println("Enter file`s name \n");
                    String fName1 = scan.nextLine();
                    Proto.getFileRequest req4 = Proto.getFileRequest.newBuilder().setName(fName1).setId(id2).build();
                    Proto.getFileResponse res4 = clientGRPC.getFile(req4);
                    System.out.println(res4.getFile());
                    break;
                case "6":
                    System.out.println("Enter mark`s id \n");
                    int id3 = Integer.valueOf(scan.nextLine());
                    Proto.deleteMarkRequest req5 = Proto.deleteMarkRequest.newBuilder().setId(id3).build();
                    Proto.deleteMarkResponse res5 = clientGRPC.deleteMark(req5);
                    System.out.println(res5.getRes());
                    break;
                case "7":
                    Proto.getAllMarkResponse res6 = clientGRPC.getAllMark(request);
                    System.out.println("Marks: \n" + res6.getRes());
                    break;
                case "8":
                    Proto.getAllNoteResponse res7 = clientGRPC.getAllNote(request);
                    System.out.println("Notes: \n" + res7.getRes());
                    break;
                case "9":
                    System.out.println("Enter mark`s id \n");
                    int id4 = Integer.valueOf(scan.nextLine());
                    Proto.findNoteRequest req8 = Proto.findNoteRequest.newBuilder().setId(id4).build();
                    Proto.findNoteResponse res8 = clientGRPC.findNote(req8);
                    System.out.println(res8.getRes());
                    break;
            }
        }
    }
}
