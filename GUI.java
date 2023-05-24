import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import sun.audio.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class GUI extends JComponent implements MouseListener {

    public BufferedImage backgroundImage;
    public BufferedImage logo;
    public BufferedImage chip;
    private int balance;





    public void paintComponent(Graphics g0) {
        Graphics2D g1 = (Graphics2D) g0; //we first cast Graphics g to Graphics2D g2 in order to use a more powerful brush.
    
        try {
          backgroundImage = ImageIO.read(new File("images/background.png")); //we read a file which is the png image of a poker table for our background image.
          logo = ImageIO.read(new File("images/deckster_real.png")); //we read a file which is the png image of a blackjack logo for the logo on the poker table.
          chip = ImageIO.read(new File("images/chip.png")); //we read a file which is the png image of a poker chip for the chip on the poker table.
        }
        catch(IOException e) {}

        g1.drawImage(backgroundImage, 0, 0, null);
        g1.drawImage(logo, 510,200, null);
        g1.drawImage(chip, 50, 300, null);
        g1.setColor(Color.WHITE);
        g1.setFont(new Font("Tacoma", Font.ROMAN_BASELINE, 20));
        g1.drawString("Dealer", 515, 50); 
        g1.drawString("Player", 515, 380);
        g1.drawString("USD Balance: " + balance, 50, 570); 



    
}}
