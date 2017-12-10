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
        System.out.println(reverseBinary(2));
    }

    public static long reverseBinary(long n) {

        long rev = 0;

        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            System.out.println(rev);
            if ((n & (1 << i)) != 0) {
                rev |= 1;
            }
        }

        return rev;
    }

    public static void mergeSort(char[] arr, char[] aux, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, aux, low, middle);
            mergeSort(arr, aux, middle + 1, high);

            merge(arr, aux, low, middle, high);
        }
    }

    private static void merge(char[] arr, char[] aux, int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            aux[i] = arr[i];
        }

        int leftAux = low;
        int rightAux = middle + 1;
        int current = low;

        while (leftAux <= middle && rightAux <= high) {
            //System.err.println((aux[rightAux] + '0')+" <= "+(aux[leftAux] + '0') +" = "+ (aux[rightAux] + '0' <= aux[leftAux] + '0'));
            if ((((int) aux[rightAux] + '0') ^ ((int) aux[leftAux] + '0')) == 0) {
                arr[current] = aux[leftAux];
                leftAux++;
            } else {
                arr[current] = aux[rightAux];
                rightAux++;
            }
            current++;
        }

        int remaining = middle - leftAux;

        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = aux[current + i];
        }

    }

}
