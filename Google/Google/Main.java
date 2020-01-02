package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Person> people = new HashMap<>();
        String line;
        while (!"End".equals(line = scanner.nextLine())){
            String[] info = line.split("\\s+");
            Person person;
            if(!people.containsKey(info[0])){
                person = new Person(info[0]);
            }else{
                person = people.get(info[0]);
            }
            if(line.contains("company")){
                String companyName = info[2];
                String department = info[3];
                double salary = Double.parseDouble(info[info.length-1]);
                Company company = new Company(companyName, department, salary);
                person.setCompany(company);
            }else if(line.contains("pokemon")){
                String pokeName = info[2];
                String type = info[3];
                Pokemon pokemon = new Pokemon(pokeName, type);
                person.getPokemonList().add(pokemon);
            }else if(line.contains("parents")){
                String parentName = info[2];
                String birthday = info[3];
                Parent parent = new Parent(parentName, birthday);
                person.getParents().add(parent);
            }else if(line.contains("children")){
                String childName = info[2];
                String birthday = info[3];
                Child child = new Child(childName, birthday);
                person.getChildren().add(child);
            }else{
                String model = info[2];
                String speed = info[3];
                Car car = new Car(model, speed);
                person.setCar(car);
            }
            people.put(info[0],person);
        }
        String name = scanner.nextLine();
        if(people.containsKey(name)){
            Person myPerson = people.get(name);
            System.out.println(myPerson.getName());
            System.out.println("Company: ");
            if(myPerson.getCompany()!=null){
                System.out.println(String.format("%s %s %.2f",
                        myPerson.getCompany().getCompany(),
                        myPerson.getCompany().getDepartment(),
                        myPerson.getCompany().getSalary()));
            }
            System.out.println("Car: ");
            if (myPerson.getCar()!=null){
                System.out.printf("%s %s%n", myPerson.getCar().getModel(),
                        myPerson.getCar().getSpeed());
            }
            System.out.println("Pokemon: ");
            for (Pokemon pokemon : myPerson.getPokemonList()) {
                System.out.printf("%s %s%n", pokemon.getName(), pokemon.getType());
            }
            System.out.println("Parents:");
            for (Parent parent : myPerson.getParents()) {
                System.out.printf("%s %s%n", parent.getName(), parent.getBirthday());
            }
            System.out.println("Children:");
            for (Child child : myPerson.getChildren()) {
                System.out.printf("%s %s%n", child.getName(), child.getBirthday());

            }
        }
    }
}
