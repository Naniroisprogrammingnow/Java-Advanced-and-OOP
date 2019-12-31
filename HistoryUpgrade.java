import java.util.ArrayDeque;
import java.util.Scanner;

public class HistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forWard = new ArrayDeque<>();
        String input = scanner.nextLine();
        while(!input.equals("Home")){
            if(input.equals("back")){
                if(history.size()>=2){
                    String temp = history.pop();
                    forWard.offer(temp);
                    System.out.println(history.peek());

                }else{
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            }else if(input.equals("forward")){
                if(!forWard.isEmpty()){
                    String tem = forWard.pollLast();
                    history.push(tem);
                    System.out.println(tem);
                }else{
                    System.out.println("no next URLs");
                }
            }else{
                history.push(input);
                forWard.clear();
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
