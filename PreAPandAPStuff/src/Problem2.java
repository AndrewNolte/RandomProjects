import java.util.Scanner;


public class Problem2 {

	public static void main(String[] args) {
		System.out.println("This program prints out the last three characters of the string");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please eneter a string, dummy: "); //<--Mr. Kenney's signature
		String str = sc.nextLine();
	
			
		System.out.println("The last three letters are " + str.substring(str.length()-3));
	}

}
