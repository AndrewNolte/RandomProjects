
import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 52;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		//System.out.println("Results of " + SHUFFLE_COUNT + " consecutive perfect shuffles:");
            
                System.out.println("Perfect Shuffle: ");
		int[] values1 = new int[VALUE_COUNT];
		for (int i = 0; i < values1.length; i++) {
                    values1[i] = i;
                }
                values1 = perfectShuffle(values1);
                for (int i = 0; i < values1.length; i++) {
                    System.out.print(values1[i] + " ");
                }
                System.out.println();
                
                System.out.println("Selection Shuffle: ");
                int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++) {
                    values2[i] = i;
                }
                values2 = selectionShuffle(values2);
                for (int i = 0; i < values2.length; i++) {
                    System.out.print(values2[i] + " ");
                }
                System.out.println();
                
                System.out.println("Efficient Selection Shuffle: ");
                int[] values3 = new int[VALUE_COUNT];
		for (int i = 0; i < values3.length; i++) {
                    values3[i] = i;
                }
                values3 = efficientSelectionShuffle(values3);
                for (int i = 0; i < values3.length; i++) {
                    System.out.print(values3[i] + " ");
                }

                /*
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
                    perfectShuffle(values1);
                    System.out.print("  " + j + ":");
                    for (int k = 0; k < values1.length; k++) {
                            System.out.print(" " + values1[k]);
                    }
                    System.out.println();
		}
		System.out.println();
                 *
                 */
                /*
		System.out.println("Results of " + SHUFFLE_COUNT + " consecutive efficient selection shuffles:");

		int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++) {
                    values2[i] = i;
		}

                System.out.println(selectionShuffle(values2));
                /*
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
                    selectionShuffle(values2);
                    System.out.print("  " + j + ":");
                    for (int k = 0; k < values2.length; k++) {
                            System.out.print(" " + values2[k]);
                    }
                    System.out.println();
		}
		System.out.println();
                 *
                 */
                 

	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] perfectShuffle(int[] values) {
            int[] complete = new int[values.length];
            for(int i = 0; i < values.length; i++){
                if(i % 2 == 0){
                    if(i+1 >= values.length){
                        complete[i] = values[i];
                    }else{
                        complete[i] = values[i+1];
                    }
                }else{
                    complete[i] = values[i-1];
                }
            }
            return complete;
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] selectionShuffle(int[] values) {

            Random r = new Random();
            int[] complete = new int[values.length];
            boolean[] taken = new boolean[values.length];
            for(int k = 0; k < taken.length; k++){
                taken[k] = false;
            }

            for(int i = 0; i < values.length; i++){

                int rn = r.nextInt(values.length-i);//0-51, 0-50
                int index = 0;
                for(int j = 0; j <= rn;){
                    if(taken[index] == false){
                        j++;
                    }
                    index++;
                }
                complete[i] = values[index-1];
                taken[index-1] = true;

            }
            return complete;
	}

        public static int[] efficientSelectionShuffle(int[] values) {
            Random rn = new Random();
            for(int i = values.length-1; i >= 0; i--){
                int r = rn.nextInt(i+1);

                int fdata = values[r];
                int sdata = values[i];

                values[r] = sdata;
                values[i] = fdata;
            }
            return values;
        }

}