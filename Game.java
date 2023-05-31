import javax.swing.*;
import java.util.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.*;


public class Game {
    public boolean faceDown;
    private static Deck deck;
    private static int pool;
    private static Player dealer;
    private static Player user;
    public boolean over; 
    JFrame mainFrame;
    
    FreeplayGUI creatorComp;
    FreeplayGUI cardComp;

    JButton btnHit; 
    JButton btnStand;
    JButton btnExit;

    public Game(JFrame frame1) {
        mainFrame = frame1;
        deck = new Deck();
        deck.shuffle(); //we randomize the deck.
        user = new Player("player1");
        dealer = new Player("dealer1");
        faceDown = true;
        over = false;
      }

    // public static void main(String[] args) {

    //     CardCountingSimulator lol = new CardCountingSimulator(dealer, user, 0, d);
    //     System.out.println(lol.hit());
    //     System.out.println(lol.getRunning());
    //     System.out.println(lol.getTrue());
    //     System.out.println("uwuwuwuwuwuwuwuwuwuwuwuwuwuwuwuwuwuwu");
    //     System.out.println(lol.hit());
    //     System.out.println(lol.getRunning());
    //     System.out.println(lol.getTrue());
    //     System.out.println("uaisdgjhadkjfghkajldfhgjkladhgkjadfjkghadkghjkadfhgkljsdhjkfg");
    //     System.out.println(lol.stand());
    //     System.out.println(lol.getRunning());
    //     System.out.println(lol.getTrue());
    // }

    public void formGame() {
        mainFrame.setTitle("Deckster - Freeplay"); 
        mainFrame.setSize(1280, 720);
        mainFrame.setLocationRelativeTo(null); 
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false); 
    
        btnHit = new JButton("Hit"); 
        btnHit.setBounds(1000, 540, 150, 50); 
        btnHit.setFont(new Font("Tahoma", Font.BOLD, 16));  
        btnStand = new JButton("Stand");
        btnStand.setBounds(1000, 620, 150, 50);
        btnStand.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnExit = new JButton("Exit");
        btnExit.setBounds(75, 5, 100, 50);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
    
        mainFrame.add(btnHit); 
        mainFrame.add(btnStand);
        mainFrame.add(btnExit);


        btnExit.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
              System.exit(0); 
            }
          }
          );


        creatorComp = new FreeplayGUI(dealer, user);
        creatorComp.setBounds(0, 0, 1280, 720);  
        mainFrame.add(creatorComp); 
        mainFrame.setVisible(true); 
}

public void startGame() { 

    Freeplay loader = new Freeplay(dealer, user, pool, deck);

    // dealer = loader.dealer;
    // user = loader.p;
    // pool = loader.pool;
    // deck = loader.d;

    cardComp = new FreeplayGUI(loader.getDealer(), loader.getPlayer());
    loader.setPool(cardComp.getBet());
    cardComp.setBounds(0, 0, 1280, 720); 
    mainFrame.add(cardComp); 
    mainFrame.setVisible(true); 


    btnHit.addActionListener(new ActionListener() { //we add a action listener to the hit button. When the user clicks this button,
      public void actionPerformed(ActionEvent e) {
        loader.hit();
      }
    });




}

}