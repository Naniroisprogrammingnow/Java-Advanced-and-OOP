import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
public class checkLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e->Integer.parseInt(e)).toArray();
        int[] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e->Integer.parseInt(e)).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < Math.min(nums[0],line.length); i++) {
            stack.push(line[i]); //ako nums[0]> line.lenght?
        }
        for (int i = 0; i < nums[1]; i++) {
            if(!stack.isEmpty()){
                stack.pop();
            }else{
                break;
            }
        }
        if(stack.isEmpty()){
            System.out.println(0);
            return;
        }
        if(stack.contains(nums[2])){
            System.out.println("true");
        }else{
            int min = Integer.MAX_VALUE;
            for(Integer e:stack){
                if(e<min){
                    min=e;
                }
            }
            System.out.println(min);
        }

    }
}
