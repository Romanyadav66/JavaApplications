package org.Calculator;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CalApp extends JFrame implements ActionListener{

	 
	private static final long serialVersionUID = -1315467733997126666L;

	static JFrame frame;
	static JTextField textField;
	String first, second, operator;
	
	CalApp() {
		first = second = operator = "";
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		
		frame = new JFrame("cal");
		UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		CalApp calculator = new CalApp();
		textField = new JTextField(16);
		textField.setEditable(false);
		
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAdd, bSub, bDiv, bMul, bDot,
		bClr, bEq;
		
		
		
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		
		bEq = new JButton("=");

		bAdd = new JButton("+");
		bSub = new JButton("-");
		bDiv = new JButton("/");
		bMul = new JButton("*");
		bClr = new JButton("C");

		bDot = new JButton(".");

		bMul.addActionListener(calculator);
		bDiv.addActionListener(calculator);
		bSub.addActionListener(calculator);
		bAdd.addActionListener(calculator);
		b9.addActionListener(calculator);
		b8.addActionListener(calculator);
		b7.addActionListener(calculator);
		b6.addActionListener(calculator);
		b5.addActionListener(calculator);
		b4.addActionListener(calculator);
		b3.addActionListener(calculator);
		b2.addActionListener(calculator);
		b1.addActionListener(calculator);
		b0.addActionListener(calculator);
		bDot.addActionListener(calculator);
		bClr.addActionListener(calculator);
		bEq.addActionListener(calculator);
		
		JPanel panel = new JPanel();
		panel.add(textField);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(bDiv);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(bMul);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(bSub);
		panel.add(bDot);
		panel.add(bClr);
		panel.add(b0);
		panel.add(bAdd);
		panel.add(bEq);
		
		panel.setBackground(Color.BLACK);
		
		frame.add(panel);
		frame.setSize(220, 230);
		frame.show();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();
		// if the value is number
		if ((action.charAt(0) >= '0' && action.charAt(0) <= '9') || action.charAt(0) == '.') {
			if(action.equals(".") && first.contains(".")) {
				// no action
			}
			else if (!operator.equals(""))
				second = second + action;
			else
				first = first + action;

			textField.setText(first + operator + second);
		}else if (action.charAt(0) == 'C') {
			operator = second = "";
			first = "0";
			// set the value of text
			textField.setText(first + operator + second);
		}else if (action.charAt(0) == '=' && !first.equalsIgnoreCase("") && !second.equalsIgnoreCase("")) {

			double result;
			if (operator.equals("+"))
				result = (Double.parseDouble(first) + Double.parseDouble(second));
			else if (operator.equals("-"))
				result = (Double.parseDouble(first) - Double.parseDouble(second));
			else if (operator.equals("/"))
				result = (Double.parseDouble(first) / Double.parseDouble(second));
			else
				result = (Double.parseDouble(first) * Double.parseDouble(second));

			textField.setText(first + operator + second + "=" + result);
			first = Double.toString(result);
			operator = second = "";
		} else {
			if (operator.equals("") || second.equals(""))
				operator = action;
			else {
				double result;
				if (operator.equals("+"))
					result = (Double.parseDouble(first) + Double.parseDouble(second));
				else if (operator.equals("-"))
					result = (Double.parseDouble(first) - Double.parseDouble(second));
				else if (operator.equals("/"))
					result = (Double.parseDouble(first) / Double.parseDouble(second));
				else
					result = (Double.parseDouble(first) * Double.parseDouble(second));
				first = Double.toString(result);
				operator = action;
				second = "";
			}

			if (first.equals("")) {
				first = operator = second = "";
			} else if(second.equals("") && operator.equals("=")) {
				operator = "";
			}
			textField.setText(first + operator + second);
		}
		
	}

}