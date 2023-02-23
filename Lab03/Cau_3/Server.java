import java.rmi.registry.*;
import java.rmi.server.*;

public class Server{
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Usage: java Server <port>");
                System.exit(1);
            }
            int index = 0;
            int port = Integer.parseInt(args[index++]);
            ImplPersonServices obj = new ImplPersonServices();
            PersonService skeleton = (PersonService) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind("PersonService", skeleton);
            System.err.println("Server ready");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.toString());
        }
    }
}