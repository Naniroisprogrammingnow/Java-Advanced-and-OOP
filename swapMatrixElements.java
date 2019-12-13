import java.util.Arrays;
import java.util.Scanner;
public class swapMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] dim = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dim[0];
        int cols = dim[1];
        String[][] matrix = new String[dim[0]][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        String command = scanner.nextLine();
        while(!command.equals("END")){
            if(command.indexOf("swap")!=0){
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }else{
                command=command.substring(5);
            }
            String [] tokens = command.split(" ");
            if(tokens.length!=4){
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }
            int initialRow = Integer.parseInt(tokens[0]);
            int initialCol = Integer.parseInt(tokens[1]);
            int destinationRow = Integer.parseInt(tokens[2]);
            int destinationCol = Integer.parseInt(tokens[3]);
            if(initialRow<rows && initialCol<cols
                    && destinationCol<cols && destinationRow<rows){
                matrix = swapElements(initialRow, initialCol, destinationRow, destinationCol, matrix);
            }else{
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            printMatrix(matrix);
            command=scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] swapElements(int initialRow, int initialCol, int destinationRow, int destinationCol, String[][] matrix) {
       String temp = matrix[initialRow][initialCol];
       matrix[initialRow][initialCol]=matrix[destinationRow][destinationCol];
       matrix[destinationRow][destinationCol]=temp;
       return matrix;
    }


}
