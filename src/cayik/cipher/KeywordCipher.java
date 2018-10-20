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
				case '�':
					newAlph += '�';
					break;
				case '�':
					newAlph += '�';
					break;
				case '�':
					newAlph += '�';
					break;
				case '�':
					newAlph += '�';
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
				c = '�';
				break;
			case 124:
				c = '�';
				break;
			case 125:
				c = '�';
				break;
			case 126:
				c = '�';
				break;
			}
			for (int j = 0; j < keyLength; j++) {
				if (c == newAlph.charAt(j))
					use2= true;
			}
			if (!use2) {
				switch (c) {
				case 123:
					newAlph += '�';
					break;
				case 124:
					newAlph += '�';
					break;
				case 125:
					newAlph += '�';
					break;
				case 126:
					newAlph += '�';
					break;
				default:
					newAlph += c;
				}
			}
		}
		super.setSecretAlphabet(newAlph);
	}
}
