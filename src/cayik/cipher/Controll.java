package cayik.cipher;
import java.awt.event.*;
import javax.swing.*;


public class Controll implements ActionListener, FocusListener{
	
	private View v1;
	private Model m1; 
	public Controll() {
		this.m1=new Model(); 
		this.v1=new View(this, this.m1); 
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this.v1.isButtonApl(e.getSource())) {
			if(this.v1.isSubSel()) {
				this.m1.changeMode(this.v1.getSubField());
			} else {
				this.m1.changeMode(this.v1.getShiftField());
			}
		} else if(this.v1.isButtonRes(e.getSource())) {
			this.m1.resetAlp();
		} else if(this.v1.isButtonEnc(e.getSource())) {
			this.v1.setOutput(this.m1.encrypt(this.v1.getIn()));
		} else if(this.v1.isButtonDec(e.getSource())) {
			this.v1.setOutput(this.m1.decrypt(this.v1.getIn()));			
		} else if(this.v1.isSub(e.getSource())) {
			this.v1.changeSubShi(Model.SUB);
		} else if(this.v1.isShift(e.getSource())) {
			this.v1.changeSubShi(Model.SHIFT);
		}
	}
	
	public void focusGained(FocusEvent e) {
		if(this.v1.isSub(e.getSource())) {
			this.v1.changeSubShi(Model.SUB);
		} else if(this.v1.isShift(e.getSource())) {
			this.v1.changeSubShi(Model.SHIFT);
		}
	}
	
	public void focusLost(FocusEvent e) {
		
	}
}
