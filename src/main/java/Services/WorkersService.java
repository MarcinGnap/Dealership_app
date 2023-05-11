package Services;

import DbModels.Worker;
import Interfaces.JobPosition;

import java.util.ArrayList;

public class WorkersService {
    public static ArrayList<Worker> getCustodians(){
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getWorkersByRole(JobPosition.CUSTODIAN), Worker.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Worker> getWorkers(){
        DatabaseConnector db = new DatabaseConnector();
        try{
            return ResultSetConverter.resultSetToArrayList(db.getWorkers(), Worker.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static void updateWorkerJobPosition(String newJobPosition, String workerId){
        DatabaseConnector db = new DatabaseConnector();
        try{
            db.updateWorkerJobPosition(newJobPosition, workerId);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
