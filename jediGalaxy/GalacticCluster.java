package jediGalaxy;

public class GalacticCluster {
    private Galaxy galaxy;

    public GalacticCluster(Galaxy galaxy){
        this.galaxy = galaxy;
    }
    public void moveEvil(int row, int col){
        while (row >= 0 && col >= 0)
        {
            if (row < galaxy.getRows() && col < galaxy.getCols())
            {
                galaxy.setValue(row,col,0);
            }
            row--;
            col--;
        }
    }

    public void collectStars(int row, int col, Player player){
        while (row >= 0 && col < galaxy.getCols())
        {
            if (row < galaxy.getRows() && col >= 0 && col < galaxy.getCols()){
                player.setStars(player.getStars()+ galaxy.get(row,col));
            }

            col++;
            row--;
        }
    }
}
