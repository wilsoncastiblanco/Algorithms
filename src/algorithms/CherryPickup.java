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
        int[][] grid3 = new int[][]{{1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}};
        int[][] grid4 = new int[][]{{0, 1, 1, 0, 0}, {1, 1, 1, 1, 0}, {-1, 1, 1, 1, -1}, {0, 1, 1, 1, 0}, {1, 0, -1, 0, 0}};
        System.out.println(cherryPickup(grid4));
    }

    public static int cherryPickup(int[][] grid) {
        if (grid.length == 1 && grid[0][0] == 1) {
            return 1;
        }
        int[][] coords = new int[][]{{0, 0}, {0, 1}, {1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();

        int way = 0;
        rows.add(0);
        columns.add(0);

        int cherriesPickedUp = 0;
        int count = 0;
        while (!rows.isEmpty()) {
            // Remove head element and retrieve it
            int row = rows.poll();
            int column = columns.poll();
            //mark head as visited
            visited[row][column] = true;

            way = grid[row][column];

            int thereIsPath = way;

            for (int i = 0; i < coords.length; i++) {
                int[] coord = coords[i];
                int posRow = row + coord[0];
                int posColumn = column + coord[1];

                if (posRow >= 0 && posColumn >= 0 && posRow < grid.length && posColumn < grid[0].length && !visited[posRow][posColumn] && grid[posRow][posColumn] != -1) {
                    thereIsPath &= grid[posRow][posColumn];
                    rows.add(posRow);
                    columns.add(posColumn);
                }
            }

            if (count == 0 && thereIsPath == 1) {
                break;
            } else {

                if (way == 1) {
                    System.out.println("position: row "+row+" column: "+column);
                    cherriesPickedUp++;
                    grid[row][column] = 0;
                }
            }

            count++;

        }

        return cherriesPickedUp;
    }
}
