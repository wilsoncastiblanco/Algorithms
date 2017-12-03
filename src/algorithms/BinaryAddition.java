/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayList;

/**
 *
 * @author wilsoncastiblanco
 */
public class BinaryAddition {

    public static void main(String[] args) {
        System.out.println("Ans: " + additionBinaries("10111", "11"));
    }

    public static String additionBinaries(String one, String two) {
        int size = one.length() > two.length() ? one.length() : two.length();
        String result = "";
        char[] binaries1 = one.toCharArray();
        char[] binaries2 = two.toCharArray();

        int multiplierSize = binaries2.length - 1;
        int carry = 0;
        for (int i = binaries1.length - 1; i >= 0; i--) {
            int firstBit = binaries1[i] - '0';
            int secondBit = 0;
            int val1 = Character.getNumericValue(binaries1[i]);
            int val2 = 0;
            if (multiplierSize >= 0) {
                secondBit = binaries2[multiplierSize] - '0';
                val2 = Character.getNumericValue(binaries2[multiplierSize]);
                multiplierSize--;
            }
            int res = (val1 ^ val2 ^ carry) + '0';

            result = (char) res + result;

            carry = (firstBit & secondBit) | (secondBit & carry) | (firstBit & carry);

        }

        // if overflow, then add a leading 1
        if (carry > 0) {
            result = '1' + result;
        }

        return result;
    }
}
