import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[]arr = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(bufferedReader.readLine());
        int n = binarySearch(arr, 0, arr.length-1, num);
        System.out.println(n);
    }

    private static int binarySearch(int[] arr, int left, int right, int num) {
            if (left==right && arr[left]!=num){
                return -1;
            }

            int middle = (left+right)/2;
            if (arr[middle]==num){
                return middle;
            }
            if (arr[middle]<num){
                return binarySearch(arr,middle+1,right, num);
            }else if(arr[middle]>num){
               return binarySearch(arr,left, middle, num);
            }
            return -1;

    }
}
