import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;


public class Menu extends JComponent implements ActionListener {

    private JButton freeplayBTN = new JButton("freeplay");
    private JButton ccBTN = new JButton("cc simulator");
    private JButton exitBTN = new JButton("exit");

    private static BufferedImage backgroundImage;
    private static BufferedImage decksterImage;


    public Menu(){
    freeplayBTN.addActionListener(this);
    ccBTN.addActionListener(this);
    exitBTN.addActionListener(this);
    }

    public void painter(Graphics g0){
        

        Graphics2D g1 = (Graphics2D) g0;

        try{
            backgroundImage = ImageIO.read(new File("images/background.png"));
            decksterImage = ImageIO.read(new File("images/deckster.png"));
        }

        catch(IOException e){

        }

        g1.drawImage(backgroundImage, 0, 0, null);
        g1.setFont(new Font("Bell MT", Font.BOLD, 100));
        g1.setColor(Color.WHITE);
        g1.drawImage(decksterImage, 380, 100, null);


        freeplayBTN.setFont(new Font("Bell MT", Font.BOLD, 40)); 
        ccBTN.setFont(new Font("Bell MT", Font.BOLD, 40));
        exitBTN.setFont(new Font("Bell MT", Font.BOLD, 40));
        
        super.add(freeplayBTN);
        super.add(ccBTN);
        super.add(exitBTN);

    }

    public void actionPerformed(ActionEvent x){

        JButton selectedBTN = (JButton)x.getSource();

        if (selectedBTN==exitBTN){
            System.exit(0);
        }


        else if (selectedBTN==freeplayBTN){
            // Freeplay.currentState = Freeplay.STATE.GAME;
            // Freeplay.menuFrame.dispose(); 
            // Freeplay.gameRefreshThread.start(); 
            // Freeplay.gameCheckThread.start();
        }

        else if (selectedBTN==ccBTN){
            // CardCountingSimulator.currentState = CardCountingSimulator.STATE.GAME;
            // CardCountingSimulator.menuFrame.dispose(); 
            // CardCountingSimulator.gameRefreshThread.start(); 
            // CardCountingSimulator.gameCheckThread.start();
        }
    }
    
}

    

