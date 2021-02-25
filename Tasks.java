import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Random;

public class Tasks {
    //Завдання №1
    public void MaxSalary(Firm firm){
        try{
            System.out.println(DoMaxSalary(firm)+"$");
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
    public float DoMaxSalary(Firm firm) {
        if (firm.getDepartments().size()==0){
            if (firm.getOwner().isEmpty()) {
                throw new IllegalArgumentException("Фірма не має робітників");
            }
            else {
                throw new IllegalArgumentException("На фірмі є лише власник зі зарплатою 0$");
            }

        }
        int count=0;
        Iterator<Department> cit = firm.getDepartments().iterator();
        while(cit.hasNext()) {
            if (cit.next().getWorkers().size()>0){
                count+=cit.next().getWorkers().size();
            }
        }
        if (count==0){
            throw new IllegalArgumentException("На фірмі взагалі ніхто не працює");
        }
        Iterator iterator = firm.getDepartments().iterator();
        float maxsalary=0f;
        while(iterator.hasNext()) {
            Iterator iter = ((Department)iterator.next()).getWorkers().iterator();
            while (iter.hasNext()){
                float salary=((Worker)iter.next()).getSalary();
                if (salary>maxsalary){
                    maxsalary=salary;
                }

            }
        }
        return maxsalary;
    }
    //Завдання №2
    public void HigherSalary(Firm firm){
        try{
            System.out.println(DoHigherSalary(firm));
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
    public String DoHigherSalary(Firm firm) {
        if (firm.getDepartments().size()==0){
            throw new IllegalArgumentException("Фірма не має відділів та робітників");
        }
        int count=0;
        Iterator<Department> cit = firm.getDepartments().iterator();
        while(cit.hasNext()) {
            if (cit.next().getWorkers().size()>0){
                count+=cit.next().getWorkers().size();
            }
        }
        if (count==0){
            throw new IllegalArgumentException("Фірма має відділи, проте в них жодного працівника");
        }
        HashSet<Department> allDepartments = firm.getDepartments();
        HashSet<Department> deps = new HashSet<Department>(allDepartments);
        deps.remove(allDepartments.size()-1);
        String name="";
        Iterator<Department> dit = firm.getDepartments().iterator();
        while(dit.hasNext()) {
            Department dep = dit.next();
            Iterator<Worker> witer = dep.getWorkers().iterator();
            while (witer.hasNext()){
                Worker worker = witer.next();
                float chiefsalary=dep.getWorkers().
                float workersalary = worker.getSalary();
                if (workersalary>chiefsalary){
                    name+=dep.getName()+" ";
                }
            }
        }
        for (Department d : deps ) {
            for (Worker w : d.getWorkers()) {
                int depidx = deps.get(d) + 1;
                float chiefsalary=allDepartments.get(allDepartments.size()-1).getWorkers().get(depidx).getSalary();
                float workersalary = w.getSalary();
                if (workersalary>chiefsalary){
                    name+=d.getName()+" ";
                }

            }
        }
        return name;
    }
    //Завдання №3
    public void WorkersList(Firm firm){
        try{
            System.out.println(DoWorkersList(firm).toString());
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
    public HashSet<String> DoWorkersList(Firm firm) {
        if (firm.getDepartments().size()==0){
            if (firm.getOwner().isEmpty()) {
                throw new IllegalArgumentException("Фірма не має робітників");
            }
            else {
                throw new IllegalArgumentException(firm.getOwner());
            }
        }
        int count=0;
        Iterator<Department> cit = firm.getDepartments().iterator();
        while(cit.hasNext()) {
            if (cit.next().getWorkers().size()>0){
                count+=cit.next().getWorkers().size();
            }
        }
        if (count==0){
            throw new IllegalArgumentException("На фірмі взагалі ніхто не працює");
        }
        HashSet<String> allWorkersList = new HashSet<>();
        Iterator<Department> iterator = firm.getDepartments().iterator();
        while(iterator.hasNext()) {
            Department dep = iterator.next();
            Iterator<Worker> iter = dep.getWorkers().iterator();
            while (iter.hasNext()){
                Worker worker = iter.next();
                allWorkersList.add(worker.getName() +" "+ worker.getSurname());
            }
        }
        return allWorkersList;
    }
    public void AwardsList(Firm firm){
        try{
            System.out.println(DoAwardsList(firm).toString());
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
    public TreeMap<String, Integer> DoAwardsList(Firm firm){
        Iterator<Department> iterator = firm.getDepartments().iterator();
        TreeMap<String, Integer> awlist = new TreeMap<>();
        Random rand = new Random();
        while(iterator.hasNext()) {
            Department dep = iterator.next();
            Iterator<Worker> iter = dep.getWorkers().iterator();
            while (iter.hasNext()){
                int award = rand.nextInt(2000);
                Worker worker = iter.next();
                awlist.put(worker.getName() +" "+ worker.getSurname(),award);
            }
        }
        return awlist;
    }
}