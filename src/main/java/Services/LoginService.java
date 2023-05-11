package Services;

import DbModels.Model;
import DbModels.Person;

import java.util.ArrayList;

public class LoginService {
    public static Person login(String login, String password) {
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.loginPerson(login, password), Person.class).get(0);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
