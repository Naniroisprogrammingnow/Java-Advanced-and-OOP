import java.util.Arrays;
import java.util.Scanner;
public class Intersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] strings = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j]=strings[j].charAt(0);
            }
        }
        char [][]matrix1 = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] strings = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix1[i][j]=strings[j].charAt(0);
            }
        }
        char[][] res = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]==matrix1[i][j]){
                    res[i][j] = matrix[i][j];
                }else{
                    res[i][j]='*';
                }
            }
        }
        print(res);
    }

    private static void print(char[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
