/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author wilsoncastiblanco
 */
public class DiffK {

    public static void main(String[] args) {
        int difference = 0;
        int[] integersArray = new int[]{3, 8, 15, 1, 9, 6, 4, 12, 20};
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(0);

        System.out.println(loopArray(numbers, difference));
    }

    /*
Given an array of distinct integer values, count the number of pairs of integers that have difference k. for example, given the array {1, 7, 5, 9, 2, 12, 3} and the difference is k = 2

e.g: (7, 9) (1, 3), (5, 3)
     */
    // Search in a unordered list
    public static boolean getPairsOfIntegersByDifference(ArrayList<Integer> numbers, int subValue) {

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.contains(numbers.get(i) - subValue)) {
                int op = (numbers.get(i) - subValue);
                if ((numbers.get(i) - op) == subValue && numbers.indexOf(op) != i) {
                    return true;
                }
            }

            if (numbers.contains(numbers.get(i) + subValue)) {
                int op = (numbers.get(i) + subValue);
                if (((numbers.get(i) - (op)) == subValue) && numbers.indexOf(op) != i) {
                    return true;
                }
            }
        }

        return false;
    }

    // Search in ordered list
    public static boolean loopArray(ArrayList<Integer> numbers, int subValue) {

        for (int i = 0; i < numbers.size(); i++) {
            boolean found = searchNumber(numbers, numbers.get(i) + subValue);
            if (found) {
                int op = (numbers.get(i) + subValue);
                if((numbers.get(i) - op) == subValue && numbers.indexOf(op) != i){
                    return true;
                }
            } else {
                found = searchNumber(numbers, numbers.get(i) - subValue);
                if (found) {
                    int op = (numbers.get(i) - subValue);
                    if ((numbers.get(i) - op) == subValue && numbers.indexOf(op) != i){
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static boolean searchNumber(ArrayList<Integer> numbers, int subValue) {

        int low = 0;
        int high = numbers.size() - 1;
        int middle;

        while (low <= high) {
            middle = (low + high) / 2;
            if (numbers.get(middle) < subValue) {
                low = middle + 1;
            } else if (numbers.get(middle) > subValue) {
                high = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
