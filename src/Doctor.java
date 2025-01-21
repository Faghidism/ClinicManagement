public class Doctor extends User{
    private Specialty specialty;
    private static final long  SALARY= 22000000;
    private int fee;
    private long paidSalary;


    public Doctor(String name, String username, String password, Specialty specialty, int fee) {
        super(name, username, password);
        this.specialty = specialty;
        this.fee = fee;
        this.paidSalary = 0;
    }

    public static void printFunctions() {
        System.out.println("""
                1. visit patient
                2. seePayedSalary
                0. log out
                """);
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void setPaidSalary(long paidSalary) {
        this.paidSalary = paidSalary;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    //TODO:

    public void visitPatient(Section section,int patientIndex){
        section.getNurse().addHistory(section.getPatients().get(patientIndex));
        section.removePatient(patientIndex);
    }

    public long getPaidSalary() {
        return paidSalary;
    }


}
