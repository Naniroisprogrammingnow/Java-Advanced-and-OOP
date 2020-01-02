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
        String line;
        List<String> infoDump = new ArrayList<>();
        List<Person> unknownPeople = new ArrayList<>();
        while (!"End".equals(line = bufferedReader.readLine())){
            if(line.contains(" - ")){
                infoDump.add(line);
            }else{
                String[] tokens = line.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String date = tokens[2];
                Person person = new Person();
                person.setName(name);
                person.setBirthDate(date);
                unknownPeople.add(person);
            }
        }
        Person myPerson = new Person();
        if(myInfo.contains("/")){
            myPerson.setBirthDate(myInfo);
            unknownPeople.stream()
                    .filter(r->r.getBirthDate().equals(myInfo))
                    .forEach(r->myPerson.setName(r.getName()));
        }else{
            myPerson.setName(myInfo);
            unknownPeople.stream()
                    .filter(r->r.getName().equals(myInfo))
                    .forEach(r->myPerson.setBirthDate(r.getBirthDate()));
        }
        for (String relation : infoDump) {
            String[] arr = relation.split(" - ");
            String parent = arr[0];
            String kid = arr[1];
            if(parent.equals(myPerson.getName()) || parent.equals(myPerson.getBirthDate())){
                Person myChild = new Person();
                if(kid.contains("/")){
                    myChild.setBirthDate(kid);
                    unknownPeople.stream().filter(r->kid.equals(r.getBirthDate())).forEach(e->myChild.setName(e.getName()));
                    myPerson.getChildren().add(myChild);
                }else{
                    myChild.setName(kid);
                    unknownPeople.stream().filter(r->kid.equals(r.getName())).forEach(e->myChild.setBirthDate(e.getBirthDate()));
                    myPerson.getChildren().add(myChild);
                }
            }else if(kid.equals(myPerson.getName()) || kid.equals(myPerson.getBirthDate())){
                Person myParent = new Person();
                if(parent.contains("/")){
                    myParent.setBirthDate(parent);
                    unknownPeople.stream().filter(r->parent.equals(r.getBirthDate())).forEach(e->myParent.setName(e.getName()));
                    myPerson.getParents().add(myParent);
                }else{
                    myParent.setName(parent);
                    unknownPeople.stream().filter(r->parent.equals(r.getName())).forEach(e->myParent.setBirthDate(e.getBirthDate()));
                    myPerson.getParents().add(myParent);
                }
            }
        }
        System.out.println(String.format("%s %s", myPerson.getName(), myPerson.getBirthDate()));
        System.out.println("Parents:");
        myPerson.getParents().stream().forEach(e-> System.out.println(String.format("%s %s", e. getName(), e. getBirthDate())));
        System.out.println("Children:");
        myPerson.getChildren().stream().forEach(e-> System.out.println(String.format("%s %s", e.getName(), e.getBirthDate())));

    }
}
