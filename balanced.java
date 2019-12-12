import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class balanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String string = scanner.nextLine();
        ArrayDeque<Character> duplicate = new ArrayDeque<>();

        if(string.length()%2==1){
            System.out.println("NO");
            return;
        }
        boolean balanced = true;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                duplicate.push(ch);
            }else if(ch==')' && duplicate.pop()!='('){
                    balanced=false;
                    break;
                }else if(ch==']' && duplicate.pop()!='['){
                    balanced =false;
                    break;
                }else if(ch=='}' && duplicate.pop()!='{'){
                    balanced = false;
                    break;
                }

        }
        if (balanced){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
