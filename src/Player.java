import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> deck;

    public Player(String name){
        this.name = name;
        deck = new ArrayList<Card>();
    }


    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void addToDeck(Card m){
        deck.add(m);
    }
}
