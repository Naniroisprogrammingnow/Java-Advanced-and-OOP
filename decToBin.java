import java.util.ArrayDeque;
import java.util.Scanner;

public class decToBin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int num = Integer.parseInt(scanner.nextLine());
        if(num==0){
            System.out.println(0);
            return;
        }
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        while(num>0){
            int curr = num%2;
            arr.push(curr);
            num/=2;
        }
        while (arr.size()>0){
            System.out.print(arr.pop());
        }
    }
}
