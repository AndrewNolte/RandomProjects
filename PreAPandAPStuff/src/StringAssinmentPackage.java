import java.util.Scanner;


public class StringAssinmentPackage {
	
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		/*
		System.out.println("Whatchu wanna do boi");
		System.out.println("Enter in a number 1 - 6 that corresponds to a program");
		int pr = sc.nextLine().
		if(pr == 1){
			p1();
		}
		else if(pr == 2){
			p2();
		}		
		else if(pr == 3){
			p3();
		}
		else if(pr == 4){
			p4();
		}
		else if(pr == 5){
			p5();
		}
		else if(pr == 6){
			p6();
		}
		else{
			System.out.println("Thats not a program stupid");
		}

		sc.nextLine();
*/
	}
	
	public static void p1(){
		
		System.out.println("This program prints out the larger of two strings.");
		System.out.println("Please enter two strings, dummy: ");
		String str = sc.nextLine();
		String str2 = sc.nextLine();
		System.out.println(str + "alsfasdjljl" + str2);

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
	
	public static void p2(){
		
		System.out.println("This program prints out the last three characters of the string");
		System.out.println("Please eneter a string, dummy: ");
		String str = sc.nextLine();
		
		System.out.println("The last three letters are " + str.substring(str.length()-3));
		
	}
	
	public static void p3(){
		
		System.out.println("This program prints out the last letter of two strings.");
		System.out.println("Please eneter two strings, dummy: ");
		String str = sc.nextLine();
		String str2 = sc.nextLine();
			
		System.out.println(str.charAt(str.length()-1) + " " + str2.charAt(str2.length()-1));
		
	}
	
	public static void p4(){
		
		System.out.println("This program prints out remaining letters of the longer strings and 0 if they're equal");
		System.out.println("Please eneter two strings, dummy: ");
		String str = sc.nextLine();
		String str2 = sc.nextLine();
		String l;
		String s;
		String answer = "";
		
			
		if(str.length() == str2.length()){
			System.out.println("0");
		}
		else{
			if(str.length() > str2.length()){
				l = str;
				s = str2;
			}
			else{
				l = str2;
				s = str;
			}
			for(int i = s.length(); i < l.length(); i++){
				answer = answer + l.charAt(i);
			}
			System.out.println(answer);		
		}
	}
	
	public static void p5(){
		
	
		System.out.println("This program does a lot of stuff");
		System.out.println("Please eneter a string, dummy: ");
		String str = sc.nextLine();

		System.out.println(str.substring(4,10));
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(((int)(str.length()/2))));
		System.out.println(str.charAt(str.length()-1));
		
		for(int i = 1; i < str.length(); i+= 2){
			System.out.print(str.charAt(i) + " ");
		}
			
	}
		
	public static void p6(){
		
		System.out.println("This program returns the first vowel in a string");
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
