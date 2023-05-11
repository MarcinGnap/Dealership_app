package Services;

import DbModels.Client;
import DbModels.Person;

import java.util.ArrayList;

public class PersonService {
    public static void addPerson(String personId , String address, String birthDate, String firstName, String last_name, String pesel, String password, String person_type){
        DatabaseConnector db = new DatabaseConnector();
        db.addPerson(new Person(personId,address,birthDate,firstName,last_name,pesel,password,person_type));
    }

    public static ArrayList<Client> getClient(int personId){
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getClient(personId), Client.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
