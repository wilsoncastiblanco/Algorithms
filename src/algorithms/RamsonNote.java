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
public class RamsonNote {

    public static void main(String[] args) {
        
        System.out.println(canConstruct("aa", "aab"));
    }
    
    
    public static boolean canConstruct(String ransomNote, String magazine) {
        ArrayList<Character> ransomNoteChars = new ArrayList<>();

        for(char letter : ransomNote.toCharArray()){
            ransomNoteChars.add(letter);
        }
        
        for(char letterMag : magazine.toCharArray()){
            if(ransomNoteChars.contains(letterMag)){
                ransomNoteChars.remove(ransomNoteChars.indexOf(letterMag));
            }
        }
        
        
        return ransomNoteChars.isEmpty();
        
    }
    
    
}
