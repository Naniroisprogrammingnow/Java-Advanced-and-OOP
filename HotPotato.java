import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, input);
        int n = Integer.parseInt(scanner.nextLine());
        while(children.size()>1){
            for (int i = 1; i <= n; i++) {
                String curr = children.remove();
                if(i==n){
                    System.out.println("Removed " + curr);
                    break;
                }
                children.offer(curr);
            }
        }
        System.out.println("Last is " + children.peek());
    }
}
