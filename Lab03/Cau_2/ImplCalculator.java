import java.rmi.RemoteException;


public class ImplCalculator implements Calculator {
    public long add(long a, long b) throws RemoteException{
        return a + b;
    }
    public long sub(long a, long b) throws RemoteException{
        return a - b;
    }
}