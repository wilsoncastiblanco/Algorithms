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
public class CountOneBits {

    public static void main(String[] args) {
        System.out.println(getOneBits(13));
    }

    public static int getOneBits(int n) {

        int counter = 0;

        while (n > 0) {

            n = n & (n - 1);
            counter++;

        }

        return counter;

    }

}
