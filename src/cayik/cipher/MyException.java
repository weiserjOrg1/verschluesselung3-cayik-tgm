package cayik.cipher;
/*
 * This class contains my exceptions which i use for the MonoAlphaneticCipher class.
 * 
 *  @autor cayik
 *  @version 2018-10-11
 */

public class MyException extends Exception{
	
	public MyException() {
		super("The alphabet is wrong");
	}
	
	public MyException(String txt) {
		super(txt);
		
	}
}
