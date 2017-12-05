/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wilsoncastiblanco
 */
public class CherryPickup {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}};
        int[][] grid1 = new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        int[][] grid2 = new int[][]{{1}};
        int[][] grid3 = new int[][]{{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}};
        System.out.println(cherryPickup(grid2));
    }

    public static int cherryPickup(int[][] grid) {
        int[][] coords = new int[][]{{0, 0}, {0, 1}, {1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();

        int way = 0;
        rows.add(0);
        columns.add(0);

        int cherriesPickedUp = 0;

        while (!rows.isEmpty()) {
            // Remove head element and retrieve it
            int row = rows.poll();
            int column = columns.poll();

            //mark head as visited
            visited[row][column] = true;

            way = grid[row][column];

            if (way == 0 || way == 1) {
                if (way == 1) {
                    cherriesPickedUp++;
                    grid[row][column] = 0;
                }
                for (int i = 0; i < coords.length; i++) {
                    int[] coord = coords[i];
                    int posRow = row + coord[0];
                    int posColumn = column + coord[1];
                    if (posRow < grid.length && posColumn < grid[0].length && !visited[posRow][posColumn] && grid[posRow][posColumn] != -1) {
                        rows.add(posRow);
                        columns.add(posColumn);
                    }
                }

            }

        }

        return cherriesPickedUp;
    }
}
