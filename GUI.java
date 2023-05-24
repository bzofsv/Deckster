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





    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //we first cast Graphics g to Graphics2D g2 in order to use a more powerful brush.
    
        try {
          backgroundImage = ImageIO.read(new File("images/background.png")); //we read a file which is the png image of a poker table for our background image.
          logo = ImageIO.read(new File("images/deckster_real.png")); //we read a file which is the png image of a blackjack logo for the logo on the poker table.
          chip = ImageIO.read(new File("images/chip.png")); //we read a file which is the png image of a poker chip for the chip on the poker table.
        }
        catch(IOException e) {}
    
}
