public class Room {
    private int number;
    private int type;
    private int price;
    private Guest guest;

    public Room(int number, int type, int price) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.guest = null;
    }

    public Room(int type, int price) {
        this.type = type;
        this.price = price;
        this.guest = null;
    }

    public int getNumber() {
        return number;
    }

    public int getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String toString() {
        return  guest + " At room: " + number + " Type: " + type + " Price: " + price;
    }
}