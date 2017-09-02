
public class CrapsCalculator {

static int[] totals = new int[12];
	
	public static void main(String[] args) {
		
		for(int i = 1; i < 7; i++){
			for(int j = 1; j < 7; j++){
				int tots = i + j;
				totals[tots-1]++;
			}
		}
		for(int i = 0; i < 12; i++){
			System.out.println(totals[i]);
		}


	}

}
