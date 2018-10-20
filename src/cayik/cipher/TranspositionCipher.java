package cayik.cipher;

public class TranspositionCipher implements Cipher{
	private int level;
	
	public TranspositionCipher(int level) {
		this.level=level;
	}
	
	public void setLevel(int level) {
		if (level >= 1)
			this.level = level;
	}
	
	//Encrypt:
	public String encrypt(String text) {
		text = text.toLowerCase();
		String filText = "";
		for (int i = 0; i < text.length(); i++) { // 
			char c = text.charAt(i);
			switch (c) {
			case 'ä':
			case 'ö':
			case 'ü':
			case 'ß':
				filText += c;
				break;
			default:
				if (c >= 97 && c <= 122)
					filText += c;
			}
		}
		
		String output = "";
		char[][] cArray = new char[this.level + 1][filText.length()];
		boolean up = false;
		int k = 0;
		for (int i = 0; i < filText.length(); i++) {
			cArray[k][i] = filText.charAt(i);
			if (!up)
				k++;
			if (up)
				k--;
			if (k == this.level)
				up = true;
			if (k == 0)
				up = false;
		}
		
		int used = 0;
		for (int i = 0; i < cArray.length; i++) {
			for (int j = 0; j < cArray[i].length; j++) {
				if (cArray[i][j] != 0) {
					output += cArray[i][j];
					used++;
				}
			}
			if (used >= filText.length())
				break;
			if (i != cArray.length - 1)
				output += ' ';
		}
		return output;
	}
	
	//Decrypt:
	public String decrypt(String text) {
		text = text.toLowerCase();
		if (text.indexOf(' ') == -1)
			return text;
		String[] pieces = new String[this.level + 1];
		int sA = 0;
		
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ')
				sA++;
			if (i == text.length() - 1 && sA != this.level)
				return text;
		}
		int lastIndex = 0;
		int lP = 0;
		
		for (int i = 0; i < this.level + 1; i++) {
			if (i != this.level) {
				pieces[i] = text.substring(lastIndex, text.indexOf(' ', lastIndex));
				if (pieces[i].length() > lP)
					lP = pieces[i].length();
			} else {
				pieces[i] = text.substring(lastIndex);
				if (pieces[i].length() > lP)
					lP = pieces[i].length();
			}
			lastIndex = text.indexOf(' ', lastIndex) + 1;
		}
		int pieceLength = 0;
		
		for (int i = 0; i < pieces.length; i++) {
			pieceLength += pieces[i].length();
		}
		String output = "";
		int firstIndex = 0, lastPieceIndex = 0, lettersUsed = 0;
		
		if (this.level > 1) {
			xyz: for (int i = 0; i < lP; i++) {
				if (i % 2 == 0) {
					for (int j = (i == 0) ? 0 : 1; j < pieces.length; j++) {
						if (j == 0) {
							output += pieces[j].charAt(firstIndex);
							firstIndex++;
							lettersUsed++;
						} else if (j == pieces.length - 1) {
							output += pieces[j].charAt(lastPieceIndex);
							lastPieceIndex++;
							lettersUsed++;
						} else if (!(pieces[j].length() < (i + 1))) {
							output += pieces[j].charAt(i);
							lettersUsed++;
						}
						if (lettersUsed == pieceLength) {
							break xyz;
						}
					}
				} else {
					for (int j = pieces.length - 2; j > -1; j--) {
						if (j == 0) {
							output += pieces[j].charAt(firstIndex);
							firstIndex++;
							lettersUsed++;
						} else if (!(pieces[j].length() < (i + 1))) {
							output += pieces[j].charAt(i);
							lettersUsed++;
						}
						if (lettersUsed == pieceLength) {
							break xyz;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < lP; i++) {
				if (i == lP - 1 && pieces[0].length() != pieces[1].length()) {
					output += pieces[0].charAt(i);
				} else {
					output += pieces[0].charAt(i) + "" + pieces[1].charAt(i);
				}

			}
		}
		return output;
	}
}
