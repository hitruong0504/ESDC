public class Guest {
    private String name;
    private String ssn;

    public Guest(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public String toString() {
        return "Guest: " + name + " SSN: " + ssn;
    }
}
