/*
 * Author: Dan Wester, Chris Sadler, Brian Hanson     
 *
 * Date: December 11th, 2012    
 *
 * Course: 2247-01 Fall
 *
 * Assignment: TA6 Recursion 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class FibGui extends JFrame {

	// define variables

	JPanel southPanel;
	JTextArea northPanel, outputBox, errorPanel;
	JLabel labelInputNum, labelOutputNum, messages;
	JTextField inputBox;
	JButton calculateRButt, calculateNRButt, exitButt, clearButt;
	FibGui.ExitButtonHandler exitButtHand;
	FibGui.ClearButtonHandler clearButtHand;
	FibGui.CalculateRButtonHandler calculateRButtHand;
	FibGui.CalculateNRButtonHandler calculateNRButtHand;
	String testRecursResultNum, testNonRecursResultNum;
	String errorMessage;

	public FibGui() {

		// BorderLayout panels

		northPanel = new JTextArea(
				"Welcome to the Fibonacci calculator.  Please enter a  value to begin.");

		southPanel = new JPanel(new GridLayout(5, 2));

		errorPanel = new JTextArea("");

		// northPanel

		northPanel.setEditable(false);

		// southPanel labels

		labelInputNum = new JLabel("Enter input: ", SwingConstants.RIGHT);
		labelOutputNum = new JLabel("Fibonacci ouput: ", SwingConstants.RIGHT);
		messages = new JLabel("Messages: ", SwingConstants.RIGHT);

		// southPanel boxes

		inputBox = new JTextField("", SwingConstants.RIGHT);
		outputBox = new JTextArea();
		outputBox.setEditable(false);

		// southPanel buttons and handlers

		exitButt = new JButton("Exit");
		exitButtHand = new FibGui.ExitButtonHandler();
		clearButt = new JButton("Reset");
		clearButtHand = new FibGui.ClearButtonHandler();
		calculateRButt = new JButton("Calculate Recursive");
		calculateRButtHand = new FibGui.CalculateRButtonHandler();
		calculateNRButt = new JButton("Calculate Non-Recursive");
		calculateNRButtHand = new FibGui.CalculateNRButtonHandler();

		// southPanel action listeners

		exitButt.addActionListener(exitButtHand);
		clearButt.addActionListener(clearButtHand);
		calculateRButt.addActionListener(calculateRButtHand);
		calculateNRButt.addActionListener(calculateNRButtHand);

		// southPanel add

		southPanel.add(labelInputNum);
		southPanel.add(inputBox);
		southPanel.add(labelOutputNum);
		southPanel.add(outputBox);
		southPanel.add(messages);
		southPanel.add(errorPanel);
		southPanel.add(calculateRButt);
		southPanel.add(calculateNRButt);
		southPanel.add(exitButt);
		southPanel.add(clearButt);

		// errorPanel

		errorPanel.setEditable(false);
		errorPanel.setLineWrap(true);

		Font font = new Font("Verdana", Font.BOLD, 12);
		errorPanel.setFont(font);
		errorPanel.setForeground(Color.RED);

		// default layout

		setLayout(new BorderLayout());
		setTitle("Fibonacci Calculator");
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.CENTER);
		setSize(675, 275);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		

	}

	// private classes

	// exit button code
	private class ExitButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.exit(0);

		}
	}

	// clear button code
	private class ClearButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			inputBox.setText(null);
			outputBox.setText(null);
			errorPanel.setText(null);
		}
	}

	// calculate recursive button code
	private class CalculateRButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			outputBox.setText(null);
			errorPanel.setText(null);

			try {

				/*RecursiveFib test = new RecursiveFib();*/

				//int recursIve = Integer.parseInt(inputBox.getText());

				/*testRecursResultNum = test.runTest(recursIve);*/
                                /*testRecursResultNum = RecursiveFib.runTest(Integer.parseInt(inputBox.getText()));

				outputBox.setText(testRecursResultNum);*/
                            
				outputBox.setText(RecursiveFib.runTest(Integer.parseInt(inputBox.getText())));

			} catch (NumberFormatException nfe) {

				errorPanel.setText("Value must be between 0 and 45.");
			}

		}
	}

	// calculate non recursive button code
	private class CalculateNRButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			outputBox.setText(null);
			errorPanel.setText(null);

			try {

				/*NonRecursiveFib test = new NonRecursiveFib();*/

				//int nonRecursIve = Integer.parseInt(inputBox.getText());

				//testNonRecursResultNum = test.fibTime(nonRecursIve);
                                /*testNonRecursResultNum = NonRecursiveFib.fibTime(Integer.parseInt(inputBox.getText()));
				outputBox.setText(testNonRecursResultNum);*/
                            
				outputBox.setText(NonRecursiveFib.fibTime(Integer.parseInt(inputBox.getText())));
                                
			} catch (NumberFormatException nfe) {
                            
				errorPanel.setText("Value must be between 0 and 45.");
			}

		}
	}

	// main

	public static void main(String args[]) {
		new FibGui();

	}
}
