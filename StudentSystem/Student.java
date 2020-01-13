public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    @Deprecated
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    @Deprecated
    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    @Deprecated
    public void setGrade(double grade) {
        this.grade = grade;
    }
    @Override
    public String toString(){
        String view = String.format("%s is %s years old.%s",this.getName(),this.getAge(), this.getPerformance());

        return view;
    }

    private String getPerformance() {
        String performance = "";
        if (this.getGrade() >= 5.00)
        {
            performance += " Excellent student.";
        }
        else if (this.getGrade() < 5.00 && this.getGrade() >= 3.50)
        {
            performance += " Average student.";
        }
        else
        {
            performance += " Very nice person.";
        }
        return performance;
    }
}
