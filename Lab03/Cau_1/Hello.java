import java.rmi.*;

public interface Hello extends Remote {
    public String printMsg(String name, int age) throws RemoteException;
}
