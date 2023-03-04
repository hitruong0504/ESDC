import java.rmi.RemoteException;
import java.util.*;

public class RoomManagerImpl implements RoomManager {
    private ArrayList<Room> rooms;
    /*
     * Map<Room, Integer> type_room
     * Room: type, price
     * Integer: number of rooms
     */
    private Map<Room, Integer> type_room;

    public RoomManagerImpl() {
        rooms = new ArrayList<Room>();
        type_room = new HashMap<Room, Integer>();
        type_room.put(new Room(0, 55), 10);
        type_room.put(new Room(1, 75), 20);
        type_room.put(new Room(2, 80), 5);
        type_room.put(new Room(3, 150), 3);
        type_room.put(new Room(4, 230), 2);

        for (Map.Entry<Room, Integer> entry : type_room.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                // rooms.add(entry.getKey());
                rooms.add(new Room(i, entry.getKey().getType(), entry.getKey().getPrice()));
            }
        }
    }

    @Override
    public String logIn(String username, String password) throws RemoteException {

        if (username.equals("manager") && password.equals("manager")) {
            return "manager";
        }
        else if (username.equals("receptionist") && password.equals("receptionist")) {
            return "receptionist";
        }
        return null;
    }

    @Override
    public String logOut(String token) throws RemoteException {
        if (token.equals("manager") || token.equals("receptionist")) {
            return "Bye Bye";
        }
        return null;
    }

    @Override
    public boolean book(String token, int room_type, String guest_name, String ssn) throws RemoteException {
        if (token != null) {
            for (Room room : rooms) {
                if (room.getType() == room_type && room.getGuest() == null) {
                    room.setGuest(new Guest(guest_name, ssn));
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public ArrayList<String> listGuests(String token) throws RemoteException {
        ArrayList<String> guests = new ArrayList<String>();
        if (token == null) {
            guests.add("You are not logged in yet");
            return guests;
        }
        if (token.equals("manager")) {
            for (Room room : rooms) {
                if (room.getGuest() != null) {
                    guests.add(room.toString());
                }
            }
            if (guests.size() == 0) {
                guests.add("There are no guests");
            }
        } else {
            guests.add("You are not authorized to perform this operation");
        }
        return guests;
    }

    @Override
    public String listRooms(String token) throws RemoteException {
        if (token != null) {
            int[] availableRooms = new int[5];
            for (Room room : rooms) {
                int type = room.getType();
                if (type >= 0 && type <= 4 && room.getGuest() == null) {
                    availableRooms[type]++;
                }
            }
            return "+ " + availableRooms[0] + " rooms of type 0 are available for 55 Euros per night\n"
                    + "+ " + availableRooms[1] + " rooms of type 1 are available for 75 Euros per night\n"
                    + "+ " + availableRooms[2] + " rooms of type 2 are available for 80 Euros per night\n"
                    + "+ " + availableRooms[3] + " rooms of type 3 are available for 150 Euros per night\n"
                    + "+ " + availableRooms[4] + " rooms of type 4 are available for 230 Euros per night";
        } else {
            return "You are not authorized to perform this operation";
        }
    }

}
