import java.io.*;

public class Picture {

    public static void serializeImage(String inputFile, String outputFile) {
        try {
            FileInputStream fileIn = new FileInputStream(inputFile);
            byte[] imageBytes = new byte[fileIn.available()];
            fileIn.read(imageBytes);
            fileIn.close();

            FileOutputStream fileOut = new FileOutputStream(outputFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(imageBytes);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + outputFile);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void deserializeImage(String inputFile, String outputFile) {
        try {
            FileInputStream fileIn = new FileInputStream(inputFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            byte[] deserializedImageBytes = (byte[]) in.readObject();
            in.close();
            fileIn.close();

            FileOutputStream fileOut = new FileOutputStream(outputFile);
            fileOut.write(deserializedImageBytes);
            fileOut.close();
            System.out.println("Deserialized data is saved in " + outputFile);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("byte[] class not found");
            c.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // serializeImage("myPicture.png", " picture.ser");
        deserializeImage("_picture.ser", "deserialized_ picture.png");
    }
}
