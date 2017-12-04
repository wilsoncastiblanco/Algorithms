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
        numbers.add(4);
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        System.out.println(remove(numbers, 1));
    }

    public static int remove(List<Integer> numbers, int n) {

        return numbers.size() - searchItem(numbers, n);
    }

    static int counter = 0;

    private static int searchItem(List<Integer> numbers, int n) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) == n) {
                counter++;
            } else {
                numbers.set(index - counter, numbers.get(index));
            }
        }
        return counter;
    }
}
