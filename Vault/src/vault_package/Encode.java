package vault_package;

public class Encode {
	String end;

	public Encode(String pass, String user, int code) {
		// Debug code (the println will be removed...)
		System.out.println("starting...");
		/*
		 * the end string is the product of the result. It has the Username first than
		 * the password. Each char is separated by a comma(,), and the password and the
		 * username is separated by a semi-colon (;)
		 */
		end = "";
		// String is split into char arrays.
		char[] pw_char = pass.toCharArray();
		char[] us_char = user.toCharArray();
		// Debug Code (the println will be removed)
		System.out.println("Encrypting Username...");
		for (int x = 0; x < us_char.length; x++) {

			int convert = us_char[x];

			convert += code;
			// Changing char int to string for storing...
			// String con = Integer.toString(convert);

			if (x == 0) {
				end = end + convert;
			} else {
				end = end + ";" + convert;
			}
		}
		// Debug code (The println will be removed...)
		System.out.println("Encrypting Password...");
		for (int x = 0; x < pw_char.length; x++) {

			int convert = pw_char[x];
			convert += code;
			// String con = Integer.toString(convert);

			if (x == 0) {
				end = end + "," + convert;
			} else {
				end = end + ";" + convert;
			}

		}
		// Debug code...
		System.out.println(end);

	}
}
