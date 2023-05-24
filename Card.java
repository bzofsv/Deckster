import java.awt.Graphics2D; 

public class Card {
    private int suit;
    private int val;
    private int rank;
    public Card(int val, int suit, int rank){
        this.val = val;
        this.suit = suit;
        this.rank = rank;
    }
    public int getSuit(){
        return suit;
    }
    public int getVal(){
        return val;
    }
    public int getRank(){
        return rank;
    }
    
    public void setSuit(int s) {
        suit = s;
    }

    public void setVal(int v) {
        val = v;
    }

    public void setRank(int r) {
        rank = r;
    }
}
