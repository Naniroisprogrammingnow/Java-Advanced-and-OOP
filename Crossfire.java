import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] dim = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dim[0];
        int cols = dim[1];
        List<List<Integer>> matrix = generateMatrix(rows, cols);

        String command = scanner.nextLine();
        while(!command.equals("Nuke it from orbit")){
            int[] target = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int r = target[0];
            int c = target[1];
            int radius = target[2];
            for (int i = r-radius; i <= r+radius; i++) {
                if(isInBounds(matrix, c, i)){
                    matrix.get(i).set(c, 0);
                }
            }
            for (int i =  c-radius; i <= c+radius ; i++) {
                if(isInBounds(matrix,i, r)){
                    matrix.get(r).set(i, 0);
                }
            }
            for (int i = 0; i < matrix.size(); i++) {
                int j = 0;
                while (j<matrix.get(i).size()){
                    if(matrix.get(i).get(j)==0){
                        matrix.get(i).remove(j);
                    }else{
                        j++;
                    }
                }
                if (matrix.get(i).size()==0){
                    matrix.remove(r);
                    r--;
                }
            }
            command = scanner.nextLine();
        }


        printMatrix(matrix);
    }

    private static boolean isInBounds(List<List<Integer>> matrix, int cols, int rows) {
        if (rows>=0 && rows<matrix.size()){
            if(cols < matrix.get(rows).size() && cols>=0){
                return true;
            }
        }
        return false;
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> generateMatrix(int rows, int cols) {
        int num = 1;
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> curr = new ArrayList<>();
            matrix.add(curr);
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(j, num);
                num++;
            }
        }
        return matrix;
    }
}
