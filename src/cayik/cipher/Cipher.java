package cayik.cipher;
/*
 * This Interface contains the encyrpt and decrypt methods. 
 * @autor cayik
 * @version 2018-10-11
 */
public interface Cipher {
	
	public String encrypt(String text);
	
	public String decrypt(String text);
}
