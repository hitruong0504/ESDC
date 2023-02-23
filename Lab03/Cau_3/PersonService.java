import java.util.*;
import java.rmi.*;

public interface PersonService extends Remote{
    public boolean findSurname(String surname) throws RemoteException;
    public ArrayList<String> findPctwhite(double pctwhite) throws RemoteException;
    public ArrayList<Person> findList(int count) throws RemoteException;
}