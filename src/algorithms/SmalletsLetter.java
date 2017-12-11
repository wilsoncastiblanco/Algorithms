/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *
 * @author wilsoncastiblanco
 */
public class SmalletsLetter {

    public static void main(String[] args) {
        char[] letters = new char[]{'e', 'e', 'e', 'k', 'q', 'q', 'q', 'v', 'v', 'y'};
        char[] letters2 = new char[]{'c', 'e', 'f', 'h'};
        char[] letters3 = new char[]{'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        char target = 'l';

        System.out.println(binarySearch(letters, target));

    }

    public static char nextGreatestLetter(char[] letters, char target) {
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();
        for (char character : letters) {
            charSet.add(character);
        }

        // O(letters + charSet)
        System.err.println(charSet);

        Iterator<Character> it = charSet.iterator();
        while (it.hasNext()) {
            char letter = it.next();
            if ((int) target < (int) letter) {
                return letter;
            } else if ((int) target == (int) letter) {
                if (it.hasNext()) {
                    return it.next();
                } else {
                    return letters[0];
                }

            }
        }

        return letters[0];
    }

    // O(logn)
    public static char binarySearch(char[] letters, char target) {

        int low = 0;
        int high = letters.length - 1;
        int middle;

        while (low <= high) {
            middle = (low + high) / 2;
            if ((int) letters[middle] < (int) target) {
                low = middle + 1;
            } else if ((int) letters[middle] > (int) target) {
                high = middle - 1;
            } else {
                if(low == 0 && high == 0){
                    return letters[high + 1];
                }
                if (middle == low) {
                    middle++;
                }
                low = middle;
            }
        }

        if (high < 0 || low > letters.length - 1) {
            return letters[0];
        }

        return letters[low];
    }

}
