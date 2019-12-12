import java.util.Arrays;
import java.util.Scanner;
public class position {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dim[0]][];
        for (int i = 0; i < dim[0]; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int special = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==special){
                    found = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if(!found){
            System.out.println("not found");
        }
    }
}
