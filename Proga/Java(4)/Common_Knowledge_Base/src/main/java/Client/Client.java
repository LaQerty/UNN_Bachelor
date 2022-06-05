package Client;

import Server.ServerSide;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
    public static void main(String[] args) throws Exception {
        Service service = Service.create(
        new URL("http://localhost:8080/ckb?wsdl"),
        new QName("http://Server/", "ServerService"));
        ServerSide port = service.getPort(
        new QName("http://Server/", "ServerPort"),
        ServerSide.class);
        boolean flag = true;
        String userWord ="";
        Scanner console = new Scanner(System.in);
        System.out.println("You can: \n1)Create new note\n2)Add marks to note\n3)Add file to note\n4)Create new mark\n"
                + "5)Get file\n6)Delete mark\n7)Get all marks\n8)Get all notes\n9)Find note\n");
        while(flag){
            userWord = console.nextLine();
            switch(userWord){
                case"exit":
                    flag = false;
                    break;
                default:
                    System.out.println("Enter 1-9\n");
                    break;
                case"1":
                    System.out.println("Enter name: \n");
                    String name = console.nextLine();
                    System.out.println("Enter text: \n");
                    String text = console.nextLine();
                    System.out.println(port.createEntry(name, text));
                    break;
                case"2":
                    System.out.println("Enter note`s id: \n");
                    int id = Integer.valueOf(console.nextLine());
                    System.out.println("Enter mark`s ids: \n");
                    String marks = console.nextLine();
                    String [] m = marks.split(" ");
                    ArrayList<Integer> ids = new ArrayList();
                    for(String s : m){
                        ids.add(Integer.valueOf(s));
                    }
                    port.addMarks(id, ids);
                    break;
                case"3":
                    System.out.println("Enter note`s id: \n");
                    id = Integer.valueOf(console.nextLine());
                    System.out.println("Enter file`s name: \n");
                    String fName = console.nextLine();
                    System.out.println("Enter file`s path: \n");
                    String file = console.nextLine();
                    ArrayList<Byte> bytes = new ArrayList();
                    byte[] fi = Files.readAllBytes(Paths.get(file));
                    for(byte f : fi){
                        bytes.add(f);
                    }
                    port.addFile(id, fName, bytes);
                    break;
                case"4":
                    System.out.println("Enter name: \n");
                    name = console.nextLine();
                    System.out.println(port.createMark(name));
                    break;
                case"5":
                    System.out.println("Enter note`s id: \n");
                    id = Integer.valueOf(console.nextLine());
                    System.out.println("Enter file`s name: \n");
                    fName = console.nextLine();
                    System.out.println("Enter file`s path: \n");
                    String path = console.nextLine();
                    bytes = port.getFile(id, fName);
                    byte[] output = new byte[bytes.size()];
                    for (int i = 0; i < bytes.size(); i++) {
                        output[i] = bytes.get(i);
                    }
                    FileOutputStream out = new FileOutputStream(path);
                    out.write(output);
                    out.close();
                    break;
                case"6":
                    System.out.println("Enter mark`s id: \n");
                    id = Integer.valueOf(console.nextLine());
                    port.deleteMark(id);
                    break;
                case"7":
                    System.out.println(port.getAllMark());
                    break;
                case"8":
                    System.out.println(port.getAllEntry());
                    break;
                case"9":
                    System.out.println("Enter mark`s id: \n");
                    id = Integer.valueOf(console.nextLine());
                    System.out.println(port.getEntryByMark(id));
                    break;
            }
        }
        console.close();
    }
}
