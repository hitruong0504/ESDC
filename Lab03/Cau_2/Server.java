import java.rmi.registry.*;
import java.rmi.server.*;

public class Server{
    public static void main(String[] args) {
        try{
            if(args.length != 1){
                System.err.println("Usage: java Server <port>");
                System.exit(1);
            }
            int index = 0;
            int port = Integer.parseInt(args[index++]);
            ImplCalculator obj = new ImplCalculator();
            Calculator skeleton = (Calculator) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind("Calculator", skeleton);
            System.err.println("Server ready");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}