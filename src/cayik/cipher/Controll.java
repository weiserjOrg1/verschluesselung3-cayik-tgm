package cayik.cipher;
import java.awt.event.*;
import javax.swing.*;


public class Controll extends keyex implements ActionListener, FocusListener{
	
	private View v1;
	private Model m1; 
	public Controll() {
		this.m1=new Model(); 
		this.v1=new View(this, this.m1); 
	}
	
	public void actionPerformed(ActionEvent e)  {		
		if(this.v1.isButtonApl(e.getSource())) {
			if(this.v1.isSubSel()) {
				this.m1.changeMode(this.v1.getSubField());
			} else if (this.v1.isShiftSel()) {
				this.m1.changeMode(this.v1.getShiftField());
			} else if (this.v1.isKeySel()) {
				this.m1.changeMode(this.v1.getKeyField());
			} else if (this.v1.isTransSel()) {
				this.m1.changeMode(this.v1.getTransField());
			}
		} else if(this.v1.isButtonRes(e.getSource())) {
			this.m1.resetAlp();
		} else if(this.v1.isButtonEnc(e.getSource())) {
			this.v1.setOutput(this.m1.encrypt(this.v1.getIn()));
		} else if(this.v1.isButtonDec(e.getSource())) {
			this.v1.setOutput(this.m1.decrypt(this.v1.getIn()));			
		} else if(this.v1.isSub(e.getSource())) {
			this.v1.changeSubShiKeyTrans(Model.SUB);
		} else if(this.v1.isShift(e.getSource())) {
			this.v1.changeSubShiKeyTrans(Model.SHIFT);
		} else if(this.v1.isKey(e.getSource())) {
			this.v1.changeSubShiKeyTrans(Model.KEY);
		} else if(this.v1.isTrans(e.getSource())) {
			this.v1.changeSubShiKeyTrans(Model.TRAN);
		}
		
	}
	
	public void focusGained(FocusEvent e) {
		if(this.v1.isSub(e.getSource())) {
			this.v1.changeSubShiKeyTrans(Model.SUB);
		} else if(this.v1.isShift(e.getSource())) {
			this.v1.changeSubShiKeyTrans(Model.SHIFT);
		} else if(this.v1.isKey(e.getSource())) { 
			this.v1.changeSubShiKeyTrans(Model.KEY);
		} else if(this.v1.isTrans(e.getSource())) {
			this.v1.changeSubShiKeyTrans(Model.TRAN);
		}
	}
	
	public void focusLost(FocusEvent e) {
		
	}
}
