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
public class Excel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Number " + getNumberByColumn(""));
    }

    public static int getNumberByColumn(String column) {
        char[] characters = column.toCharArray();
        
        if(characters.length == 0){
            return 0;
        }
             
        int lastCharacter = 0;
        for (int i = 0; i < characters.length - 1; i++) {
            int asccii = (int) characters[i] - 64;
            lastCharacter = (26 * lastCharacter) + asccii;
        }
        int lastAsccii = (int) characters[characters.length - 1] - 64;
        return (26 * lastCharacter) + lastAsccii;
    }
}
