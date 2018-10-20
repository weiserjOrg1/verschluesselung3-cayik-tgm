package cayik.cipher;
import javax.swing.JOptionPane;

public class Model {
	//A:
	public static final int SUB=0;
	public static final int SHIFT=1;
	public static final int KEY=2;
	public static final int TRAN=3;
	
	private int selectedMode;
	private SubstitutionCipher subst;
	private ShiftCipher shiftc;
	private MonoAlphabeticCipher cipher;
	private TranspositionCipher tc;
	
	public Model() {
		this.selectedMode=SHIFT;
		this.cipher=new MonoAlphabeticCipher();
	}
	
	public void changeMode(String input) {
		try {
			switch (this.selectedMode) {
				case SUB:
					this.cipher = new SubstitutionCipher(input);
					break;
				case SHIFT:
					int inputValue = Integer.parseInt(input);
					this.cipher = new ShiftCipher(inputValue);
					break;
				case KEY:
					this.cipher = new KeywordCipher(input);
					break;
				case TRAN:
					inputValue = Integer.parseInt(input);
					this.tc = new TranspositionCipher(inputValue);
					break;
			}	
			JOptionPane.showMessageDialog(null, "Changed");
			
		} catch (MyException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input is not a number.", "Error",JOptionPane.ERROR_MESSAGE);
		} catch (keyex e) {
			
		}
	}
	
	public void resetAlp() {
		this.cipher = new MonoAlphabeticCipher();
		this.tc = new TranspositionCipher(1);
		JOptionPane.showMessageDialog(null, "Reseted");
	}
	
	public String encrypt(String text) {
		return (this.selectedMode != TRAN) ? this.cipher.encrypt(text) : this.tc.encrypt(text);
	}
	
	public String decrypt(String text) {
		return (this.selectedMode != TRAN) ? this.cipher.decrypt(text) : this.tc.decrypt(text);
	}
	
	public void setMode(int value) {
		if (value != TRAN) {
			this.cipher = new MonoAlphabeticCipher();
		} else {
			this.tc = new TranspositionCipher(1);
		}
		this.selectedMode= value;
	}
	
	public int getSelectedMode() {
		return this.selectedMode;
	}	
}
