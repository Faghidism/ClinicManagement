import java.util.ArrayList;

public class Section {
    private String name;
    private Purpose purpose;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    private Nurse nurse;


    public Section(String name, Purpose purpose){
        this.name = name;
        this.purpose = purpose;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }


    public void setNurse(Nurse nurse){
        this.nurse = nurse;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeNurse() {
        nurse = null;
    }

    public void printDoctors(){
        for (int i = 0;i < doctors.size();i++)
            System.out.println(String.valueOf(i + 1 )+ ". " + doctors.get(i).getName());
    }

    public void printPatients(){
        for (int i = 0;i < patients.size();i++)
            System.out.println(String.valueOf(i + 1 )+ ". " + patients.get(i).getName());
    }

    public void removePatient(int patientIndex) {
        patients.remove(patientIndex);
    }
}
