import java.util.Random;
public class Random_Dice {

	static Random rnd = new Random();


	public static void main(String[] args) {

		System.out.println("you rolled a " + (rnd.nextInt(6)+1));
		System.out.println("you rolled a " + (rnd.nextInt(6)+1));

	}

}
