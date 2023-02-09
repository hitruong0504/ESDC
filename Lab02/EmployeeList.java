import java.io.*;
import java.util.ArrayList;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private int ID;

    public Employee(String name, String address, int ID) {
        this.name = name;
        this.address = address;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getID() {
        return ID;
    }
}

public class EmployeeList {
    public static void serializeEmployeeList(ArrayList<Employee> arr, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(arr);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static ArrayList<Employee> deserializeEmployeeList(String fileName) {
        ArrayList<Employee> arr = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            arr = (ArrayList<Employee>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return null;
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Employee> arr = new ArrayList<>();
        arr.add(new Employee("Kelvin", "TDTU", 1));
        arr.add(new Employee("Harry", "TDTU", 2));
        arr.add(new Employee("Jeremy", "TDTU", 3));

        String fileName = "employee_list.ser";
        serializeEmployeeList(arr, fileName);

        ArrayList<Employee> deserializedArr = deserializeEmployeeList(fileName);
        if (deserializedArr != null) {
            for (Employee e : deserializedArr) {
                System.out.println("Name: " + e.getName());
                System.out.println("Address: " + e.getAddress());
                System.out.println("ID: " + e.getID());
                System.out.println();
            }
        }
    }
}
