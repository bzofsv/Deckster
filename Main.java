import javax.swing.JFrame;

public class Main {
    public static JFrame menuFrame = new JFrame(); 
    public static JFrame ccFrame = new JFrame();
    public static JFrame freeplayFrame = new JFrame();
    public static Game newGame = new Game(freeplayFrame);


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
        menuFrame.setSize(1280, 720);
        menuFrame.setLocationRelativeTo(null); 
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setResizable(false);

        Menu startingComp = new Menu(menuFrame); 
        menuFrame.add(startingComp); 
        menuFrame.setVisible(true); 
      }

    //   public static void openFreeplay1() {
    //     while(true){
    //     newGame.creatorComp.refresh(1000, true);
    // }}
    
    public static void openFreeplay2() {
      
      freeplayFrame.getContentPane().removeAll();
      newGame = new Game(freeplayFrame); 
      newGame.formGame();
  }
      
}
