public class CardCountingSimulator {
    private int pool;
    private Player p;
    private Deck d;
    private int bet;
    private Player dealer;
    public CardCountingSimulator (Player dealer, Player p, int pool, Deck d){
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
        System.out.println(p.valOfCards());
        p.addCard(d.draw());
        p.placeBet(bet);
        pool += (2 * bet);
        p.makeDecision("hit");
        System.out.println("hit");
        System.out.println(p.valOfCards());
        if(p.valOfCards() > 21){
            pool = 0;
            while(p.hand.peek() != null){
                d.add(p.hand.remove());
            }

            return -1;
        }

        if(dealer.valOfCards()<=16){
            dealer.addCard(d.draw());
            dealer.makeDecision("hit");
            System.out.println("dealer hit");
            System.out.println(dealer.valOfCards());
        } else {
            dealer.makeDecision("stand");
            System.out.println("dealer stand");
            System.out.println(dealer.valOfCards());
        }

        if(dealer.valOfCards()>21){
            p.setChips(p.getChips()+pool);
            pool = 0;
            while(p.hand.peek() != null){
                d.add(p.hand.remove());
            }
            while(dealer.hand.peek() != null){
                d.add(dealer.hand.remove());
            }

            return 1;
            
        }

        if(p.valOfCards() == dealer.valOfCards()) {
            return 0;
        } else return p.valOfCards() > dealer.valOfCards() ? 1 : -1;

    }

    public int stand(){ //returns -1 -> dealer wins, 0 -> tie, 1 -> player wins
        p.makeDecision("stand");
        System.out.println(p.valOfCards());
        if(dealer.valOfCards()<=16){
            System.out.println("dealer cards: " + dealer.valOfCards());
            dealer.addCard(d.draw());
            dealer.makeDecision("hit");
            System.out.println("dealer hit");
            System.out.println(dealer.valOfCards());
        }
        else {
            dealer.makeDecision("stand");
            System.out.println(dealer.valOfCards());
            System.out.println("dealer stand");
            System.out.println(dealer.valOfCards());
        }

        if(dealer.valOfCards() > 21 ||
        p.valOfCards()> dealer.valOfCards()){
            p.setChips(p.getChips()+pool);
            pool = 0;
            while(p.hand.peek() != null){
                d.add(p.hand.remove());
            }
            while(dealer.hand.peek() != null){
                d.add(dealer.hand.remove());
            }

            return 1;
            
        }

        else if(dealer.valOfCards()>p.valOfCards()){
            pool = 0;
            while(p.hand.peek()!= null){
                d.add(p.hand.remove());
            }
            while(dealer.hand.peek()!= null){
                d.add(dealer.hand.remove());
            }
            return -1;
        }
        else{
            while(p.hand.peek()!= null){
                d.add(p.hand.remove());
            }
            while(dealer.hand.peek()!= null){
                d.add(dealer.hand.remove());
            }

            return 0;
        }
    }

}
