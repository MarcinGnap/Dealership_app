package DbModels;

public class Client {
    public String client_id;
    public String person_id;

    public Client() {
    }

    public Client(String client_id, String person_id) {
        this.client_id = client_id;
        this.person_id = person_id;
    }

    public String getId(){
        return  this.client_id;
    }
}
