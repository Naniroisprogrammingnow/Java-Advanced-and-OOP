import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class mathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, input);
        int counter = 1;
        int n = Integer.parseInt(scanner.nextLine());
        while(children.size()>1){
            for (int i = 1; i < n; i++) {
                String curr = children.remove();
                children.offer(curr);
                }
            String name = children.peek();
            if(!isPrime(counter) || counter==1){
                children.remove();
                System.out.println("Removed " + name);
            }else{
                System.out.println("Prime " + name);
            }
            counter++;
        }
        System.out.println("Last is " + children.peek());
    }

    private static boolean isPrime(int counter) {
        for (int i = 2; i < counter; i++) {
            if(counter%i==0){
                return false;
            }
        }
        return true;
    }
}
