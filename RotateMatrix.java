import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String rotation = scanner.nextLine();
        String input = scanner.nextLine();
        List<String> items = new ArrayList<>();
        int maxLen = 0;
        while(!input.equals("END")){
            if(input.length()>maxLen){
                maxLen=input.length();
            }
            items.add(input);
            input=scanner.nextLine();
        }
        String[][] matrix = new String[items.size()][maxLen];
        int rows = items.size();
        int cols = maxLen;
        for (int i = 0; i < rows; i++) {
            String[] curr = items.get(i).split("");
            for (int j = 0; j <cols; j++) {
                if(j>=curr.length){
                    matrix[i][j]=" ";
                }else{
                    matrix[i][j]=curr[j];
                }
            }
        }
        int rotationDegrees = Integer.parseInt(rotation.substring(7,rotation.length()-1));
        if(rotationDegrees>360){
            rotationDegrees=rotationDegrees%360;
        }
        if(rotationDegrees==0){
            print0(matrix);
        }else if (rotationDegrees==90){
            print90(matrix, rows, cols);
        }else if(rotationDegrees==180){
            print180(matrix, rows, cols);
        }else if(rotationDegrees==270){
            print270(matrix, rows, cols);
        }
    }

    private static void print270(String[][] matrix, int rows, int cols) {
        for (int i = cols-1; i >=0 ; i--) {
            for (int j = 0; j <rows ; j++) {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
    }

    private static void print180(String[][] matrix, int rows, int cols) {
        for (int i = rows-1; i>=0 ; i--) {
            for (int j = cols-1; j >=0; j--) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void print90(String[][] matrix, int rows, int cols) {
        for (int i = 0; i < cols; i++) {
            for (int j = rows-1; j >=0; j--) {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
    }

    private static void print0(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
