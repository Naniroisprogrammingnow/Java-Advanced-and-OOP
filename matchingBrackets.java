import java.util.ArrayDeque;
import java.util.Scanner;

public class matchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> indexes = new ArrayDeque<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch =='('){
                indexes.push(i);
            }else if(ch==')'){
                System.out.println(input.substring(indexes.pop(), i+1));
            }
        }
    }
}
