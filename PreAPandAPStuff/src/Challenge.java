import java.util.Scanner;


public class Challenge {


	public static void main(String[] args) {
		System.out.println("This program returns the first vowel in a string");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please eneter a string, dummy: ");
		String str = sc.nextLine();
		
		char[] vowels = {'a','e','i','o','u'};
		
		
		for(int i = 0; i < str.length();i++ ){
			for(int j = 0; j < vowels.length; j++){
				if(str.charAt(i) == vowels[j]){
					System.out.println("The first vowel in the string is " + "'" + str.charAt(i) + "' " + "at index location " + i);
					System.out.println("and if you're stupid, the location is " + (i + 1));
					return;
				}
			}
		}
	
			
	}

}
