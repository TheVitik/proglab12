import java.util.HashSet;

public class Department {
    private final String name;
    private final String chief;
    private HashSet<Worker> workers;

    public Department(String name, String chief, HashSet<Worker> workers){
        this.name = name;
        this.chief = chief;
        this.workers = workers;
    }
    public String getName() {
        return name;
    }
    public String getChief() {
        return chief;
    }
    public HashSet<Worker> getWorkers() {
        return workers;
    }
    public Worker getWorker(String name, String surname) {
        for (Worker worker : workers) {
            if (name.equals(worker.getName()) && surname.equals(worker.getSurname()))
                return worker;
        }
        return null;
    }
    public void addWorker(String name, String surname, float salary){
        workers.add(new Worker(name,surname,salary));
    }
    public void setWorkers(HashSet<Worker> workers) {
        this.workers = workers;
    }
}