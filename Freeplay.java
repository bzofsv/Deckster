public class Freeplay {
    private int pool;
    private Player p;
    private Player dealer;
    private Deck d;
    private int bet;
    
    public Freeplay(Player dealer, Player p, int pool, Deck d){
        this.dealer = dealer;
        this.p = p;
        this.pool =pool;
        this.d = d;
        d.shuffle();
        p.addCard(d.draw());
        p.addCard(d.draw());
        dealer.addCard(d.draw());
        dealer.addCard(d.draw());
    }
    public int hit(){ //return of -1 -> dealer, 0 -> nothing, 1 -> player for who won

        int initial = p.valOfCards();
        System.out.println(initial);
        p.addCard(d.draw());
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

        // int dealerInitial = 0;
        // int dealerVal = 0;

        // if(dealer.valOfCards()<=16){
        //     dealerInitial = dealer.valOfCards();
        //     dealer.addCard(d.draw());
        //     dealer.makeDecision("hit");
        //     System.out.println("dealer hit");
        //     dealerVal = dealer.valOfCards();

        //     if(dealerVal - dealerInitial == 11 && dealerVal > 21) dealerVal -= 10;
        //     System.out.println(val);

        // } else {
        //     dealer.makeDecision("stand");
        //     System.out.println("dealer stand");
        //     dealerVal = dealer.valOfCards();
        //     System.out.println(dealerVal);
        // }

        // if(val > 21){
        //     p.setChips(p.getChips()+pool);
        //     pool = 0;
        //     while(p.hand().peek() != null){
        //         d.add(p.hand().remove());
        //     }
        //     while(dealer.hand().peek() != null){
        //         d.add(dealer.hand().remove());
        //     }

        //     return 1;
            
        // }

       // if(dealerVal == val && val == 21) return 0;
        else if(val == 21) return 1;
        //else if(dealerVal == 21) return -1;

        return 0;

    }

    public int stand(){ //returns -1 -> dealer wins, 0 -> tie, 1 -> player wins
        p.makeDecision("stand");
        int dealerVal = 0;
        int dealerInitial = 0;
        System.out.println(p.valOfCards());
        while(dealer.valOfCards() <= 16) {
            dealerInitial = dealer.valOfCards();
            System.out.println("dealer cards: " + dealerInitial);
            dealer.addCard(d.draw());
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

    public Player getDealer(){
        return dealer;
    }

    public Player getPlayer(){
        return p;
    }

    public Deck getDeck(){
        return d;
    }

    public int getPool(){
        return pool;
    }

    public void setPool(int p){
        pool = p;
    }

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
