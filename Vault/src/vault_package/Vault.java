package vault_package;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Imports. Here I import all Java Swing Elements...
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Extends JFrame. I did this so I don't have to start each line with JFrame.
public class Vault extends JFrame {
	private static final long serialVersionUID = 1L;
	// Variables:
	private JButton Submit, open;
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
		open = new JButton("Open");
		// Add elements to JFrame...
		add(un_input, BorderLayout.NORTH);
		add(pw_input, BorderLayout.SOUTH);
		add(Submit, BorderLayout.WEST);
		add(open, BorderLayout.EAST);
		// Adding Action Listener to the Submit Button(14, 28, 32)
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Getting Username and Password:
				pw = pw_input.getText();
				un = un_input.getText();
				// Printing (Debug code) This will soon be deleted.
				System.out.println(pw + ", " + un);
				// This is the name for the stored file.
				String name = JOptionPane.showInputDialog("Enter Account Name");
				String codess = JOptionPane.showInputDialog("Enter Account Code...");
				int codes = Integer.parseInt(codess);

				Encode encode1 = new Encode(pw, un, codes);

				// String that will be saved...
				String ends = encode1.end;

				try {
					// Code for saving the file. Saved in a folder in my desktop...
					BufferedWriter writer = new BufferedWriter(
							new FileWriter("C:\\Users\\calvi\\OneDrive\\Desktop\\Vault\\" + name + ".csv"));
					// Added data to file.
					writer.write(ends);
					// Closing writer...
					writer.close();
					// IOExceptions...
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}

		});
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Getting Account name...
				String name = JOptionPane.showInputDialog("Enter Account Name...");
				// Getting Code to Decode...
				String codestr = JOptionPane.showInputDialog("Enter Account Code...");
				int code = Integer.parseInt(codestr);
				File myFile = new File("C:\\Users\\calvi\\OneDrive\\Desktop\\Vault\\" + name + ".csv");
				try {
					// Reading file...
					Scanner scanned = new Scanner(myFile);
					String data = scanned.nextLine();
					scanned.close();
					// Using Decode meathod to decode the data...
					Decode dec = new Decode(data, code);
					// Replacing null in the passwords...
					String passwords = dec.password.replace("null", "");
					String usernames = dec.username.replace("null", "");
					// Showing Data
					JOptionPane.showMessageDialog(null,
							"Your Username us: " + usernames + "\n" + "Your Password is: " + passwords);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

			}
		});
	}
}
