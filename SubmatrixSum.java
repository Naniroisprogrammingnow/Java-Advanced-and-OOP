import java.util.Arrays;
import java.util.Scanner;

public class SubmatrixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] dim = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dim[0]][];
        for (int i = 0; i < dim[0]; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int[][] res = new int[2][2];
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j < matrix[i].length-1; j++) {
                sum = matrix[i][j]+matrix[i][j+1]+matrix[i+1][j]+matrix[i+1][j+1];
                if(sum>max){
                    max=sum;
                    res[0][0]= matrix[i][j];
                    res[0][1] = matrix[i][j+1];
                    res[1][0]= matrix[i+1][j];
                    res[1][1]=matrix[i+1][j+1];

                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(max);
    }
}
