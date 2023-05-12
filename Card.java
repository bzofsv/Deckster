public class Card {
    private String suit;
    private int val;
    private int rank;
    public Card(int val, String suit, int rank){
        this.val = val;
        this.suit = suit;
        this.rank = rank;
    }
    public String getSuit(){
        return suit;
    }
    public int getVal(){
        return val;
    }
    public int getRank(){
        return rank;
    }
    
    public void setVal(int v) {
        val = v;
    }
}
