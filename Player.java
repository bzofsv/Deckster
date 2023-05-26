import java.util.*;

public class Player {
    private DecisionTree decisions;
    Queue<Card> hand;
    String name;
    int bet;
    int chips;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
        hand = new LinkedList<>();
        this.chips = 0;
        this.bet = 0;
    }

    public Player(String name) {
        this.name = name;
        hand = new LinkedList<>();
        this.bet = 0;
        this.chips = 0;
    }

    public int makeDecision(String decision) { //returns 0 -> hit, 1 -> stand, -1 -> impossible
        DecisionTree curr = decisions;

        if(curr == null) {
            decisions = new DecisionTree(decision);
            return decision.equals("hit") ? 0 : 1;
        }

        while(curr.getLeft() != null && curr.getRight() != null) {
            if(curr.getLeft() != null) curr = curr.getLeft();
            else if(curr.getRight() != null) curr = curr.getRight();
        }

        if(decision.equals("hit")) {
            curr.setLeft(new DecisionTree("hit"));
            return 0; //made decision to hit
        } else if(decision.equals("stand")) {
            curr.setRight(new DecisionTree("stand"));
            return 1; //made decision to stand
        }

        return -1; //impossible decision
    }

    public void addCard(Card c) {
        hand.add(c);
    }

    public Queue<Card> hand() {
        return hand;
    }

    public void placeBet(int bet) {
        this.bet = bet;
        chips -= bet;
    }

    public int getBet() {
        return bet;
    }
    public int valOfCards(){
        int cardsval = 0;
        for(int i = 0; i < hand.size(); i++){
            cardsval += ((LinkedList<Card>) hand).get(i).getVal();
        }
        return cardsval;
        

    }
    public void setChips(int c){
        chips = c;
    }
    public int getChips(){
        return chips;
    }
}
