public class CardCountingSimulator {
    private int pool;
    private Player p;
    private Deck d;
    private int bet;
    private Player dealer;
    private int runningCount;
    private double trueCount;

    private static final int[] KEY = {-1, 1, 1, 1, 1, 1, 0, 0, 0, -1, -1, -1, -1};

    public CardCountingSimulator (Player dealer, Player p, int pool, Deck d){
        this.dealer = dealer;
        this.p = p;
        this.pool = pool;
        this.d = d;
        d.shuffle();

        for(int i = 0; i < 2; i++) {
            Card c = d.draw();
            runningCount += countChecker(c);
            p.setRunningCount(runningCount);
            trueCount = ((double) runningCount) / (((double) d.cardsLeft()) / 52.0);
            p.setTrueCount(trueCount);
            p.addCard(c);
        }

        for(int i = 0; i < 2; i++) {
            Card c = d.draw();
            runningCount += countChecker(c);
            p.setRunningCount(runningCount);
            trueCount = ((double) runningCount) / (((double) d.cardsLeft()) / 52.0);
            p.setTrueCount(trueCount);
            dealer.addCard(c);
        }
    }

    public int countChecker(Card c) {
        return KEY[c.getRank() - 1];
    }

    public int getRunning() {
        return runningCount;
    }

    public double getTrue() {
        return trueCount;
    }

    private Card drawCard() {
        Card c = d.draw();
        runningCount += countChecker(c);
        p.setRunningCount(runningCount);
        trueCount = ((double) runningCount) / (((double) d.cardsLeft()) / 52.0);
        p.setTrueCount(trueCount);
        System.out.println("THis is true count: " + trueCount + " this is running: " + runningCount);
        return c;
    }

    /**
     * "hit" command for blackjack
     * @return an int to determine who won -1 -> dealer, 0 -> nothing, 1 -> player for who won
     */
    public int hit(){

        int initial = p.valOfCards();
        System.out.println(initial);
        p.addCard(drawCard());
        p.placeBet(bet);
        pool += (2 * bet);

        int val = p.valOfCards();

        p.makeDecision("hit");
        System.out.println("hit");
        if(val - initial == 11 && val > 21) val -= 10;
        System.out.println(val);

        if(val > 21){
            pool = 0;
            while(p.hand().peek() != null){
                d.add(p.hand().remove());
            }

            return -1;
        }

        else if(val == 21) return 1;

        return 0;

    }

    /**
     * "stand" command for blackjack
     * @return an int to determine who wins -1 -> dealer wins, 0 -> tie, 1 -> player wins
     */
    public int stand(){
        p.makeDecision("stand");
        int dealerVal = 0;
        int dealerInitial = 0;
        System.out.println(p.valOfCards());
        while(dealer.valOfCards() <= 16) {
            dealerInitial = dealer.valOfCards();
            System.out.println("dealer cards: " + dealerInitial);
            dealer.addCard(drawCard());
            dealer.makeDecision("hit");
            System.out.println("dealer hit");

            dealerVal = dealer.valOfCards();

            if(dealerVal - dealerInitial == 11 && dealerVal > 21) dealerVal -= 10;
            System.out.println(dealerVal);
        }
        
        dealerVal = dealer.valOfCards();
        dealer.makeDecision("stand");
        System.out.println(dealerVal);
        System.out.println("dealer stand");
        System.out.println(dealerVal);

        if(dealerVal > 21 ||
        p.valOfCards() > dealerVal){
            p.setChips(p.getChips() + 2 * pool);
            pool = 0;
            while(p.hand().peek() != null){
                d.add(p.hand().remove());
            }
            while(dealer.hand().peek() != null){
                d.add(dealer.hand().remove());
            }

            return 1;
            
        }

        else if(dealerVal > p.valOfCards()){
            pool = 0;
            while(p.hand().peek()!= null){
                d.add(p.hand().remove());
            }
            while(dealer.hand().peek()!= null){
                d.add(dealer.hand().remove());
            }
            return -1;
        } else {
            while(p.hand().peek()!= null){
                d.add(p.hand().remove());
            }
            while(dealer.hand().peek()!= null){
                d.add(dealer.hand().remove());
            }

            return 0;
        }
    }

        /**
     * getter for dealer
     * @return dealer
     */
    public Player getDealer(){
        return dealer;
    }

    /**
     * getter for player
     * @return player
     */
    public Player getPlayer(){
        return p;
    }

    /**
     * getter for the deck 
     * @return deck
     */
    public Deck getDeck(){
        return d;
    }

    /**
     * getter for the pool
     * @return current pool
     */
    public int getPool(){
        return pool;
    }

    /**
     * sets the pool
     * @param p new pool
     */
    public void setPool(int p){
        pool = p;
    }

    /**
     * clears the hand of a player/dealer
     * @param 0 -> clears player hand, 1 -> clears dealer hand
     */
    public void clearHand(int playerNum) { 
        if(playerNum == 0) {
            while(p.hand().peek()!= null){
                d.add(p.hand().remove());
            }
        }
        else if(playerNum == 1) {
            while(dealer.hand().peek()!= null){
                d.add(dealer.hand().remove());
            }
        }
    }
}
