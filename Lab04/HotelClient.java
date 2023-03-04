import java.io.File;
import java.io.FileWriter;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class HotelClient {
    private static final String USAGE = "USAGE: java HotelClient host port -logIn <username> <password>\n" +
            "       java HotelClient host port -list\n" +
            "       java HotelClient host port -book <room_type> <guest_name> [guest_ssn]\n" +
            "       java HotelClient host port -guests\n" +
            "       java HotelClient host port -logOut\n";

    public static void main(String[] args) {
        String token = null;
        File file = new File("log.txt");
        try {
            Scanner myReader = new Scanner(file);
            token = myReader.nextLine();
            myReader.close();
        } catch (Exception e) {
        }
        try {
            if (args.length <= 2) {
                System.out.println(USAGE);
                System.exit(1);
            }
            if (args.length == 3 && args[2].equals("help")) {
                System.out.println(USAGE);
                System.exit(1);
            }
            String host = args[0];
            int port = Integer.parseInt(args[1]);
            String command = args[2];
            Registry registry = LocateRegistry.getRegistry(host, port);
            RoomManager stub = (RoomManager) registry.lookup("RoomManager");

            switch (command) {
                case "-logIn":
                    if (args.length != 5) {
                        System.out.println(USAGE);
                        System.exit(1);
                    }
                    token = stub.logIn(args[3], args[4]);
                    if (token == null) {
                        System.out.println("Login failed");
                    } else {
                        FileWriter myWriter = new FileWriter("log.txt");
                        myWriter.write(token);
                        myWriter.close();
                        System.out.println("Login successful");
                    }
                    break;
                case "-list":
                    if (args.length != 3) {
                        System.out.println(USAGE);
                        System.exit(1);
                    }
                    String rooms = stub.listRooms(token);
                    System.out.println(rooms);
                    break;
                case "-book":
                    if (args.length != 5 && args.length != 6) {
                        System.out.println(USAGE);
                        System.exit(1);
                    }
                    int roomType = Integer.parseInt(args[3]);
                    String guestName = args[4];
                    UUID uuid = UUID.randomUUID();
                    String guestSSN = uuid.toString();
                    if (args.length == 6) {
                        guestSSN = args[5];
                    }
                    Boolean bookingID = stub.book(token, roomType, guestName, guestSSN);
                    if (bookingID) {
                        System.out.println("Booking successful");
                    } else {
                        System.out.println("Booking failed");
                    }
                    break;
                case "-guests":
                    if (args.length != 3) {
                        System.out.println(USAGE);
                        System.exit(1);
                    }
                    ArrayList<String> result = stub.listGuests(token);
                    for (String r : result) {
                        System.out.println(r);
                    }
                    break;
                case "-logOut":
                    if (args.length != 3) {
                        System.out.println(USAGE);
                        System.exit(1);
                    }
                    File fileOut = new File("log.txt");
                    fileOut.delete();
                    System.out.println(stub.logOut(token));
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    System.exit(1);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
