import java.util.Arrays;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[]dims = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dims[0]][];
        for (int i = 0; i < dims[0]; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[i]=arr;
        }
        System.out.println(dims[0]);
        System.out.println(dims[1]);
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res+=matrix[i][j];
            }
        }
        System.out.println(res);
    }
}
