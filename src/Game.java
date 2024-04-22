import java.util.ArrayList;

public class Game {

    private Screen screen;

    private ArrayList<Card> charPool = new ArrayList<Card>();

    private Player boss1;

    public Game() {
        charPool.add(new Card("1",100,1,""));
        charPool.add(new Card("2",100,2,""));
        charPool.add(new Card("3",100,3,""));
        charPool.add(new Card("4",100,4,""));
        charPool.add(new Card("5",100,5,""));
        charPool.add(new Card("6",100,6,""));
        charPool.add(new Card("7",100,7,""));
        charPool.add(new Card("8",100,8,""));
        charPool.add(new Card("9",100,9,""));
        charPool.add(new Card("10",100,10,""));


    }




}
