import java.rmi.*;
import java.util.ArrayList;

public interface RoomManager extends Remote{
    public String logIn(String username, String password) throws RemoteException;
    public String logOut(String token) throws RemoteException;
    public String listRooms(String token) throws RemoteException;
    public boolean book(String token, int room_type, String guest_name, String ssn) throws RemoteException;
    public ArrayList<String> listGuests(String token) throws RemoteException;
}
