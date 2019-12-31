import java.util.Arrays;
import java.util.Scanner;
public class Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] dem = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        boolean[][]lot = new boolean[dem[0]][dem[1]];
        for (int i = 0; i < lot.length; i++) {
            for (int j = 0; j < lot[i].length; j++) {
                lot[i][j] = true;
            }
        }
        String iinput;
        while (!"stop".equals(iinput=scanner.nextLine())){
            boolean isParked = false;
            int[]tokkens = Arrays.stream(iinput.split(" ")).mapToInt(Integer::parseInt).toArray();
            int steps = 1;
            int rowEntrence = tokkens[0];
            int row = tokkens[1];
            int col = tokkens[2];

            if(isFull(row, lot)){
                System.out.printf("Row %d full%n", row);
                continue;
            }
            steps+=col;
            if(row!=rowEntrence){
                steps+=Math.abs(row-rowEntrence);
            }
            if(lot[row][col]){
                lot[row][col]=false;
                System.out.println(steps);
            }else{
                for (int i = 1; i <lot[row].length; i++) {
                    if(valid(row, col-i, lot) && lot[row][col-i]){
                        steps -= i;
                        lot[row][col-i]=false;
                        System.out.println(steps);
                        break;
                    }else if (valid(row, col+i, lot) && lot[row][col+i]){
                        steps+=i;
                        lot[row][col+i]=false;
                        System.out.println(steps);
                        break;
                    }
                    }
                }
            }
        }

    private static boolean isFull(int row, boolean[][] lot) {
        for (int i = 1; i < lot[row].length; i++) {
            if(lot[row][i]){
                return false;
            }
        }
        return true;
    }

    private static boolean valid(int row, boolean[][] lot) {
        return row>=0 && row<lot.length;
    }

    private static boolean valid(int row, int col, boolean[][] lot) {
        return row>=0 && row<lot.length && col>0 && col<lot[row].length;
    }

}

