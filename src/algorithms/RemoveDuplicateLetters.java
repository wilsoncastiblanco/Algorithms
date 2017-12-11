/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author wilsoncastiblanco
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    public static String removeDuplicateLetters(String s) {
        
        Set<Character> letterSet = new HashSet<>();
        for(char letter : s.toCharArray()){
            letterSet.add(letter);
        }
        
        String res = "";
        for(char letter : letterSet){
            res += letter;
        }
        
        return res;

    }
}
