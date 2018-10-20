package cayik.cipher;
import javax.swing.JOptionPane;

public class Model {
	//A:
	public static final int SUB=0;
	public static final int SHIFT=1;
	
	private int selectedMode;
	private SubstitutionCipher subst;
	private ShiftCipher shiftc;
	
	public Model() {
		this.selectedMode=SHIFT;
		this.subst=new SubstitutionCipher();
		this.shiftc=new ShiftCipher();
	}
	
	public void changeMode(String input) {
		try {
			if (this.selectedMode == SUB) {
				this.subst.setSecretAlphabet(input);
				JOptionPane.showMessageDialog(null, "Changed");
			} else {
				try {
					int inp= Integer.parseInt(input);
					this.shiftc.setShiftValue(inp);
					JOptionPane.showMessageDialog(null, "Changed");
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error: Input is not a number.", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (MyException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			
		}		
	}
	
	public void resetAlp() {
		this.subst=new SubstitutionCipher(); 
		this.shiftc= new ShiftCipher(); 
		JOptionPane.showMessageDialog(null, "Reseted");
	}
	
	public String encrypt(String text) {
		String re;
		if(this.selectedMode==SUB) {
			re=this.subst.encrypt(text);
		} else {
			re=this.shiftc.encrypt(text);
		}
		
		return re;
	}
	
	public String decrypt(String text) {
		String re;
		if(this.selectedMode==SUB) {
			re=this.subst.decrypt(text);
		} else {
			re=this.shiftc.decrypt(text);
		}
		
		return re;
	}
	
	public void setMode(int value) {
		this.selectedMode=value; 
	}
	
	public int getSelectedMode() {
		return this.selectedMode;
	}	
}
