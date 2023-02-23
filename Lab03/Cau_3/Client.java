import java.rmi.registry.*;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        try {
            if (args.length != 4) {
                System.out.println(
                        "Usage: java Client <host> <port> find <surname> \n or java Client <host> <port> pctwhite <number> \n or java Client <host> <port> list <number>");
                System.exit(1);
            }
            int index = 0;
            String host = args[index++];
            int port = Integer.parseInt(args[index++]);
            String command = args[index++];
            String arg = args[index++];
            Registry registry = LocateRegistry.getRegistry(host, port);
            PersonService stub = (PersonService) registry.lookup("PersonService");
            if (command.equals("find")) {
                boolean result = stub.findSurname(arg);
                System.out.println("Result: " + result);
            } else if (command.equals("pctwhite")) {
                System.out.println("pctwhite: " + arg);
                double pctwhite = Double.parseDouble(arg);
                ArrayList<String> result = stub.findPctwhite(pctwhite);
                for (String s : result) {
                    System.out.println(s);
                }
            } else if (command.equals("list")) {
                int number = Integer.parseInt(arg);
                ArrayList<Person> result = stub.findList(number);
                for (Person p : result) {
                    System.out.println(p);
                }
            } else {
                System.out.println("Unknown command");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.toString());
        }
    }
}
