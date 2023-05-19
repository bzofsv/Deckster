public class Freeplay {
    private int pool;
    private Player p;
    private Deck d;
    private int bet;
    private Player dealer;
    public Freeplay(Player dealer, Player p, int pool, Deck d){
        this.dealer = dealer;
        this.p = p;
        this.pool =pool;
        this.d = d;
        d.shuffle();
    }
    public void hit(){
        p.addCard(d.draw());
        p.placeBet(bet);
        pool += (2*bet);
        p.makeDecision("hit");
        if(p.valOfCards()>21){
            pool = 0;
            while(p.hand.peek() != null){
                d.add(p.hand.remove());
            }
        }
        if(dealer.valOfCards()<=16){
            dealer.addCard(d.draw());
            dealer.makeDecision("hit");
        }

        else dealer.makeDecision("stand");
        if(dealer.valOfCards()>21){
            p.setChips(p.getChips()+pool);
            pool = 0;
            while(p.hand.peek() != null){
                d.add(p.hand.remove());
            }
            while(dealer.hand.peek() != null){
                d.add(dealer.hand.remove());
            }
            
        }
    }
    public void stand(){
        p.makeDecision("stand");
        if(dealer.valOfCards()<=16){
            dealer.addCard(d.draw());
            dealer.makeDecision("hit");
        }
        else dealer.makeDecision("stand");

        if(dealer.valOfCards()>21 ||
        p.valOfCards()> dealer.valOfCards()){
            p.setChips(p.getChips()+pool);
            pool = 0;
            while(p.hand.peek() != null){
                d.add(p.hand.remove());
            }
            while(dealer.hand.peek() != null){
                d.add(dealer.hand.remove());
            }
            
        }

        else if(dealer.valOfCards()>p.valOfCards()){
            pool = 0;
            while(p.hand.peek()!= null){
                d.add(p.hand.remove());
            }
            while(dealer.hand.peek()!= null){
                d.add(dealer.hand.remove());
            }
        }
        else{
            while(p.hand.peek()!= null){
                d.add(p.hand.remove());
            }
            while(dealer.hand.peek()!= null){
                d.add(dealer.hand.remove());
            }
        }
    }

}
