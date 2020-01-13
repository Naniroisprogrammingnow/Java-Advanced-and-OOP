public class StudentSystem {
    private StudentRepository repo;

    public StudentSystem()
    {
        this.repo = new StudentRepository();
    }

    public void ParseCommand(String[]args)
    {
//        Scanner scanner = new Scanner(System.in);
//        String[] args = scanner.nextLine().split(" ");
        Command command = CommandFactory.createCommand(args[0]);
        command.execute(this.repo, args);
    }
}
