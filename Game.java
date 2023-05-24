public class Game {
    private static Deck d;
    private static int pool;
    private static Player dealer;
    private static Player user;

    public Game() {}

    public static void main(String[] args) {
        dealer = new Player("poggie woggies");
        user = new Player("test");
        d = new Deck();
        Freeplay lol = new Freeplay(dealer, user, 0, d);
        System.out.println(lol.stand());
    }
}