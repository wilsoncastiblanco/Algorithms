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
        System.out.println(1 ^ 0 ^ 0);
        System.out.println("Ans: " + additionBinaries("10111", "11"));
    }

    public static String additionBinaries(String one, String two) {
        String result = "";
        char[] binaries1 = one.toCharArray();
        char[] binaries2 = two.toCharArray();

        int binary2Size = binaries2.length - 1;
        int carry = 0;
        for (int i = binaries1.length - 1; i >= 0; i--) {
            int firstBit = binaries1[i] - '0';
            int secondBit = 0;
            if (binary2Size >= 0) {
                secondBit = binaries2[binary2Size] - '0';
                binary2Size--;
            }
            int res = (firstBit ^ secondBit ^ carry) + '0';

            result = (char) res + result;
            System.out.println(result);
            carry = (firstBit & secondBit) | (secondBit & carry) | (firstBit & carry);

        }

        // if overflow, then add a leading 1
        if (carry > 0) {
            result = '1' + result;
        }

        return result;
    }
}
