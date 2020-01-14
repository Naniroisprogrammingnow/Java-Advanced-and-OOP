package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            String dimensionsString = scanner.nextLine();
            int[] dimensions = readIntArray(dimensionsString);
            int row = dimensions[0];
            int col = dimensions[1];
            Galaxy galaxy = new Galaxy(row, col);
            GalacticCluster cluster = new GalacticCluster(galaxy);

        String command = scanner.nextLine();
            Player ivo = new Player();
            while (!command.equals("Let the Force be with you"))
            {
                int[] ivoPosition = readIntArray(command);
                int rowIvo = ivoPosition[0];
                int colIvo = ivoPosition[1];
                String evilPositionStr = scanner.nextLine();
                int[] evilPosition = readIntArray(evilPositionStr);
                int rowEvil = evilPosition[0];
                int colEvil = evilPosition[1];

                cluster.moveEvil(rowEvil, colEvil);
                cluster.collectStars(rowIvo, colIvo, ivo);

                command = scanner.nextLine();
            }

        System.out.println(ivo.getStars());


    }

    private static int[] readIntArray(String dimensionsString) {
        return Arrays.stream(dimensionsString.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
