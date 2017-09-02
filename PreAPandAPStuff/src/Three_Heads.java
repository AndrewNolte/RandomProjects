import java.util.Random;


public class Three_Heads {

	static Random rnd = new Random();

	public static void main(String[] args) {
		
		for(int i = 0; i < 3;){
			
			if(rnd.nextBoolean() == true){
				System.out.println("H");
				i++;
			}
			else{
				System.out.println("T");
				i = 0;
			}
		}

	}

}
