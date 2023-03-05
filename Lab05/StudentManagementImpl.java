// DO NOT USE PACKAGE

import java.io.*;
import java.rmi.RemoteException;
import java.util.*;

public class StudentManagementImpl implements StudentManagement {
    
    ArrayList<Student> students;
    /*
     * ascendent list and descendent list by gpa
     */
    ArrayList<Student> ASC_list = new ArrayList<>();
    ArrayList<Student> DES_list = new ArrayList<>();

    public StudentManagementImpl()
    {
        this.students = new ArrayList<>();
    }

    public StudentManagementImpl(String dataPath)
    {
        this.students = new ArrayList<>();
        readData(dataPath);
    }

    private void readData(String filePath)
    {
        try
        {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            String readLine = "";
            while ((readLine = br.readLine()) != null)
            {
                // Insert your code here ...
                String[] info = readLine.split("\t");
                Student student = new Student(info[0], info[1], info[2], Double.parseDouble(info[3]), info[4]);
                students.add(student);
            }
            for (Student s : this.students) {
                ASC_list.add(s);
                DES_list.add(s);
            }

            // sort by gpa
            Collections.sort(DES_list, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Double.compare(o2.getGpa(), o1.getGpa());
                }
            });

            Collections.sort(ASC_list, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Double.compare(o1.getGpa(), o2.getGpa());
                }
            });
            
            br.close();
        } catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public int getNoOfStudent() throws RemoteException
    {
        // Insert your code here ...
        return this.students.size();
    }

    @Override
    public int getNoOfStudent_byGender(String gender) throws RemoteException
    {
        // Insert your code here ...
        int count = 0;
        for (Student s : this.students) {
            if(s.getGender().equals(gender)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getNoOfStudent_byMajor(String major) throws RemoteException
    {
        // Insert your code here ...
        int count = 0;
        for (Student s : this.students) {
            if(s.getMajor().equals(major)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getNoOfStudent_byGPA(double gpa) throws RemoteException
    {
        // Insert your code here ...
        int count = 0;
        for (Student s : this.students) {
            if(s.getGpa() < gpa) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Student findStudent_byName(String name) throws RemoteException
    {
        // Insert your code here ...
        for (Student s : this.students) {
            if(s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Student findStudent_byID(String id) throws RemoteException
    {
        // Insert your code here ...
        for (Student s : this.students) {
            if(s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Student> findStudent_byMajor(String major) throws RemoteException
    {
        // Insert your code here ...
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : this.students) {
            if(s.getMajor().equals(major)) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Student> findStudent_byGPA(double GPA) throws RemoteException
    {
        // Insert your code here ...
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : this.students) {
            if(s.getGpa() < GPA) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public double getAvgGPA() throws RemoteException
    {
        // Insert your code here ...
        double sum = 0;
        for (Student s : this.students) {
            sum += s.getGpa();
        }
        return sum/getNoOfStudent();
    }

    @Override
    public Student getHighestGPA_byGender(String gender) throws RemoteException
    {
        // Insert your code here ...
        Student student = new Student();
        student.setGpa(0);
        for (Student s : this.students) {
            if (s.getGender().equals(gender)) {
                if (s.getGpa() > student.getGpa()) {
                    student.copy(s);
                }
            }
        }
        return student;
    }

    @Override
    public Student getHighestGPA_byFName(String fname) throws RemoteException
    {
        // Insert your code here ...
        Student student = new Student();
        student.setGpa(0);
        for (Student s : this.students) {
            if (s.getName().split(" ")[0].equals(fname)) {
                if (s.getGpa() > student.getGpa()) {
                    student.copy(s);
                }
            }
        }
        return student;
    }

    @Override
    public Student getHighestGPA_byLName(String lname) throws RemoteException
    {
        // Insert your code here ...
        Student student = new Student();
        student.setGpa(0);
        for (Student s : this.students) {
            String[] names = s.getName().split(" ");
            if (names[names.length - 1].equals(lname)) {
                if (s.getGpa() > student.getGpa()) {
                    student.copy(s);
                }
            }
        }
        return student;
    }

    @Override
    public Student getHighestGPA_byMajor(String major) throws RemoteException
    {
        // Insert your code here ...
        Student student = new Student();
        student.setGpa(0);
        for (Student s : this.students) {
            if (s.getMajor().equals(major)) {
                if (s.getGpa() > student.getGpa()) {
                    student.copy(s);
                }
            }
        }
        return student;
    }

    @Override
    public Student getLowestGPA_byMajor(String major) throws RemoteException
    {
        // Insert your code here ...
        Student student = new Student();
        student.setGpa(10);
        for (Student s : this.students) {
            if (s.getMajor().equals(major)) {
                if (s.getGpa() < student.getGpa()) {
                    student.copy(s);
                }
            }
        }
        return student;
    }

    @Override
	public ArrayList<Student> getTop10_byGPA() throws RemoteException
	{
        // Insert your code here ...
        ArrayList<Student> found = new ArrayList<>();
        int count = 0;
        for (Student s : DES_list) {
            if (count < 10) {
                found.add(s);
                count++;
            }
        }
        return found;
	}

	@Override
	public ArrayList<Student> getTop10GPA_byGender(String gender) throws RemoteException
	{
        // Insert your code here ...
        ArrayList<Student> found = new ArrayList<>();
        int count = 0;
        for (Student s : DES_list) {
            if (s.getGender().equals(gender) && count < 10) {
                found.add(s);
                count++;
            }
        }
        return found;
	}

	@Override
	public ArrayList<Student> getTop10GPA_byMajor(String major) throws RemoteException
	{
        // Insert your code here ...
        ArrayList<Student> found = new ArrayList<>();
        int count = 0;
        for (Student s : DES_list) {
            if (s.getMajor().equals(major) && count < 10) {
                found.add(s);
                count++;
            }
        }
        return found;
	}

	@Override
	public ArrayList<Student> getLast10GPA_byGender(String gender) throws RemoteException
	{
        // Insert your code here ...
        ArrayList<Student> found = new ArrayList<>();
        int count = 0;
        for (Student s : ASC_list) {
            if (s.getGender().equals(gender) && count < 10) {
                found.add(s);
                count++;
            }
        }
        return found;
	}

	@Override
	public ArrayList<Student> getLast10GPA_byMajor(String major) throws RemoteException
	{
        // Insert your code here ...
        ArrayList<Student> found = new ArrayList<>();
        int count = 0;
        for (Student s : ASC_list) {
            if (s.getMajor().equals(major) && count < 10) {
                found.add(s);
                count++;
            }
        }
        return found;
	}
    
}
