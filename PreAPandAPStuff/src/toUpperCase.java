
public class toUpperCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		

	}

	public String toUpperCase(String str) {
	   String result = "";
	   for (int i = 0; i < str.length(); i++) {
	      char ch = str.charAt(i);
	      result += Character.toUpperCase(ch);
	   }
	   return result;
	}

}
