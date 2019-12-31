import java.util.ArrayDeque;
import java.util.Scanner;

public class TextEdit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        ArrayDeque<String> done = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] command = input.split("\\s+");
            switch (command[0]){
                case "1":
                    res.append(command[1]);
                    done.push(res.toString());
                    break;
                case "2":
                    int del = Integer.parseInt(command[1]);
                    res.delete(res.length()-del, res.length());
                    done.push(res.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(command[1])-1;
                    if(isValid(index, res)){
                        System.out.println(res.toString().charAt(index));
                    }
                    break;
                case "4":
                    String toUnDo = done.pop();
                    res.delete(0, res.length());
                    res.append(done.peek());
                    break;
            }
        }
    }

    private static boolean isValid(int index, StringBuilder res) {
        if(index>=0 && index<res.length()){
            return true;
        }
        return false;
    }
}
