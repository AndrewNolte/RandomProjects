/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {

            String[] ranks = new String[52];
            String[] suits = new String[52];
            int[] values = new int[52];

            for(int i = 0; i < 52; i++){
                int r = i%13 + 1;
                ranks[i] = String.valueOf(r);
                if(r == 11){
                    ranks[i] = "Jack";
                }else if(r == 12){
                    ranks[i] = "Queen";
                }else if(r == 13){
                    ranks[i] = "King";
                }

                int s = i/13;
                if(s == 0){
                    suits[i] = "Spades";
                }else if(s == 1){
                    suits[i] = "Clubs";
                }else if(s == 2){
                    suits[i] = "Hearts";
                }else if(s == 3){
                    suits[i] = "Diamonds";
                }

                values[i] = r;

            }

            Deck deck = new Deck(ranks, suits, values);

            System.out.println(deck.toString());
            System.out.println(deck.isEmpty());
            System.out.println(deck.size());

            System.out.println();

            deck.deal();

            System.out.println(deck.toString());
            System.out.println(deck.isEmpty());
            System.out.println(deck.size());

            System.out.println();

            int lmao = deck.size();
            for(int k = 0; k < lmao; k++){
                deck.deal();
            }

            System.out.println(deck.toString());
            System.out.println(deck.isEmpty());
            System.out.println(deck.size());

            deck.deal();




	}
}