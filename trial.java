import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class trial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i]=Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[]coord = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wrongVal = matrix[coord[0]][coord[1]];
        List<String> adresses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==wrongVal){
                    String adress = ""+ i + " " + j;
                    adresses.add(adress);
                }
            }
        }
        for (int i = 0; i < adresses.size(); i++) {
            int[] coordCurr = Arrays.stream(adresses.get(i).split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = coordCurr[0];
            int col = coordCurr[1];
            int newVal = 0;
            if(isPossible(matrix, row, col-1) && isValid(matrix, row, col-1, wrongVal)
            && !hasBeenWrong(adresses, row, col-1)){
                newVal+=matrix[row][col-1];
            }
            if(isPossible(matrix, row, col+1) && isValid(matrix, row, col+1, wrongVal)
                    && !hasBeenWrong(adresses, row, col+1)){
                newVal+= matrix[row][col+1];
            }
            if(isPossible(matrix, row-1, col) && isValid(matrix, row-1, col, wrongVal)
                    && !hasBeenWrong(adresses, row-1, col)){
                newVal+=matrix[row-1][col];
            }
            if(isPossible(matrix, row+1, col) && isValid(matrix, row+1, col, wrongVal)
                    && !hasBeenWrong(adresses, row+1, col)){
                newVal+=matrix[row+1][col];
            }
            matrix[row][col]=newVal;
        }
        print(matrix);
    }

    private static boolean hasBeenWrong(List<String> adresses, int row, int col) {
        String adress = "" + row + " " + col;
        if(adresses.contains(adress)){
            return true;
        }
        return false;
    }

    private static void print(int[][]matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isPossible(int[][] matrix, int row, int col) {
        if(row>=0 && row<matrix.length && col>=0 && col<matrix[row].length){
            return true;
        }
        return false;
    }

    private static boolean isValid(int[][] matrix, int row, int col, int wrong) {
        if(matrix[row][col]!=wrong){
            return true;
        }
        return false;
    }


}
