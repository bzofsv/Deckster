import java.util.*;

public class Deck {
    LinkedList<Card> deck;

    public Deck() {
        for(int i = 0; i < 6; i++) {
            LinkedList<Card> temp = createDeck();
            for(Card c : temp) {
                deck.add(c);
            }
        }
    }

    private LinkedList<Card> createDeck() {
        LinkedList<Card> temp = new LinkedList<>();

        for(int i = 0; i < 4; i++) {
            for(int j = 1; j <= 13; j++) {

                int suit = 0;
                int val = -1;
                int rank = j;
                if(i == 0) suit = 3;
                else if(i == 1) suit = 0;
                else if(i == 2) suit = 1;
                else if(i == 3) suit = 2;

                if(j > 11 || j == 1) val = 11;
                else val = j;

                temp.add(new Card(val, suit, rank));
            }
        }

        return temp;
    }

    public void shuffle() {
        LinkedList<Card> temp = new LinkedList<>();

        for(int i = 312; i >= 1; i--) {
            int ind = (int) (Math.random() * i + 1);
            temp.add(deck.remove(ind));
        }

        deck = temp;
    }

    public Card draw() {
        return deck.remove();
    }

    public void add(Card c) {
        deck.add(c);
    }
}
