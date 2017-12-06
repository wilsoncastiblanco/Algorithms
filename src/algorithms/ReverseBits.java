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
public class ReverseBits {

    public static void main(String[] args) {
        reverseBinary(3);
    }

    public static long reverseBinary(long n) {

        StringBuilder binary = new StringBuilder();

      
        //1073741824 = 2
        long reversed = (n >> 2)|(n << (32 - 2));
        
        System.out.println(reversed);
        
        System.out.println(binary.reverse().toString());

        return 0;
    }

}
