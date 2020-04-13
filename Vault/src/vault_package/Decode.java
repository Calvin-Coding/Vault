package vault_package;

public class Decode {
	String username;
	String password;

	public Decode(String raw, int code) {
		/*
		 * This will be the decoder for the vault. How this works...
		 * 
		 */

		String pw_first, un_first;
		// First split the raw data into the username and password.
		String[] first = raw.split(",");
		// Next making Strings out of not decoded usernames and passwords
		un_first = first[0];
		pw_first = first[1];
		// Splitting into each character
		String[] pw_second = pw_first.split(";");
		String[] un_second = un_first.split(";");
		// Char array for username...
		char[] un_char = new char[un_second.length];
		for (int i = 0; i < un_second.length; i++) {
			// Getting String version of the string.
			String str = un_second[i];
			// Changing String to int
			int in = Integer.parseInt(str);
			// Getting rid of code.
			in = in - code;
			// Turning int into char...
			char cha = (char) in;
			un_char[i] = cha;
		}
		char[] pw_char = new char[pw_second.length];
		// This works the same as the last one.
		for (int i = 0; i < pw_second.length; i++) {
			String str = pw_second[i];
			int in = Integer.parseInt(str);
			in = in - code;
			char cha = (char) in;
			pw_char[i] = cha;
		}
		// Getting all the decrypted chars into Strings.
		for (char x : un_char) {
			String s = Character.toString(x);
			username = username + s;
		}
		for (char x : pw_char) {
			String s = Character.toString(x);
			password = password + s;
		}
		// TA-DA!!!
	}
}
