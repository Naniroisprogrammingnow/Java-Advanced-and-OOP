import java.util.Arrays;
import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] dim1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dim1[0]][];
        matrix =  createMatrix(dim1[0], dim1[1], scanner);


        int[] dim2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix1 = new int[dim2[0]][dim2[1]];
        matrix1 = createMatrix(dim2[0], dim2[1], scanner);

        if(matrix.length!=matrix1.length){
            System.out.println("not equal");
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            int[] ints1 = matrix[i];
            int[] ints2 = matrix1[i];
            if(ints1.length!=ints2.length){
                System.out.println("not equal");
                return;
            }
            for (int j = 0; j < ints1.length; j++) {
                if(ints1[j]!=ints2[j]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }

    private static int[][] createMatrix(int dim1, int dim2, Scanner scanner) {
        int rows = dim1;
        int cols = dim2;
        int [][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split(" ");
            for (int column = 0; column < cols; column++) {
                matrix[row][column] =Integer.parseInt(arr[column]);
            }
        }
        return matrix;
    }
}
