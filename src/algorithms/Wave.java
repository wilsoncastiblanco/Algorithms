/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import static algorithms.Excel.getNumberByColumn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wilsoncastiblanco
 */
public class Wave {

    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        num.add(9);
        num.add(13);
        num.add(7);
        num.add(2);
        System.out.println(wave(num));
    }

    public static ArrayList<Integer> wave(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>(a);
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            if ((i + 1) % 2 == 0) {
                int index = i - 1 < 0 ? 0 : i - 1;
                result.set(index, a.get(i));
            } else {
                int index = i + 1 >= a.size() - 1 ? a.size() - 1 : i + 1;
                result.set(index, a.get(i));
            }
        }

        return result;
    }
}
