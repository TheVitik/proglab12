import java.util.HashSet;

public class Firm {
    private final String name;
    private final String owner;
    private static HashSet<Department> deps;

    public Firm(String name, String owner,HashSet<Department> deps){
        this.name=name;
        this.owner=owner;
        this.deps=deps;
    }
    public String getName(){
        return name;
    }
    public String getOwner(){
        return owner;
    }
    public HashSet<Department> getDepartments(){
        return deps;
    }
    public void setDepartments(HashSet<Department> deps){
        this.deps=deps;
    }
    public void addDepartment(String name,String chief,HashSet<Worker> workers){
        deps.add(new Department(name,chief,workers));
    }
}