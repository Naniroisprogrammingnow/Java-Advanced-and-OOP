public class ShowCommand implements Command{
    public void execute(StudentRepository repo, String[] args){
        var name = args[1];
        if (repo.containsStudentName(name))
        {
            var student = repo.getStudent(name);
            System.out.println(student);
        }
    }
}
