import java.util.Scanner;
public class ReverseStringExample {

	public static void main(String[] args) {
		
		System.out.println("This program reverses a string.");
		Scanner kb = new Scanner(System.in);
		System.out.println("Please eneter a String, dummy: ");
		String str = kb.nextLine();
		String rev = reverseString(str);
		System.out.println(str + " spelled backwards is " + rev);

	}
	
	private static String reverseString(String yoda){
		String result = " ";
		
		for(int i = 0; i < yoda.length(); i++){
			
			result = yoda.charAt(i) + result;
		}
		return result;
	}

}
