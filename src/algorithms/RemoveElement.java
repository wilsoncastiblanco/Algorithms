/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wilsoncastiblanco
 */
public class RemoveElement {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        System.out.println(removeElement(numbers, 0));
    }

    public static List<Integer> removeElement(List<Integer> numbers, int n) {
        int numberToRemove = removeItem(numbers, n);

        if (numbers.size() > 0) {
            while (numberToRemove != -1) {
                numberToRemove = removeItem(numbers, n);
            }
        }

        return numbers;
    }

    private static int removeItem(List<Integer> numbers, int n) {
        int numberToRemove = search(numbers, n);
        if (numberToRemove != -1) {
            numbers.remove(numberToRemove);
        }
        return numberToRemove;
    }

    private static int search(List<Integer> numbers, int num) {
        System.out.println("Hola");
        int n = numbers.size();
        // 1st comparison
        if (numbers.get(n - 1) == num) {
            return n - 1;
        }

        int backup = numbers.get(n - 1);
        numbers.set(n - 1, num);

        // no termination condition and thus
        // no comparison
        for (int i = 0;; i++) {
            // this would be executed at-most n times
            // and therefore at-most n comparisons
            if (numbers.get(i) == num) {
                // replace arr[n-1] with its actual element
                // as in original 'arr[]'
                numbers.set(n - 1, backup);

                // if 'x' is found before the '(n-1)th'
                // index, then it is present in the array
                // final comparison
                if (i < n - 1) {
                    return i;
                }

                // else not present in the array
                return -1;
            }
        }
    }

    public static int binarySearch(List<Integer> numbers, int num) {
        int low = 0;
        int high = numbers.size() - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (numbers.get(mid) < num) {
                low = mid + 1;
            } else if (numbers.get(mid) > num) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
