
import javax.swing.*;
import java.awt.Color; 
import java.awt.event.*;
import java.lang.Math;

public class CalcPanel extends JPanel implements ActionListener {
	
	String num1 = "";
	String num2 = "";
	
	boolean usingFirst = true;
	boolean onAddition = false;
	boolean onSubtraction = false;
	boolean onMultiplication = false;
	boolean onDivision = false;
	boolean canOp = false;

	JTextField display;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JButton b0;
	JButton bdec;
	JButton bclear;
	JButton bplus;
	JButton bminus;
	JButton bmultiply;
	JButton bdivide;
	JButton bequals;
	JButton bsqrt;
	JButton bsquared;
	JButton bpi;


	public CalcPanel(){
		this.setBackground(Color.white);
		setLayout(null);
		
		display = new JTextField();
		
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		
		bdec = new JButton(".");
		bclear = new JButton("C");
		bplus = new JButton("+");
		bminus = new JButton("-");
		bmultiply = new JButton("x");
		bdivide = new JButton("/");
		bequals = new JButton("=");
		bsqrt = new JButton("sqrt");
		bsquared = new JButton ("x^2");
		bpi = new JButton ("pi");
		
		
		display.	setBounds(0,0,240,60);
		
		bclear.		setBounds(0,60,60,60);
		bsqrt.		setBounds(60,60,60,60);
		bsquared.	setBounds(120,60,60,60);
		bdivide.	setBounds(180,60,60,60);
		
		b7.			setBounds(0,120,60,60);
		b8.			setBounds(60,120,60,60);
		b9.			setBounds(120,120,60,60);
		bmultiply.	setBounds(180,120,60,60);

		b4.			setBounds(0,180,60,60);
		b5.			setBounds(60,180,60,60);
		b6.			setBounds(120,180,60,60);
		bminus.		setBounds(180,180,60,60);
		
		b1.			setBounds(0,240,60,60);
		b2.			setBounds(60,240,60,60);
		b3.			setBounds(120,240,60,60);
		bplus.		setBounds(180,240,60,60);
		
		b0.			setBounds(0,300,60,60);
		bdec.		setBounds(60,300,60,60);
		bpi.		setBounds(120,300,60,60);
		bequals.	setBounds(180,300,60,60);
		

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b0);
		
		add(bsquared);
		add(bsqrt);
		add(bpi);
		
		add(display);
		add(bequals); 
		add(bdec);
		add(bclear);
		
		add(bplus);
		add(bminus);
		add(bdivide);
		add(bmultiply);

	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		
		bdec.addActionListener(this);
		bequals.addActionListener(this);
		bclear.addActionListener(this);
		bplus.addActionListener(this);
		bminus.addActionListener(this);
		bmultiply.addActionListener(this);
		bdivide.addActionListener(this);
		bpi.addActionListener(this);
		bsqrt.addActionListener(this);
		bsquared.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e){
		String s = e.getActionCommand();
		if(s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")||s.equals("5")||s.equals("6")||
		   s.equals("7")||s.equals("8")||s.equals("9")||s.equals("0")||s.equals(".")||s.equals("pi")){
			if(usingFirst == true){
				canOp = true;
				if(s == "pi"){
					if(num1.length() == 0){
						num1 = String.valueOf(Math.PI);
						display.setText(num1);
					}
					else{
						double total = Double.parseDouble(num1)* Math.PI;
						display.setText("" + total);
						num1 = display.getText();
					}
				}
				else{
					num1 = num1 + s; 
					display.setText(num1);
				}
			}
			else{
				canOp = false;
				if(s == "pi"){
					num2 = String.valueOf(Math.PI);
				}
				else{
					num2 = num2 + s;
				}
				display.setText(num2);
			}	
		}
		
		
		if(canOp == true){
			//addition
			if(s.equals("+")){
				usingFirst = false;
				resetOps();
				onAddition = true;
				num2 = "";
			}	
			//subtraction
			if(s.equals("-")){
				usingFirst = false; 
				resetOps();
				onSubtraction = true;
				num2 = "";
			}	
			//division
			if(s.equals("/")){
				usingFirst = false;
				resetOps();
				onDivision = true;
				num2 = "";
			}	
			//multiplication
			if(s.equals("x")){
				usingFirst = false;
				resetOps();
				onMultiplication = true;
				num2 = "";
			}
			
			//square root
			if(s.equals("sqrt")){
				resetOps();
				double total = Math.sqrt(Double.parseDouble(num1)); 
				display.setText(""+ total);
				usingFirst = true;
				canOp = true;
				num1 = display.getText();
				num2 = "";
			}	
			
			//square
			if(s.equals("x^2")){
				double total = Math.pow(Double.parseDouble(num1), 2);
				display.setText(""+ total);
				usingFirst = true;
				canOp = true;
				num1 = display.getText();
				num2 = "";
			}	
		}
		
		if(s.equals("=")&& onAddition == true){
			double total = Double.parseDouble(num1)+ Double.parseDouble(num2);
			display.setText(""+ total);
			usingFirst = true;
			num1 = display.getText();
			canOp = true;
		}

		if(s.equals("=") && onSubtraction == true){
			double total = Double.parseDouble(num1) - Double.parseDouble(num2); 
			display.setText("" + total);
			usingFirst = true;
			num1 = display.getText();
			canOp = true;
		}	

		if(s.equals("=") && onDivision == true){
			double total = Double.parseDouble(num1)/ Double.parseDouble(num2); 
			display.setText(""+ total);
			usingFirst = true;
			num1 = display.getText(); 
			canOp = true;
		}

		if(s.equals("=") && onMultiplication == true){
			double total = Double.parseDouble(num1) * Double.parseDouble(num2); 
			display.setText(""+ total);
			usingFirst = true;
			num1 = display.getText(); 
			canOp = true;
		}
		
		
		
		//Clear
		if(s.equals("C"))
		{
			display.setText("");
			resetOps();
			usingFirst= true;
			canOp = false;
			num1="";
			num2="";
		}
		
	}
	
	private void resetOps(){
		onAddition = false;
		onSubtraction = false;
		onMultiplication = false;
		onDivision = false;
	}

	
	public static void main(String[] args) {

		
	}

}
