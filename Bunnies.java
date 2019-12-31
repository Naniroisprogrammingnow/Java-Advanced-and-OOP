import java.util.*;

public class Bunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] dem = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String [][] lair = new String[dem[0]][];
        int row = -1;
        int col = -1;
        for (int i = 0; i < dem[0]; i++) {
            String input = scanner.nextLine();
            if(input.contains("P")){
                row = i;
                col = input.indexOf("P");
            }
            lair[i]=input.split("");
        }
        String action = scanner.nextLine();
        boolean isDead = false;
        boolean hasWon = false;
        int[] old = new int[2];
        for (int i = 0; i < action.length(); i++) {
            lair[row][col]=".";
            old[0]=row;
            old[1]=col;
            switch (action.charAt(i)){
                case 'U':
                    row-=1;
                    break;
                case 'D':
                    row+=1;
                    break;
                case 'L':
                    col-=1;
                    break;
                case 'R':
                    col+=1;
                    break;
            }
            lair = bunnyHopp(lair);

            if(isValid(row, lair) && isValid(lair, col)){
                if(lair[row][col].equals("B")){
                    isDead = true;
                }else{
                    lair[row][col]="P";
                }
            }else{
                hasWon=true;

            }

            if(hasWon||isDead){
                break;
            }
        }
        printMatrix(lair);
        if(hasWon){
            System.out.println("won: " + old[0] + " " + old[1]);
        }else{
            System.out.println("dead: " + row + " " + col);
        }
    }

    private static void printMatrix(String[][] lair) {
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j <lair[i].length; j++) {
                System.out.print(lair[i][j]);
            }
            System.out.println();
        }
    }

    private static String[][] bunnyHopp(String[][] lair) {
        String[][] newMatrix = new String[lair.length][lair[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j]=".";
            }
        }
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                if(lair[i][j].equals("B")){
                    newMatrix[i][j] ="B";
                    if(isValid(lair, j+1)){newMatrix[i][j+1]="B";}
                    if(isValid( lair, j-1)){newMatrix[i][j-1]="B";}
                    if(isValid(i-1, lair)){newMatrix[i-1][j]="B";}
                    if(isValid(i+1, lair)){newMatrix[i+1][j]="B";}
                }
            }
        }
        return newMatrix;
    }
    private static boolean isValid(String[][] lair, int co) {
        return co>=0 && co<lair[0].length;
    }
    private static boolean isValid(int ro, String[][] lair) {
        return ro >=0 && ro<lair.length;
    }

}
