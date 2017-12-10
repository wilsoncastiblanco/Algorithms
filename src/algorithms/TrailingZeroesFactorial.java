/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.math.BigInteger;

/**
 *
 * @author wilsoncastiblanco
 */
public class TrailingZeroesFactorial {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(7560));
    }

    public static int trailingZeroes(int a) {
        int count = 0;
        
        if(a < 0){
            return -1;
        }
        
        for(int i = 5; a / i > 0; i*=5){
            count += a / i;
        }

        return count;
    }

    public static int factorial(int a) {
        BigInteger result = BigInteger.ONE;
        BigInteger n = BigInteger.valueOf(a);
        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        char[] factorial = String.valueOf(result).toCharArray();
        int count = 0;
        for (int i = factorial.length - 1; i > 0; i--) {
            if (factorial[i] == '0') {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
