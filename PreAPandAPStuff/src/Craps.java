import java.util.Random;
import java.util.Scanner;


public class Craps {

	static Random rnd = new Random();
	static Scanner sc = new Scanner(System.in);
	static int[] totals = new int[12];


	public static void main(String[] args) {
		
		for(int i = 1; i < 7; i++){
			for(int j = 1; j < 7; j++){
				int tots = i + j;
				totals[tots-1]++;
			}
		}
		System.out.println("Your chance of Losing is 30%");
		System.out.println("Your chance of Winning is 26%");

		int point;
		
		int r1 = rnd.nextInt(6) + 1;
		int r2 = rnd.nextInt(6) + 1;
		int total = r1 + r2;
		System.out.println("you rolled a " + r1 + " and a " + r2);
		System.out.println("Your total is " + total);
		
		if(total == 2 || total == 6 || total == 12 ){
			System.out.println("Oh craps you lost ");
			return;
		}
		
		if(total == 7 || total == 11){
			System.out.println("Wow you actually won");
			return;
		}
		System.out.println("Ok you didn't win anything yet lets keep playing");
		point = total;
		
		System.out.println("Your chance of Losing is 23%");
		System.out.println("Your chance of Winning is " + (totals[point-1])* 100 /26 + "%");
		
		for(boolean isDone = false; isDone == false;){
			


			r1 = rnd.nextInt(6) + 1;
			r2 = rnd.nextInt(6) + 1;
			total = r1 + r2;
			System.out.println("Your total is " + total);
			
			if(total == point){
				System.out.println("Wow you actually won");
				isDone = true;
			}
			if(total == 7){
				System.out.println("Oh craps you rolled a 7 so you lost ");
				isDone = true;
			}
		}	

	}

}
