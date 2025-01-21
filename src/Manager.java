import javax.print.Doc;

public class Manager extends User {
    private static final long SALARY = 52000000;
    private Clinic clinic;


    public Manager(String name, String username, String password) {
        super(name, username, password);

        Database.managers.add(this);
    }

    public static void printFunctions() {
        System.out.println("""
                1. add section
                2. remove section
                3. hire doctor
                4. hire nurse
                5. remove doctor
                6. remove nurse
                7. pay salary
                8. see payed salary
                9. see history
                0. log out
                """);
    }

    public void setClinic(String name, WorkHoursPolicy workHoursPolicy) {
        clinic = new Clinic(name, workHoursPolicy);
        clinic.setManager(this);
    }

    public void hireNurse(int sectionIndex, String name, String username, String password) {
        if (sectionIndex == -1)
            sectionIndex = clinic.getSections().size() - 1;
        Nurse nurse = new Nurse(name, username, password, clinic.getSections().get(sectionIndex));
        clinic.getSections().get(sectionIndex).setNurse(nurse);
        clinic.getUsers().add(nurse);
    }

    //Todo:
    public void addSection(String name, Purpose purpose) {
        clinic.getSections().add(new Section(name, purpose));
    }


    public void removeSection(int sectionIndex) {
            clinic.getSections().remove(sectionIndex);
    }

    public void hireDoctor(int sectionIndex,String name, String username, String password, Specialty specialty, int fee) {

        Doctor doctor = new Doctor(name, username, password,specialty,fee);
        clinic.getSections().get(sectionIndex).addDoctor(doctor);
        clinic.getUsers().add(doctor);
    }

    public void removeDoctor(int sectionIndex,int doctorIndex) {
        clinic.getSections().get(sectionIndex).getDoctors().remove(doctorIndex);
    }

    public void removeNurse(int sectionIndex) {
        clinic.getSections().get(sectionIndex).removeNurse();
    }

    public void paySalary() {

    }

    public void seeSalaries() {

    }

    public void doctorHistory() {

    }

    public void addPatient(int sectionIndex,String name, String username, String password,int wallet,PatientType patientType){
        Patient patient = new Patient(name,username,password,wallet,patientType);
        clinic.getSections().get(sectionIndex).addPatient(patient);
        clinic.getUsers().add(patient);
    }


    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
}
