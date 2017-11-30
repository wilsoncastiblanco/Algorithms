/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author wilsoncastiblanco 
 * Design and implement a method with the following
 * specifications.
 *
 * Input #1: List of (x, y) coordinate points Example: {(1, 0), (0, 5), (3, 0),
 * (10, 10)}
 *
 * Input #2: integer, K Example: 2
 *
 * Desired Output: List of (x, y) points consisting of the K points from the
 * input list that are nearest in distance to the origin, (0, 0) Example:
 * {(1,0), (3, 0)}
 *
 * Distance to origin formula: sqrt(x^2 + y^2)
 */
public class CoordinatePoints {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] coords = new int[][]{{1, 0}, {0, 5}, {3, 0}, {10, 10}};
        getCoordinates(coords);
    }

    public static void getCoordinates(int[][] coords) {
        TreeMap<Double, int[]> set = new TreeMap();

        for (int i = 0; i < coords.length; i++) {
            int[] nums = coords[i];
            set.put(Math.sqrt(nums[0] ^ 2 + nums[1] ^ 2), nums);
            System.out.println("sqrt(" + nums[0] + "^2 + " + nums[1] + "y^2) " + Math.sqrt(nums[0] ^ 2 + nums[1] ^ 2));
        }
        Iterator<int[]> it = set.values().iterator();
        for (int i = 0; i < 2; i++) {
            int[] coor = it.next();
            System.out.println(coor[0]+","+coor[1]);
        }

        // O(n + n log n + k + it)
    }

}
