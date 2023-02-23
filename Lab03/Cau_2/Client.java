import java.rmi.registry.*;

public class Client{
    public static void main(String[] args){
        try{
            if(args.length != 5){
                System.err.println("Usage: java Client <host> <port> <op> <op1> <op2>");
                System.exit(1);
            }
            int index = 0;
            String host = args[index++];
            int port = Integer.parseInt(args[index++]);
            String op = args[index++];
            long op1 = Long.parseLong(args[index++]);
            long op2 = Long.parseLong(args[index++]);

            Registry registry = LocateRegistry.getRegistry(host, port);
            Calculator stub = (Calculator) registry.lookup("Calculator");

            long result = 0;
            if(op.equals("add")){
                result = stub.add(op1, op2);
            }else if(op.equals("sub")){
                result = stub.sub(op1, op2);
            }else{
                System.err.println("Invalid operation");
                System.exit(1);
            }
            System.out.println("Result: " + result);
            System.out.println("Remote method invoked");
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }
}