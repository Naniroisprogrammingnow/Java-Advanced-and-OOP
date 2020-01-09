import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .mapToInt(e->Integer.parseInt(e)).toArray();
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr, int beginning, int end) {
        if (beginning>=end){
            return;
        }
        int pivot = arr[(beginning+end)/2];
        int index = partition(arr, beginning, end, pivot);
        quickSort(arr, beginning, index-1);
        quickSort(arr, index, end);
    }

    private static int partition(int[] arr, int beginning, int end, int pivot) {
        while (beginning<=end){
            while (arr[beginning]<pivot){
                beginning++;
            }
            while (arr[end]>pivot){
                end--;
            }
            if (beginning<=end){
                swap(arr, beginning, end);
                beginning++;
                end--;
            }
        }
        return beginning;
    }

    private static void swap(int[] arr, int beginning, int end) {
        int temp = arr[beginning];
        arr[beginning] = arr[end];
        arr[end] = temp;
    }
}
