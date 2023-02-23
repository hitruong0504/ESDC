import java.rmi.*;

public class ImplHello implements Hello {
    public String printMsg(String name, int age) throws RemoteException {
        return (name + " (" + age + " years old) is trying to contact!");
    }
}
