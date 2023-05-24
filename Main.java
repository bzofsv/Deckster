import javax.swing.JFrame;

public class Main {
    public static JFrame CCmenuFrame = new JFrame(); 
    public static JFrame CCgameFrame = new JFrame();


    public static enum STATE{ 
        MENU,
        CC
      };

    public static STATE CCcurrentState = STATE.MENU; 

    public static void main(String[] args) throws InterruptedException {
        if(CCcurrentState == STATE.MENU) {
          oM(); 
        }
      }

      public static void oM(){
        CCmenuFrame.setTitle("Deckster"); //we set the frame title to 'BLACKJACK!'
        CCmenuFrame.setSize(1130, 665);
        CCmenuFrame.setLocationRelativeTo(null); 
        CCmenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CCmenuFrame.setResizable(false);

        Menu startingComp = new Menu(); 
        CCmenuFrame.add(startingComp); 
        CCmenuFrame.setVisible(true); 
      }
}
