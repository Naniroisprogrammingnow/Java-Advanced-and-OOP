import java.util.ArrayDeque;
import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacciSeq =  new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            if(i==0 || i==1){
                fibonacciSeq.offer(1L);
            }else{
                long curr = fibonacciSeq.poll() + fibonacciSeq.peek();
                fibonacciSeq.offer(curr);
            }
        }
        System.out.println(fibonacciSeq.pollLast());
    }
}
