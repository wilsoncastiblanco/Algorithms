/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import static algorithms.MajorityElements.majorityElement;

/**
 *
 * @author wilsoncastiblanco
 */
public class Range2dMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] nums = new int[][]{
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}};

        int[][] nums3 = new int[][]{
            {3, 1, 0, 9},
            {2, 0, 7, 8},
            {4, 7, 1, 2},
            {3, 0, 1, 7}};

        int[][] nums2 = new int[][]{
            {3, 0, 1},
            {5, 6, 3},
            {1, 2, 0}};
        int[][] nums4 = new int[][]{};
        System.out.println("REspuesta " + new NumMatrix(nums4).sumRegion(1, 0, 2, 3));

    }

    static class NumMatrix {

        int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            if(matrix.length <= 0){
                return;
            }
            int[][] coords = new int[][]{{0, 0}, {-1, 0}, {0, -1}, {-1, -1}};

            int row = 0;
            int col = 0;
            

            while (col < matrix[0].length && row < matrix.length) {
                int num = 0;
                for (int i = 0; i < coords.length; i++) {
                    int[] coordinate = coords[i];
                    int coorRow = row + coordinate[0];
                    int coorCol = col + coordinate[1];
                    if (coorRow >= 0 && coorCol >= 0
                            && coorRow < matrix.length && coorCol < matrix[0].length) {
                        //System.out.println("row "+row+" col "+col+" coorRow "+coorRow+" coorCol "+coorCol);
                        if (i == coords.length - 1) {
                            num = num - matrix[coorRow][coorCol];
                        } else {
                            num = num + matrix[coorRow][coorCol];
                        }
                        matrix[row][col] = num;
                    }

                }
                col++;
                if (col >= matrix[0].length) {
                    row++;
                    col = 0;
                }

            }

            for (int k = 0; k < matrix.length; k++) {
                System.out.println("\n");
                for (int l = 0; l < matrix[k].length; l++) {
                    System.out.print(matrix[k][l] + " ");
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 1. sum -2 0, 0 -2
            // 2. res 1. - (-1,-1)
            // 3. row2 col2 - 2.

            int[][] coordsCalc = new int[][]{{row2, col1 - 1}, {row1 - 1, col2}, {-1, -1}};

            int num = 0;
            for (int i = 0; i < coordsCalc.length; i++) {
                int[] coord = coordsCalc[i];

                if (i == coordsCalc.length - 1) {
                    int rowCoord = row1 + coord[0];
                    int colCoord = col1 + coord[1];
                    if (rowCoord >= 0 && colCoord >= 0
                            && rowCoord < matrix.length && colCoord < matrix[0].length) {
                        num = num - matrix[rowCoord][colCoord];

                    }
                } else {
                    int rowCoord = coord[0];
                    int colCoord = coord[1];
                    if (rowCoord >= 0 && colCoord >= 0
                            && rowCoord < matrix.length && colCoord < matrix[0].length) {

                        System.out.println("asasdas");
                        System.out.println(matrix[rowCoord][colCoord]);
                        num = num + matrix[rowCoord][colCoord];

                    }
                }
            }

            return matrix[row2][col2] - num;
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such: NumMatrix
     * obj = new NumMatrix(matrix); int param_1 =
     * obj.sumRegion(row1,col1,row2,col2);
     */
}
