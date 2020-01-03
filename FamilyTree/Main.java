package FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String myInfo = bufferedReader.readLine();
        List<String> relations = new ArrayList<>();
        List<Person> possibleRelatives = new ArrayList<>();
        String line =bufferedReader.readLine();
        while (!"End".equals(line)){
            if(line.contains(" - ")){
                relations.add(line);
            }else{
                String[] tokens = line.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String date = tokens[2];
                Person person = new Person(name, date);
                possibleRelatives.add(person);
            }
            line = bufferedReader.readLine();
        }
        Person myPerson = new Person();
        if(isDate(myInfo)){
            myPerson.setBirthDate(myInfo);
            findName(myPerson, possibleRelatives, myInfo);
        }else{
            myPerson.setName(myInfo);
            findBirthDate(myPerson, possibleRelatives, myInfo);
        }
        for (String relation : relations) {
            String[] arr = relation.split(" - ");
            String parentInfo = arr[0];
            String kidInfo = arr[1];
            if(isThisMyPerson(parentInfo, myPerson)){
                Person myChild = new Person();
                if(isDate(kidInfo)){
                    myChild.setBirthDate(kidInfo);
                    findName(myChild, possibleRelatives, kidInfo);
                    myPerson.getChildren().add(myChild);
                }else{
                    myChild.setName(kidInfo);
                    findBirthDate(myChild,possibleRelatives,kidInfo);
                    myPerson.getChildren().add(myChild);
                }
            }else if(isThisMyPerson(kidInfo, myPerson)){
                Person myParent = new Person();
                if(isDate(parentInfo)){
                    myParent.setBirthDate(parentInfo);
                    findName(myParent, possibleRelatives, parentInfo);
                    myPerson.getParents().add(myParent);
                }else{
                    myParent.setName(parentInfo);
                    findBirthDate(myParent, possibleRelatives, parentInfo);
                    myPerson.getParents().add(myParent);
                }
            }
        }
        System.out.println(String.format("%s %s", myPerson.getName(), myPerson.getBirthDate()));
        System.out.println("Parents:");
        myPerson.getParents().stream()
                .forEach(e-> System.out.println(String.format("%s %s", e. getName(), e. getBirthDate())));
        System.out.println("Children:");
        myPerson.getChildren().stream()
                .forEach(e-> System.out.println(String.format("%s %s", e.getName(), e.getBirthDate())));

    }
    public static Person findBirthDate(Person person, List<Person> possibleRelatives, String name){
        for (Person possibleRelative : possibleRelatives) {
            if(name.equals(possibleRelative.getName())){
                person.setBirthDate(possibleRelative.getBirthDate());
                break;
            }
        }
        return person;
    }

    public static Person findName(Person person, List<Person> possibleRelatives, String date) {
        for (Person possibleRelative : possibleRelatives) {
            if(date.equals(possibleRelative.getBirthDate())){
                person.setName(possibleRelative.getName());
                break;
            }
        }
        return person;
    }

    public static boolean isDate(String s){
        if(s.contains("/")){
            return true;
        }
        return false;
    }
    public static boolean isThisMyPerson(String info,Person myPerson){
        if((info.equals(myPerson.getName()) || info.equals(myPerson.getBirthDate()))){
            return true;
        }
        return false;
    }
}
