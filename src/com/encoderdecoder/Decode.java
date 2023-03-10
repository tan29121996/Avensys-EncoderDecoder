package com.encoderdecoder;

public class Decode {
	//These are instance variables for the Decode class.
    private char[] referenceTable;
	
	//This is the constructor for the Decode class.
    public Decode(char[] referenceTable) {
        this.referenceTable = referenceTable;
    }
    
    //This is the decode method
    public String decode(String encodedText) {
    	//Get the first character of the encoded string
    	char offsetChar = encodedText.charAt(0);
    	
    	// Find the offset index of the offset character from the reference table
        int offsetIndex = -1;
        for (int i = 0; i < referenceTable.length; i++) {
            if (referenceTable[i] == offsetChar) {
                offsetIndex = i;
                break;
            }
        }
        
        //Create a new character array with the same length as the plainText string
        char[] decodedChars = new char[encodedText.length()-1];
        
        //Find the index of each character in the plainText string from within the reference table. 
        for (int i = 1; i < encodedText.length(); i++) {
            int index = -1;
            for (int j = 0; j < referenceTable.length; j++) {
                if (encodedText.charAt(i) == referenceTable[j]) {
                    index = j;
                    break;
                }
            }
            
            //Assign a space if the character in the plainText string is a space.
            if (encodedText.charAt(i) == ' ') {
                decodedChars[i-1] = ' ';
            } else {
            	//Otherwise, assign the character at the corresponding index in the referenceTable to the corresponding index in the decodedChars array.
                decodedChars[i-1] = referenceTable[(index + offsetIndex + referenceTable.length) % referenceTable.length];
            }
        }
        
        //Return the decodedChars array as a new String object 
        return new String(decodedChars);
    }
}