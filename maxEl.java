import java.util.ArrayDeque;
import java.util.Scanner;

public class maxEl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String [] command = scanner.nextLine().split(" ");
            switch (command[0]){
                case "1":
                    stack.push(command[1]);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int max = findMax(stack);
                    System.out.println(max);
                    break;

            }
        }
    }

    private static int findMax(ArrayDeque<String> stack) {
        int res = Integer.MIN_VALUE;
        for (String e: stack) {
            int curr = Integer.parseInt(e);
            if(curr > res){
                res=curr;
            }
        }
        return res;
    }
}
