import java.util.Arrays;
import java.util.Scanner;
public class DiagonalsSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int dim = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dim][];
        for (int i = 0; i < dim; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] upperDiagonal = new int[dim];
        int[] lowerDiagonal = new int[dim];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i==j){
                    upperDiagonal[i]=matrix[i][j];
                }
                if(i+j==dim-1){
                    lowerDiagonal[j]=matrix[i][j];
                }
            }
        }
        for (int i = 0; i < upperDiagonal.length; i++) {
            System.out.print(upperDiagonal[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < lowerDiagonal.length; i++) {
            System.out.print(lowerDiagonal[i]+ " ");
        }
    }
}
