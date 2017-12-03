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
public class IncreasingNumbers {
    
    public static void main(String[] args) {
        System.out.println("Ans: " + monotoneIncreasingDigits2(963856657));
        // 1333
        // 332
        // 299
        // 299
    }
    
    public static int monotoneIncreasingDigits2(int N) {
        String digits = String.valueOf(N);
        
        int nums[] = new int[digits.length()];
        
        for (int i = 0; i < digits.length(); i++) {
            nums[i] = digits.charAt(i) - '0';
        }
        
        int size = nums.length;
        int level = size - 1;
        for (int i = size - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                nums[i - 1]--;
                level = i - 1;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        /* If first digit is 0 no need to print it */
        if (nums[0] != 0) {
            for (int i = 0; i <= level; i++) {
                answer.append(nums[i]);
            }
            for (int i = level + 1; i < size; i++) {
                answer.append(9);
            }
        } else {
            for (int i = 1; i < level; i++) {
                answer.append(nums[i]);
            }
            for (int i = level + 1; i < size; i++) {
                answer.append(9);
            }
        }
        
        return Integer.parseInt(answer.toString());
    }
    
    public static int monotoneIncreasingDigits(int N) {
        
        if (N <= 0 || N > 1000000000) {
            return N;
        }
        
        if (String.valueOf(N).toCharArray().length == 2) {
            if (String.valueOf(N - 1).toCharArray().length == 1) {
                return N - 1;
            }
        }
        
        for (int i = N; i > 0; i--) {
            //System.out.println(i);
            String number = String.valueOf(i);
            char[] digits1 = number.toCharArray();
            
            System.out.println("Len " + digits1.length);
            System.out.println(digits1);
            int val = Character.getNumericValue(digits1[0]);
            boolean isIncreasing = false;
            for (int j = 1; j < digits1.length; j++) {
                System.out.println(digits1[j]);
                if (val <= Character.getNumericValue(digits1[j])) {
                    val = Character.getNumericValue(digits1[j]);
                    isIncreasing = true;
                } else {
                    System.out.println("Break: val " + val + " val2 " + Character.getNumericValue(digits1[j]));
                    isIncreasing = false;
                    break;
                }
            }
            
            if (isIncreasing) {
                return i;
            }
        }
        return -1;
    }
}
