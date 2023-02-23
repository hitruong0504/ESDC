import java.rmi.registry.*;

public class Client {
    public Client() {}

    public static void main(String[] args) {
        try {
            if(args.length != 4) {
                System.err.println("usage: java Client host port name age");
                System.exit(1);
            }

            int index = 0;
            String host = args[index++];
            int port = Integer.parseInt(args[index++]);
            String name = args[index++];
            int age = Integer.parseInt(args[index++]);

            Registry registry = LocateRegistry.getRegistry(host, port);
            Hello stub = (Hello) registry.lookup("Hello");
            String result = stub.printMsg(name, age);
            System.out.println(result);
            System.err.println("Remote method invoked");
        } catch(Exception e) {
            System.err.println(e.toString());
        }
    }
}
