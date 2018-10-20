package cayik.cipher;

/*
 * This class expends from the MonoAlphabeticCipher-Class 
 * 
 * @autor cayik
 * @version 2018-10-11
 */
public class SubstitutionCipher extends MonoAlphabeticCipher{
	
	public SubstitutionCipher() {
		super();
	}
	
	public SubstitutionCipher(String secretAlphabet) throws MyException{
		super.setSecretAlphabet(secretAlphabet);
		
	}
	
	public void setSecretAlphabet(String secretAlphabet) throws MyException{
		super.setSecretAlphabet(secretAlphabet);
	}
}
