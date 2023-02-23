import java.rmi.RemoteException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ImplPersonServices implements PersonService {
    private ArrayList<Person> people;

    public ImplPersonServices() throws IOException {
        people = new ArrayList<Person>();
        try{
            try (BufferedReader br = new BufferedReader(new FileReader("app_c_new.csv"))) {
                String line = br.readLine();
                while((line = br.readLine()) != null){
                    String[] data = line.split(",");
                    String surname = data[0].trim();
                    int count = Integer.parseInt(data[1].trim());
                    double pctwhite = Double.parseDouble(data[2].trim());
                    people.add(new Person(surname, count, pctwhite));
                }
            }
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }

    @Override
    public boolean findSurname(String surname) throws RemoteException {
        // TODO Auto-generated method stub
        for(Person p : people){
            if(p.getSurname().equals(surname)){
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<String> findPctwhite(double pctwhite) throws RemoteException {
        // TODO Auto-generated method stub
        ArrayList<String> result = new ArrayList<String>();
        for(Person p : people){
            if(p.getPctwhite() < pctwhite){
                result.add(p.getSurname());
            }
        }
        return result;
    }

    @Override
    public ArrayList<Person> findList(int number) throws RemoteException {
        // TODO Auto-generated method stub
        ArrayList<Person> result = new ArrayList<Person>();
        for (Person p : people) {
            if (p.getCount() > number) {
                result.add(p);
            }
        }
        return result;
    }
}