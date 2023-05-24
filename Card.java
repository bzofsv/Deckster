import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D; 
 

public class Card {
    private int suit;
    private int val;
    private int rank;

    private int xPos;
    private int yPos;


    
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

    public void cardPrinter(Graphics2D g1, boolean dealerTurn, boolean faceDown, int cardNum) throws IOException{
        BufferedImage cardDeck = ImageIO.read(new File("images/cardSpriteSheet.png")); 

        int deckWidth = 950; 
        int deckHeight = 392;

        BufferedImage[][] cardImages = new BufferedImage[4][13];
        BufferedImage backCard = ImageIO.read(new File("images/backCard.jpg")); 

        for (int c = 0; c < 4; c++) { 
            for (int r = 0; r < 13; r++) {
              cardImages[c][r] = cardDeck.getSubimage(r*deckWidth/13, c*deckHeight/4, deckWidth/13, deckHeight/4); 
          }
        }

        if (dealerTurn) {
            yPos = 75;
        }
        else{
            yPos = 400;
        }
    
        xPos = 500 + 75*cardNum; 
    
        if (faceDown) { 
            g1.drawImage(backCard, xPos, yPos, null ); 
        }

        else {
            g1.drawImage(cardImages[suit][rank], xPos, yPos, null); 
        }

    }
}
