import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    1.sign in
                    2.sign up
                    0.exit
                    """);

            int startingChoice = scanner.nextInt();

            switch (startingChoice) {
                case 1 -> signInMenu(scanner);
                case 2 -> signUpMenu(scanner);
                case 0 -> System.exit(1);
            }
        }

    }

    private static void signInMenu(Scanner scanner) {
        print("clinic");
        Database.printClinics();
        int clinicIndex = scanner.nextInt() - 1;
        User user = null;
        boolean verified = false;
        while (!verified) {
            print("username");
            String username = scanner.next();

            print("password");
            String password = scanner.next();

            user = Database.findUser(username, clinicIndex);
            if (user == null)
                continue;

            if (Database.verifyCredentials(user, username, password))
                verified = true;
        }


        switch (user.getClass().toString()) {
            case "class Doctor" -> doctorMenu(scanner, (Doctor) user,clinicIndex);
            case "class Nurse" -> nurseMenu(scanner, (Nurse) user);
            case "class Patient" -> patientMenu(scanner, (Patient) user);
            case "class Manager" -> managerMenu(scanner, (Manager) user);
        }

    }

    private static void managerMenu(Scanner scanner, Manager manager) {
        boolean finished = false;
        while (!finished) {
            Manager.printFunctions();
            int function = scanner.nextInt();
            switch (function) {
                case 0 :
                    finished = true;
                    break;
                case 1:
                    print("name");
                    String name = scanner.next();

                    printPurposes();
                    int purposeChoice = scanner.nextInt();
                    Purpose purpose = null;
                    switch (purposeChoice) {
                        case 1 -> purpose = Purpose.BIRTH;
                        case 2 -> purpose = Purpose.GENERAL;
                        case 3 -> purpose = Purpose.EMERGENCY;
                    }
                    manager.addSection(name, purpose);
                    break;
                case 2:
                    print("section to remove");
                    manager.getClinic().printSections();
                    int sectionIndex = scanner.nextInt() - 1;
                    manager.removeSection(sectionIndex);
                    break;
                case 3:
                    print("section to add the doctor to");
                    manager.getClinic().printSections();
                    sectionIndex = scanner.nextInt() - 1;

                    print("name");
                    name = scanner.next();

                    print("username");
                    String username = scanner.next();

                    print("password");
                    String password = scanner.next();

                    printSpecialties();
                    int specialtyChoice = scanner.nextInt();
                    Specialty specialty = null;
                    switch (specialtyChoice){
                        case 1 -> specialty = Specialty.PSYCHIATRIST;
                        case 2 -> specialty = Specialty.PEDIATRICS;
                        case 3 -> specialty = Specialty.NEUROLOGIST;
                        case 4 -> specialty = Specialty.ANESTHESIOLOGIST;
                    }

                    print("fee");
                    int fee = scanner.nextInt();

                    manager.hireDoctor(sectionIndex,name,username,password,specialty,fee);
                    break;
                case 4:
                    print("section to add the nurse to");
                    manager.getClinic().printSections();
                    sectionIndex = scanner.nextInt() - 1;

                    print("name");
                    name = scanner.next();

                    print("username");
                    username = scanner.next();

                    print("password");
                    password = scanner.next();

                    manager.hireNurse(sectionIndex,name,username,password);
                    break;
                case 5:
                    print("section to remove the doctor from");
                    manager.getClinic().printSections();
                    sectionIndex = scanner.nextInt() - 1;

                    print("doctor to remove");
                    int doctorIndex = scanner.nextInt() - 1;

                    manager.removeDoctor(sectionIndex,doctorIndex);
                    break;
                case 6:
                    print("section to remove the nurse from");
                    manager.getClinic().printSections();
                    sectionIndex = scanner.nextInt() - 1;

                    manager.removeNurse(sectionIndex);
                    break;
                case 7:

                    break;
                case 8:

                    break;

            }
        }
    }

    private static void printSpecialties() {
        int count = 1;
        for (Specialty specialty :
                Specialty.values()) {
            System.out.println(String.valueOf(count) + ". " + specialty);
            count++;
        }
    }

    private static void printPurposes() {
        int count = 1;
        for (Purpose purpose :
                Purpose.values()) {
            System.out.println(String.valueOf(count) + ". " + purpose);
            count++;
        }
    }

    private static void patientMenu(Scanner scanner, Patient patient) {
    }

    private static void nurseMenu(Scanner scanner, Nurse nurse) {
        boolean finished = false;
        while (!finished) {
            System.out.println("""
                    1.view history
                    0.log out
                    """);
            int functionIndex = scanner.nextInt();

            switch (functionIndex){
                case 1 -> nurse.printHistory();
                case 0 -> finished = true;
            }
        }
    }

    private static void doctorMenu(Scanner scanner, Doctor doctor,int clinicIndex) {
        boolean finished = false;
        while (!finished) {
            Doctor.printFunctions();
            int functionIndex = scanner.nextInt();

            switch (functionIndex) {
                case 0:
                    finished = true;
                    break;
                case 1:
                    Section section = Clinic.findDoctorsSection(doctor, clinicIndex);
                    assert section != null;
                    print("patient to visit");
                    section.printPatients();
                    int patientIndex = scanner.nextInt() - 1;

                    doctor.visitPatient(section, patientIndex);
                    break;
                case 2:
                    System.out.println("your paid salary is " + doctor.getPaidSalary());
                    break;
            }
        }
    }

    private static void signUpMenu(Scanner scanner) {
        print("clinic");
        Database.printClinics();
        int clinicIndex = scanner.nextInt() - 1;

        print("section you want to be added to");
        Database.clinics.get(clinicIndex).printSections();
        int sectionIndex = scanner.nextInt() - 1;


        print("name of the patient");
        String name = scanner.next();

        print("username");
        String username = scanner.next();

        print("password");
        String password = scanner.next();

        print("wallet");
        int wallet = scanner.nextInt();

        printPatientType();
        int patientTypeChoice = scanner.nextInt();
        PatientType patientType = null;

        switch (patientTypeChoice){
            case 1 -> patientType = PatientType.PREGNANT;
            case 2 -> patientType = PatientType.LOW_LEVEL;
            case 3 -> patientType = PatientType.HIGH_LEVEL;
            case 4 -> patientType = PatientType.POISONED;
        }

        Database.clinics.get(clinicIndex).getManager().addPatient(sectionIndex,name,username,password,wallet,patientType);
    }

    private static void printPatientType() {
        int count = 1;
        for (PatientType patientType :
                PatientType.values()) {
            System.out.println(String.valueOf(count) + ". " + patientType);
            count++;
        }
    }

    private static void init() {
        Manager mostafa = new Manager("mostafa", "mostafa1", "1234");
        mostafa.setClinic("hefdahShahrivar", WorkHoursPolicy.ALWAYS_OPEN);

        mostafa.addSection("pregnancy section", Purpose.BIRTH);
        mostafa.hireNurse(-1, "amir", "ami", "dyingofthirst");
        mostafa.hireDoctor(0, "nima", "pashmak12", "pashmak12", Specialty.PEDIATRICS, 70000);
        mostafa.hireDoctor(0, "ahmad", "polo", "bereng", Specialty.ANESTHESIOLOGIST, 40000);
        mostafa.hireDoctor(0, "mohamad", "mohammad", "mohammad", Specialty.ANESTHESIOLOGIST, 70000);
        mostafa.addPatient(0, "farid", "far", "profile", 200000, PatientType.PREGNANT);
        mostafa.addPatient(0, "shakib", "shake", "km12", 200000, PatientType.POISONED);


        mostafa.addSection("General", Purpose.GENERAL);
        mostafa.hireNurse(-1, "parmida", "parmi5623", "password");


        Manager ali = new Manager("ali", "alba", "tank");
        ali.setClinic("rasolAkram", WorkHoursPolicy.NORMAL);


    }

    private static void print(String text) {
        System.out.println("please choose the " + text);
    }
}