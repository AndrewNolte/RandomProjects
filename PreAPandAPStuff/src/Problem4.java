import java.util.Scanner;


public class Problem4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
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

}
