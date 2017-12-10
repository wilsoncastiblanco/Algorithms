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
public class RemoveArrayDuplicates {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(2);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);
        System.out.println(removeDuplicates(numbers));
    }

    public static int removeDuplicates(ArrayList<Integer> array) {
        int num = -1;
        int counter = 0;
        for (int i = 0; i < array.size(); i++) {
            if (num == array.get(i)) {
                counter++;
            } else {
             array.set(i - counter, array.get(i));
            }
            num = array.get(i);
        }
        return array.size() - counter;
    }
}
