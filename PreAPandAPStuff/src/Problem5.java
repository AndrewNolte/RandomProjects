import java.util.Scanner;


public class Problem5 {

	public static void main(String[] args) {
		
		System.out.println("This program does a lot of stuff");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please eneter a string thats at least 10 characters long, dummy: ");
		String str = sc.nextLine();

		System.out.println(str.substring(4,10));
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(((int)(str.length()/2))));
		System.out.println(str.charAt(str.length()-1));
		
		for(int i = 1; i < str.length(); i+= 2){
			System.out.print(str.charAt(i) + " ");
			
		}
		
	}

}
