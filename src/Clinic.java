import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Clinic implements Services{
    private String name;
    private WorkHoursPolicy workHoursPolicy;
    private Manager manager;
    private ArrayList<Section> sections;
    private ArrayList<User> users;


    public Clinic(String name, WorkHoursPolicy workHoursPolicy) {
        this.name = name;
        this.workHoursPolicy = workHoursPolicy;
        sections = new ArrayList<>();
        users = new ArrayList<>();

        Database.clinics.add(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkHoursPolicy getWorkHoursPolicy() {
        return workHoursPolicy;
    }

    public void setWorkHoursPolicy(WorkHoursPolicy workHoursPolicy) {
        this.workHoursPolicy = workHoursPolicy;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
        users.add(manager);
    }

    public ArrayList<Section> getSections() {
        return sections;
    }




    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }


    public void printSections(){
        for (int i = 0;i < sections.size();i++)
            System.out.println(String.valueOf(i + 1 )+ ". " + sections.get(i).getName());
    }

    public static Section findDoctorsSection(Doctor doctor,int clinicIndex){
        for (Section section:
             Database.clinics.get(clinicIndex).getSections()) {
            if(section.getDoctors().contains(doctor))
                return section;
        }

        return null;
    }

    @Override
    public void findDoctor() {

    }

    @Override
    public void findNurse() {

    }

    @Override
    public void checkUsername() {

    }

    @Override
    public void checkPassword() {

    }
}
