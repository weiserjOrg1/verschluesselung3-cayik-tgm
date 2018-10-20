package cayik.cipher;
/*
 * The MonoAlphabeticCipher contains the methods to check the secret Alphabet. 
 * Moreover it implements the Cipher-Interface and uses the methods encrypt and
 * decrypt to cipher the text.
 * 
 * @autor cayik
 * @verison 2018-10-11
 */
public class MonoAlphabeticCipher implements Cipher{
	//attributes:
	private String secretAlphabet;
	
	//constructor:
	public MonoAlphabeticCipher() {
		this.secretAlphabet="abcdefghijklmnopqrstuvwxyzäöüß";
	}
	
	//methods:
	
	/*
	 * This method returns the existing secret Alphabet.
	 * 
	 * @return this.secretAlphabet the secret Alphabet
	 */
	public String getSecretAlphabetic() {
		return this.secretAlphabet;
	}
	
	/*
	 * We use this secretAlphabet to create and set a value for our secret alphabet attribute. 
	 * Of course we use the checked form.
	 * 
	 * @param secretAlphabet a string with contains the alphabet from the user
	 */
	protected void setSecretAlphabet(String secretAlphabet) throws MyException {
		this.secretAlphabet= checkSecret(secretAlphabet);
	}
	
	/* This method is from the interface cipher and we use it to encrypt 
	 * the text that we became from the user.
	 * (non-Javadoc)
	 * @see cayik.cipher.Cipher#encrypt(java.lang.String)
	 * 
	 * @param text the unencrypted version of the text
	 * 
	 * @return encText the encrypted verion of the text
	 */
	@Override
	public String encrypt(String text) {
		text=text.toLowerCase();
		String encText=""; 
		String nAlph="abcdefghijklmnopqrstuvwxyzäöüß";
		for(int i=0; i<text.length(); i++) {
			char a=text.charAt(i);
			int index= nAlph.indexOf(a); 
			if(index!=-1) {
				encText=encText+this.secretAlphabet.charAt(index);
			} else {
				encText=encText+a;
			}
		}		
		return encText; 
	}
	
	/* This method is from the interface cipher and we use it to decrypt 
	 * the text that we encrypted before.
	 * (non-Javadoc)
	 * @see cayik.cipher.Cipher#decrypt(java.lang.String)
	 * 
	 * @param text the encrypted version of the text
	 * 
	 * @return decText the decrypted verion of the text
	 */
	@Override
	public String decrypt(String text) {
		//text=text.toLowerCase();
		String decText="";
		String nAlph="abcdefghijklmnopqrstuvwxyzäöüß";
		for(int i=0; i<text.length(); i++) {
			char a=text.charAt(i);
			int index=this.secretAlphabet.indexOf(a);
			if(index!=-1) {
				decText= decText+nAlph.charAt(index);
			} else {
				decText= decText + a; 
			}
					
		}
		return decText; 
	}
	
	/*
	 * CheckSecret is a method witch checks the secret alphabet on the tree rules we have.
	 * 1)It is not allowed to use an alphabet, which has more or less than 30 letters
	 * 2)A letter can only be used once
	 * 3)All the letters have to be suitable characters 
	 * If one of these rules got broken the method throws exceptions which got defined
	 * in the class MyException
	 * 
	 * @param secAlph the secret alphabet that has to be checked
	 * 
	 * @return secAlph the checked version of the secret alphabet
	 */
	public String checkSecret(String secAlph) throws MyException{
		secAlph= secAlph.toLowerCase();
		
		//1)
		if(secAlph.length()>30) {
			throw new MyException("is too long"); 
		}
		
		if(secAlph.length()<30) {
			throw new MyException("is too short"); 
		}
		
		//2)
		for(int i=0; i<secAlph.length(); i++) {
            int help1 = 0;
            for(int j=0; j<secAlph.length(); j++) {
                if(secAlph.charAt(i) == secAlph.charAt(j)) {
                    help1++;
                    if(help1 > 1) {
                        throw new MyException("In the String are two same letters!!");
                    }
                }
            }
        }
		
		//3)
		String gültig="abcdefghijklmnopqrstuvwxyzäöüß";
		int help2=0;
		for(int i=0; i<secAlph.length(); i++) {
			for(int j=0; j<secAlph.length(); j++) {
				char a= gültig.charAt(i);
				char b= secAlph.charAt(j);
				if(a==b) {
					help2++;
				}
			}
		}
		if(help2==30) {
			
		}else {
			throw new MyException("There are not suitable characters in the String!!!"); 
		}
		
		return secAlph;
	}
}
