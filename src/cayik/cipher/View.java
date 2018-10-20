package cayik.cipher;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.*; 

public class View extends JFrame{
	//private MonoAlphabeticCipher m1; 
	
	private JTextField shiftField; 
	private JTextField subField; 
	private JTextField inField;
	private JTextField outField;
	
	private JLabel subVerschl;
	private JLabel shiftVerschl;
	private JLabel input; 
	private JLabel output; 
	
	private JRadioButton subAuswahl;
	private JRadioButton shiftAuswahl;
	private ButtonGroup buttongroup1; 
	private JButton buttonEnc;
	private JButton buttonDec;
	private JButton buttonApl;
	private JButton buttonRes;
	
	private JPanel selbox;
	private JPanel alphbox;
	private JPanel enDePanel; 
	private JPanel inOutPanel;
	
	private Controll c1;
	private Model m1; 
	
	public View(Controll c, Model m){
		this.c1=c; 
		this.m1=m; 
		
		this.setTitle("Verschlüsselung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout()); 
		this.setSize(1000, 1000);
		
		//Buttons:
		this.subAuswahl= new JRadioButton("Sub",true);
		this.shiftAuswahl= new JRadioButton("Shift");
		
		this.subAuswahl.addActionListener((ActionListener) this.c1);
		this.subAuswahl.addFocusListener((FocusListener) this.c1);
		
		this.shiftAuswahl.addActionListener((ActionListener) this.c1);
		this.shiftAuswahl.addFocusListener((FocusListener) this.c1);
		
		this.buttongroup1= new ButtonGroup(); 
		this.buttongroup1.add(this.subAuswahl);
		this.buttongroup1.add(this.shiftAuswahl);
		
		this.buttonApl=new JButton("Generate");
		this.buttonApl.addActionListener((ActionListener) this.c1);
		this.buttonRes= new JButton("Return"); 
		this.buttonRes.addActionListener((ActionListener) this.c1);
		
		this.buttonEnc= new JButton("Encrypt");
		this.buttonEnc.addActionListener((ActionListener)this.c1);
		this.buttonDec= new JButton("Decrypt");
		this.buttonDec.addActionListener((ActionListener)this.c1);
		
		//Panels
		this.selbox= new JPanel(); 
		this.add(this.selbox, BorderLayout.NORTH);
		
		this.alphbox= new JPanel(); 
		this.add(this.alphbox, BorderLayout.CENTER);
		
		
		this.inOutPanel=new JPanel(); 
		this.add(this.inOutPanel, BorderLayout.SOUTH);
		
		this.enDePanel=new JPanel();
		this.add(this.enDePanel, BorderLayout.WEST);
		
		//Selection-Box
		this.selbox.add(this.subAuswahl);
		this.selbox.add(this.shiftAuswahl);
		
		//Alphabet-Selection-Box
		this.subVerschl= new JLabel("Substitution:"); 
		this.shiftVerschl= new JLabel ("Shift:");
		this.shiftField= new JTextField();
		this.subField=new JTextField(); 
		
		this.alphbox.setLayout(new GridLayout(3,2));
		this.alphbox.add(this.subVerschl);
		this.alphbox.add(this.subField);
		
		this.alphbox.add(this.shiftVerschl);
		this.alphbox.add(this.shiftField);
		
		this.alphbox.add(this.buttonApl);
		this.alphbox.add(this.buttonRes);
		
		
		//In-Box
		this.input=new JLabel("Input: ");
		this.inField=new JTextField(); 
		this.inOutPanel.setLayout(new GridLayout(1,4));
		this.inOutPanel.add(this.input);
		this.inOutPanel.add(this.inField); 
		
		this.output=new JLabel("Output: "); 
		this.outField= new JTextField();
		this.inOutPanel.add(this.output);
		this.inOutPanel.add(this.outField);
		this.outField.setEditable(false);
		
		//EnDec-Box
		this.enDePanel.setLayout(new GridLayout(1,2));
		this.enDePanel.add(this.buttonEnc);
		this.enDePanel.add(this.buttonDec);
		
		this.setVisible(true);		
		
	}
	
	public boolean isSubSel() {
		boolean sel;
		if(this.subAuswahl.isSelected()) {
			sel=true;
		} else {
			sel=false;
		}
		return sel;
	}
	
	public boolean isSub(Object o) {
		if(o==this.subAuswahl) return true; 
		return false; 
	}
	
	public boolean isShiftSel() {
		boolean sel;
		if(this.shiftAuswahl.isSelected()) {
			sel=true;
		} else {
			sel=false;
		}
		return sel;
	}
	
	public boolean isShift(Object o) {
		if(o==this.shiftAuswahl) return true; 
		return false; 
	}
	
	public String getSubField() {
		return this.subField.getText();
	}
	
	public String getShiftField() {
		return this.shiftField.getText();
	}
	
	public String getIn() {
		return this.inField.getText();
	}
	
	public void setOutput(String output) {
		this.outField.setText(output);
	}
	
	public boolean isButtonApl(Object o) {
		if(o==this.buttonApl) return true;
		return false;
	}
	
	public boolean isButtonRes(Object o) {
		if(o==this.buttonRes) return true;
		return false;
	}
	
	public boolean isButtonEnc(Object o) {
		if(o==this.buttonEnc) return true;
		return false;
	}
	
	public boolean isButtonDec(Object o) {
		if(o==this.buttonDec) return true;
		return false;
	}
	
	// changeLayout
	public void changeSubShi(int value) {
		if(value == Model.SHIFT) {
			this.shiftField.setEditable(true);
			this.subField.setEditable(false);
			this.m1.setMode(Model.SHIFT);
		} else {
			this.subField.setEditable(true);
			this.shiftField.setEditable(false);
			this.m1.setMode(Model.SUB);
		}
	}
}