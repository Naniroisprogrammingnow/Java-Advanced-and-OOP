import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] info = scanner.nextLine().split(", ");
        int dimentions = Integer.parseInt(info[0]);
        int[][] matrix = new int[dimentions][dimentions];
        int num = 1;
        switch (info[1]){
            case "A":
                for (int col = 0; col < dimentions; col++) {
                        for (int row = 0; row < dimentions; row++) {
                            matrix[row][col]=num;
                            num++;
                        }
                    }
                break;
            case "B":
                for (int col = 0; col < dimentions; col++) {
                    if(col%2==0){
                        for (int row = 0; row < dimentions; row++) {
                            matrix[row][col]=num;
                            num++;
                        }
                    }else{
                        for (int row = dimentions-1; row >=0 ; row--) {
                            matrix[row][col]=num;
                            num++;
                        }
                    }

                }
                break;
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
