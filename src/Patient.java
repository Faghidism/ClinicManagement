public class Patient extends User{
    private PatientType patientType;
    private int wallet;
    public Patient(String name, String username, String password,int wallet,PatientType patientType) {
        super(name, username, password);
        this.wallet = wallet;
        this.patientType = patientType;
    }


    //TODO:

    public void payDoctorsFee(){

    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }

    public int getWallet() {
        return wallet;
    }

    public void addWallet(int wallet) {
        this.wallet += wallet;
    }
}
