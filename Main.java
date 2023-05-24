import javax.swing.JFrame;

public class Main {
    public static JFrame menuFrame = new JFrame(); 
    public static JFrame ccFrame = new JFrame();
    public static JFrame freeplayFrame = new JFrame();


    public static enum STATE{ 
        MENU,
        FREEPLAY,
        CC
      };

    public static STATE currentState = STATE.MENU; 

    public static void main(String[] args) throws InterruptedException {
        if(currentState == STATE.MENU) {
          oM(); 
        }
      }

      public static void oM(){
        menuFrame.setTitle("Deckster"); 
        menuFrame.setSize(1130, 665);
        menuFrame.setLocationRelativeTo(null); 
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setResizable(false);

        Menu startingComp = new Menu(); 
        menuFrame.add(startingComp); 
        menuFrame.setVisible(true); 
      }

      
}
