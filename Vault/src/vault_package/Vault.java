package vault_package;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Imports. Here I import all Java Swing Elements...
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Extends JFrame. I did this so I don't have to start each line with JFrame.
public class Vault extends JFrame {
	private static final long serialVersionUID = 1L;
	// Variables:
	private JButton Submit;
	private JTextField un_input, pw_input;
	private String pw, un;

	public Vault() {
		// Settings
		super("Vault - Version 1.0");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setLayout(new BorderLayout());
		// Define
		un_input = new JTextField("Username");
		pw_input = new JTextField("Password");
		Submit = new JButton("Submit");
		// Add elements to JFrame...
		add(un_input, BorderLayout.NORTH);
		add(pw_input, BorderLayout.CENTER);
		add(Submit, BorderLayout.SOUTH);
		// Adding Action Listener to the Submit Button(14, 28, 32)
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Getting Username and Password:
				pw = pw_input.getText();
				un = un_input.getText();
				// Making the String that will be saved...
				String writing = un + "," + pw;
				// Printing (Debug code) This will soon be deleted.
				System.out.println(pw + ", " + un);
				// This is the name for the stored file.
				String name = JOptionPane.showInputDialog("Enter Account Name");

				try {
					// Code for saving the file. Saved in a folder in my desktop...
					BufferedWriter writer = new BufferedWriter(
							new FileWriter("C:\\Users\\calvi\\OneDrive\\Desktop\\Vault\\" + name + ".csv"));
					// Added data to file.
					writer.write(writing);
					// Closing writer...
					writer.close();
					// IOExceptions...
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
	}
}
