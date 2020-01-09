import java.util.Arrays;
        import java.util.Scanner;
public class RecurssiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int [] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e->Integer.parseInt(e)).toArray();
        int index = arr.length-1;
        System.out.println(findSum(arr, index));
    }

    private static int findSum(int[] arr, int index) {
        if (index==0){
            return arr[0];
        }
        return arr[index] + findSum(arr,index-1);
    }
}
