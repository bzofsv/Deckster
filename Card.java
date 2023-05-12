public class Card {
    private String suit;
    private int val;
    public Card(int val, String suit){
        this.val = val;
        this.suit = suit;
    }
    public String getSuit(){
        return suit;
    }
    public void getVal(){
        return val;
    }
    
}
