import java.util.ArrayDeque;
        import java.util.Scanner;

public class Reverse{
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] nums = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
