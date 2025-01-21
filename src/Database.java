import java.util.ArrayList;

public class Database {
    public static ArrayList<Manager> managers = new ArrayList<>();
    public static ArrayList<Clinic> clinics = new ArrayList<>();



    public static void printManagers(){
        for (int i = 0;i < managers.size();i++)
            System.out.println(String.valueOf(i + 1 )+ ". " + managers.get(i).getName());
    }

    public static void printClinics(){
        for (int i = 0;i < clinics.size();i++)
            System.out.println(String.valueOf(i + 1 )+ ". " + clinics.get(i).getName());
    }


    public static User findUser(String username,int clinicIndex){
        ArrayList<User> users = clinics.get(clinicIndex).getUsers();
        for (int i = 0; i < users.size(); i++)
            if(users.get(i).getUsername().equals(username))
                return users.get(i);

        return null;
    }

    public static boolean verifyCredentials(User user,String username, String password){
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }
}
