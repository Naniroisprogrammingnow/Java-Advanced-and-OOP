import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int [] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums[0]; i++) {
            queue.offer(line[i]);
        }
        for (int i = 0; i < nums[1]; i++) {
            queue.poll();
        }
        if(queue.isEmpty()){
            System.out.println(0);
            return;

        }
        if(queue.contains(nums[2])){
            System.out.println(true);
        }else{
                int min = Integer.MAX_VALUE;
                for(Integer e:queue){
                    if(e<min){
                        min=e;
                    }
                }
                System.out.println(min);
            }

    }
}
