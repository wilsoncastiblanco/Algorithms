/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author wilsoncastiblanco
 */
public class WiggleSubsequence {

    public static void main(String[] args) {
        int[] wiggle = new int[]{1, 7, 4, 9, 2, 5};
        int[] wiggle2 = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int[] wiggle3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(getWiggleSub(wiggle3));
    }

    public static int getWiggleSub(int[] wiggle) {
        int counter = 0;
        for (int i = 1; i < wiggle.length; i = i + 2) {
            if(wiggle[i] == 0){
                return 1;
            }
            int nextItem = i + 1;
            if (nextItem >= wiggle.length - 1) {
                if (wiggle[i] > wiggle[i - 1]) {
                    counter++;
                }
            } else {
                if (wiggle[i] > wiggle[i + 1] && wiggle[i] > wiggle[i - 1]) {
                    counter++;
                }
            }

        }
        return counter * 2;
    }
}
