package Server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ServInterface {
    @WebMethod
    public String getAllBook();
    @WebMethod
    public String addNewBook(String ISBN, String autors, String year, String publishing, String name);
    @WebMethod
    public String addBook(String ISBN, int c);
    @WebMethod
    public String takeBook(String ISBN);
    @WebMethod
    public String returnBook(String ISBN);
}
