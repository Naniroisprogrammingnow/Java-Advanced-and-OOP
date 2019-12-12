import java.util.Scanner;
public class realQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        char[][] chessBoard = new char[8][];
        for (int i = 0; i <chessBoard.length ; i++) {
            String[] chess = scanner.nextLine().split(" ");
            chessBoard[i]= new char[chess.length];
            for (int j = 0; j < chess.length; j++) {
                chessBoard[i][j]=chess[j].charAt(0);
            }
        }
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if(chessBoard[i][j]=='q'){
                    if(!upper(chessBoard, i, j) && !lower(chessBoard, i, j) && !left(chessBoard, i, j)
                            && !right(chessBoard, i, j) && !upperLeftD(chessBoard, i, j) && !upperRightD(chessBoard, i, j)
                            && !lowerLeftD (chessBoard, i, j) && !lowerRightD(chessBoard, i, j) ){
                        System.out.println(i + " " + j);                                      //  && !lowerRightD)
                    }
                }
            }
        }
    }

    private static boolean lowerRightD(char[][] chessBoard, int row, int col) {
        row++;
        col++;
        while (row<8 && col<8){
            if(chessBoard[row][col]=='q'){
                return true;
            }
            row++;
            col++;
        }
        return false;
    }

    private static boolean lowerLeftD(char[][] chessBoard, int row, int col) {
        row++;
        col--;
        while (row<8 && col>=0){
            if(chessBoard[row][col]=='q'){
                return true;
            }
            row++;
            col--;
        }
        return false;
    }

    private static boolean upperRightD(char[][] chessBoard, int row, int col) {
        row--;
        col++;
        while (row>=0 && col<8){
            if(chessBoard[row][col]=='q'){
                return true;
            }
            row--;
            col++;
        }
        return false;
    }

    private static boolean upperLeftD(char[][] chessBoard, int row, int col) {
        row--;
        col--;
        while (row>=0 && col>=0){
            if(chessBoard[row][col]=='q'){
                return true;
            }
            row--;
            col--;
        }
        return false;
    }

    private static boolean right(char[][] chessBoard, int row, int col) {
        for (int k = col+1; k <8 ; k++) {
            if(chessBoard[row][k]=='q'){
                return true;
            }
        }
        return false;
    }

    private static boolean left(char[][] chessBoard, int row, int col) {
        for (int i = col-1; i >=0 ; i--) {
            if(chessBoard[row][i]=='q'){
                return true;
            }
        }
        return false;
    }

    private static boolean lower(char[][] chessBoard, int row, int col) {
        for (int k = row+1; k <8 ; k++) {
            if(chessBoard[k][col]=='q'){
                return true;
            }
        }
        return false;
    }

    private static boolean upper(char[][] chessBoard, int row, int col) {
        for (int k = row-1; k >=0 ; k--) {
            if(chessBoard[k][col]=='q'){
                return true;
            }
        }
        return false;
    }
}
