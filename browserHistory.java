import java.util.ArrayDeque;
import java.util.Scanner;

public class browserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        String input = scanner.nextLine();
        while(!input.equals("Home")){
            if(input.equals("back")){
                if(history.size()>=2){
                    history.pop();
                    System.out.println(history.peek());
                }else{
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            }else{
                history.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
