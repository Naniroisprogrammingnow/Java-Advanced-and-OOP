package Google;

public class Company {
    String company;
    String department;
    double salary;

    public String getCompany() {
        return company;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Company(String company, String department, double salary) {
        this.company = company;
        this.department = department;
        this.salary = salary;
    }
}
