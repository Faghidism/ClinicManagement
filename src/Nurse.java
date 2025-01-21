import java.util.ArrayList;

public class Nurse extends User{
    private Section section;
    private static final long SALARY = 15000000;
    private ArrayList<Patient> history;


    public Nurse(String name, String username, String password,Section section) {
        super(name, username, password);
        this.section = section;
        history = new ArrayList<>();
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public ArrayList<Patient> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Patient> history) {
        this.history = history;
    }

    public void addHistory(Patient patient) {
        history.add(patient);
    }

    public void printHistory(){
        for (int i = 0;i < history.size();i++)
            System.out.println(String.valueOf(i + 1 )+ ". " + history.get(i).getName());
        System.out.println("\n\n\n\n\n\n");
    }
}
