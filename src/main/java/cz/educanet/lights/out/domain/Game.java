package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

import java.util.Random;

public class Game implements ILightsOut {

    private int moveCount = 0;
    private boolean[][] gird = new boolean[5][5];
    private boolean hasWon = true;

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public Game() {
        int a = getRandomNumberInRange(0, 4);
        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[i].length; j++) {
                if (j == a) {
                    a = getRandomNumberInRange(0, 4);
                    getGrid()[i][j] = true;
                    System.out.println("nigga");
                } else getGrid()[i][j] = false;
            }
        }


    }

    @Override
    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public boolean isGameOver() {
        for (int i = 0; i < getGrid().length; i++) {
            for (int j = 0; j < getGrid()[i].length; j++) {
                if (getGrid()[i][j]) {
                    hasWon = false;
                }
            }
        }


        return hasWon;
    }

    @Override
    public boolean[][] getGrid() {
        return gird;
    }

    @Override
    public void makeMove(int x, int y) {
        moveCount++;
        getGrid()[x][y] = !getGrid()[x][y];

        if (x + 1 <= 4) getGrid()[x + 1][y] = !getGrid()[x + 1][y];
        if (x - 1 >= 0) getGrid()[x - 1][y] = !getGrid()[x - 1][y];
        if (y + 1 <= 4) getGrid()[x][y + 1] = !getGrid()[x][y + 1];
        if (y - 1 >= 0) getGrid()[x][y - 1] = !getGrid()[x][y - 1];

    }
}
