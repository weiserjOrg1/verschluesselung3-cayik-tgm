package cayik.cipher;

public class KeywordCipher extends MonoAlphabeticCipher {
	
	public KeywordCipher(String text) throws keyex, MyException{
		this.setKey(text);
	}
	
	
	public void setKey(String key) throws keyex, MyException {
		if (key.length() == 0)
			throw new keyex();
		key = key.toLowerCase();
		String newAlph = "";
		for (int i = 0; i < key.length(); i++) {
			boolean use1 = false;
			for (int j = 0; j < newAlph.length(); j++) {
				if (newAlph.charAt(j) == key.charAt(i))
					use1 = true;
			}
			if (!use1) {
				switch (key.charAt(i)) {
				case 'ä':
					newAlph += 'ä';
					break;
				case 'ö':
					newAlph += 'ö';
					break;
				case 'ü':
					newAlph += 'ü';
					break;
				case 'ß':
					newAlph += 'ß';
					break;
				default:
					if (key.charAt(i) >= 97 && key.charAt(i) <= 122)
						newAlph += key.charAt(i);
				}
			}
		}
		int keyLength = newAlph.length();
		for (int i = 0; i < 30; i++) {
			boolean use2 = false;
			char c = (char) (97 + i);
			switch (c) {
			case 123:
				c = 'ä';
				break;
			case 124:
				c = 'ö';
				break;
			case 125:
				c = 'ü';
				break;
			case 126:
				c = 'ß';
				break;
			}
			for (int j = 0; j < keyLength; j++) {
				if (c == newAlph.charAt(j))
					use2= true;
			}
			if (!use2) {
				switch (c) {
				case 123:
					newAlph += 'ä';
					break;
				case 124:
					newAlph += 'ö';
					break;
				case 125:
					newAlph += 'ü';
					break;
				case 126:
					newAlph += 'ß';
					break;
				default:
					newAlph += c;
				}
			}
		}
		super.setSecretAlphabet(newAlph);
	}
}
