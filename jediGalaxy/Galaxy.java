package jediGalaxy;

public class Galaxy {
    private int rows;
    private int cols;
    private int[][] matrix;

    public void setValue(int row, int col, int newValue) {
        this.matrix[row][col] = newValue;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    public int get(int row, int col){
        return this.matrix[row][col];
    }

    public Galaxy(int row, int col) {
        this.rows = row;
        this.cols = col;
        this.matrix =  new int[row][cols];
        fillGalaxy(row, col);
    }

    private void fillGalaxy(int row, int col) {
        int value = 0;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                matrix[i][j] = value++;
            }
        }
    }

}
