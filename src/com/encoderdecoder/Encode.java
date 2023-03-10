package com.encoderdecoder;

public class Encode {
	//These are instance variables for the Encode class.
    private char[] referenceTable;
    private char offsetChar;
    
    //This is the constructor for the Encode class.
    public Encode(char[] referenceTable, char offsetChar) {
        this.referenceTable = referenceTable;
        this.offsetChar = offsetChar;
    }
    
    //This is the encode method
    public String encode(String plainText) {
    	// Find the offset index of the offset character from the reference table
        int offsetIndex = -1;
        for (int i = 0; i < referenceTable.length; i++) {
            if (referenceTable[i] == offsetChar) {
                offsetIndex = i;
                break;
            }
        }
        
        //Create a new character array with the same length as the plainText string
        char[] encodedChars = new char[plainText.length()];
        
        //Find the index of each character in the plainText string from within the reference table. 
        for (int i = 0; i < plainText.length(); i++) {
            int index = -1;
            for (int j = 0; j < referenceTable.length; j++) {
                if (plainText.charAt(i) == referenceTable[j]) {
                    index = j;
                    break;
                }
            }
            
            //Assign a space if the character in the plainText string is a space.
            if (plainText.charAt(i) == ' ') {
                encodedChars[i] = ' ';
            } else {
            	//Otherwise, assign the character at the corresponding index in the referenceTable to the corresponding index in the encodedChars array.
                encodedChars[i] = referenceTable[(index - offsetIndex + referenceTable.length) % referenceTable.length];
                
            }
        }
        
        //Return the encodedChars array as a new String object 
        return new String(encodedChars);
    }
}