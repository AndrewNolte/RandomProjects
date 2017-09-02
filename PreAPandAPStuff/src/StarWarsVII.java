
public class StarWarsVII {


	public static void main(String[] args) {

		Leia(2001);
	}
	
	private static void Leia(int y){
		
		int x = y / 1000;
		
		int z = (x + y);
		
		x = Anakin(z, y);
		
		System.out.println("Leia: x = " + x + ", y = " + y + ", z = " + z);
		
	}
	
	private static int Anakin(int x, int y){
		
//		int z = Padme(x + y, y);
//		
//		y /= z;
//		
//		System.out.println()
            return 0;
	}

}
