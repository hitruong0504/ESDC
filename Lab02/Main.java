import java.io.*;

interface Instrument {
    void play();
}

class Guitar implements Instrument, Serializable {
    private static final long serialVersionUID = 1L;
    private String sound;

    public Guitar(String sound) {
        this.sound = sound;
    }

    public void play() {
        System.out.println("Guitar: " + sound);
    }
}

class Piano implements Instrument, Serializable {
    private static final long serialVersionUID = 2L;
    private String sound;

    public Piano(String sound) {
        this.sound = sound;
    }

    public void play() {
        System.out.println("Piano: " + sound);
    }
}

class Trumpet implements Instrument, Serializable {
    private static final long serialVersionUID = 3L;
    private String sound;

    public Trumpet(String sound) {
        this.sound = sound;
    }

    public void play() {
        System.out.println("Trumpet: " + sound);
    }
}

public class Main {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[3];
        instruments[0] = new Guitar("strum");
        instruments[1] = new Piano("plink");
        instruments[2] = new Trumpet("toot");

        try {
            FileOutputStream fileOut = new FileOutputStream("instruments.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(instruments);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in instruments.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        try {
            FileInputStream fileIn = new FileInputStream("instruments.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Instrument[] deserializedInstruments = (Instrument[]) in.readObject();
            in.close();
            fileIn.close();
            for (Instrument instrument : deserializedInstruments) {
                instrument.play();
            }
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Instrument class not found");
            c.printStackTrace();
        }
    }
}
