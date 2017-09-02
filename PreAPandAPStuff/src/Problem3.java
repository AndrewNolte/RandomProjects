import java.util.Scanner;


public class Problem3 {


	public static void main(String[] args) {

		System.out.println("This program prints out the last letter of two strings.");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please eneter two strings, dummy: ");
		String str = sc.nextLine();
		String str2 = sc.nextLine();
			
		System.out.println(str.charAt(str.length()-1) + " " + str2.charAt(str2.length()-1));
	}

}
