import java.util.Scanner;

public class LargerString {


	public static void main(String[] args) {
		
		System.out.println("This program prints out the larger of two strings.");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter two strings, dummy: ");
		String str = sc.nextLine();
		String str2 = sc.nextLine();
		String answer;
		if(str.length() > str2.length()){
			answer = str;
		}
		else if(str.length() < str2.length()){
			answer = str2;

		}
		else{
			System.out.println("These strings are equal stupid.");
			return;
		}
			
		System.out.println("The larger string is " + answer);
		
	}

}
