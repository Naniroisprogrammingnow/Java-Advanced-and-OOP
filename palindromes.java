import java.util.Arrays;
import java.util.Scanner;
public class palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] info = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[info[0]][info[1]];
        char frame = 'a';

        for (int rows = 0; rows < matrix.length; rows++) {
            char center = frame;
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                String  current = "" + frame + center + frame;
                matrix[rows][cols]=current;
                center++;
            }
            frame++;
        }
        printMatrix(matrix);
    }
    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
