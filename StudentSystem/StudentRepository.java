import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> repo;

    public StudentRepository() {
        this.repo = new HashMap<>();
    }

    public boolean containsStudentName(String name) {
        return this.repo.containsKey(name);
    }

    public void register(String name, Student student) {
        this.repo.put(name, student);
    }

    public Student getStudent(String name) {
        return this.repo.get(name);
    }
}