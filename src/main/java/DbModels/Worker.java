package DbModels;

public class Worker {
    public String worker_id;
    public String person_id;
    public String job_position;

    public Worker() {
    }

    public Worker(String worker_id, String person_id, String job_position) {
        this.worker_id = worker_id;
        this.person_id = person_id;
        this.job_position = job_position;
    }

    public String getId(){
        return  this.worker_id;
    }

    @Override
    public String toString(){
        return this.worker_id+" "+this.job_position;
    }
}
