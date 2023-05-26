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
        CardCountingSimulator lol = new CardCountingSimulator(dealer, user, 0, d);
        System.out.println(lol.hit());
        System.out.println(lol.getRunning());
        System.out.println(lol.getTrue());
        System.out.println("uwuwuwuwuwuwuwuwuwuwuwuwuwuwuwuwuwuwu");
        System.out.println(lol.hit());
        System.out.println(lol.getRunning());
        System.out.println(lol.getTrue());
        System.out.println("uaisdgjhadkjfghkajldfhgjkladhgkjadfjkghadkghjkadfhgkljsdhjkfg");
        System.out.println(lol.stand());
        System.out.println(lol.getRunning());
        System.out.println(lol.getTrue());
    }
}