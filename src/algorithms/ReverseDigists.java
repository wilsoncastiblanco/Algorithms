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
public class ReverseDigists {

    public static void main(String[] args) {
        int n = -23333333;
        System.out.println(reverseInt(n));
    }

    public static int reverseInt(int n) {
        char[] numbers = String.valueOf(n).toCharArray();
        String reversed = "";
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] != '-') {
                reversed += numbers[i];
            } else {
                reversed = numbers[i] + reversed;
            }
        }

        int res = 0;
        try {
            res = Integer.parseInt(reversed);

        } catch (NumberFormatException e) {
            return 0;
        }

        return res;
    }

}
