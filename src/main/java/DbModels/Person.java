package DbModels;

public class Person {
    public String person_id;
    public String address;
    public String birth_date;
    public String first_name;
    public String last_name;
    public String pesel;
    public String password;
    public String person_type;

    public Person() {
    }

    public Person(String personId , String address, String birthDate, String firstName, String last_name, String pesel, String password, String person_type) {
        this.person_id = personId;
        this.address = address;
        this.birth_date = birthDate;
        this.first_name = firstName;
        this.last_name = last_name;
        this.pesel = pesel;
        this.password = password;
        this.person_type = person_type;
    }

    public String getId(){
        return  this.person_id;
    }
}
