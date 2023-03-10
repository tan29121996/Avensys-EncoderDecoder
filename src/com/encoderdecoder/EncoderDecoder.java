package com.encoderdecoder;

public class EncoderDecoder {

	public static void main(String[] args) {
		
		//This is the character array for the reference table
	    char[] referenceTable = {
	        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
	        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'
	    };
	    
	    //Enter an offset character for encoding
	    char offSetChar = 'B';
	    
	    //Enter a plain text to encode
	    String plainText = "HELLO WORLD";
	    
	    //Create instances of the Encode and Decode classes
	    Encode encode = new Encode(referenceTable, offSetChar);
	    Decode decode = new Decode(referenceTable);
	    
	    //Encode the plain text
	    String encodedText = offSetChar + encode.encode(plainText);
	    
	    //Print out the value of the encoded String
	    System.out.println("The encoded text will be " + encodedText + "\n");
	    
	    //Decode the encoded String
	    String decodedText = decode.decode(encodedText);
	    
	    //Print out the value of the decoded String
	    System.out.println("The decoded text will be " + decodedText);
	}

}
