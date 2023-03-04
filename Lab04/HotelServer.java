import java.rmi.registry.*;
import java.rmi.server.*;

public class HotelServer {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Usage: java HotelServer <port>");
                System.exit(1);
            }
            int port = Integer.parseInt(args[0]);
            RoomManagerImpl obj = new RoomManagerImpl();
            RoomManager skeleton = (RoomManager) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("RoomManager", skeleton);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
