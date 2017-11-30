/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author wilsoncastiblanco
 */
public class MajorityElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print(majorityElement(new int[]{3, 3, 3, 2, 3, 3, 3, 4, 5, 2, 1}));
    }

    public static int majorityElement(int[] nums) {       
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int num : nums) {
            numsMap.merge(num, 1, Integer::sum);
            if(numsMap.get(num) > nums.length / 2){
                return num;
            }
        }
        return 0;

    }
    
    public static void printArray(int[] array){
        System.out.println("===========================");
        StringBuilder nums = new StringBuilder();
        for(int num: array){
            nums.append(num).append(" ");
        }
        System.out.println(nums.toString());
    }

    public static void mergeSort(Integer[] array, Integer[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, helper, 0, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, high, middle);
        }
    }

    public static void merge(Integer[] array, Integer[] helper, int low, int high, int middle) {
        for (int i = 0; i < array.length; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }

    }
}
