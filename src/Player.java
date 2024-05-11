//Benjamin Chock
import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> deck;

    private int cardsLeft;

    public Player(String name){
        this.name = name;
        deck = new ArrayList<Card>();
        cardsLeft = 3;
    }

    //reset all cards in the players deck
    public void deckReset(){
        for (int i = 0; i < deck.size(); i++){
            deck.get(i).reset();
        }
    }

    public void setCardsLeft(int cardsLeft) {
        this.cardsLeft = cardsLeft;
    }

    public int getCardsLeft(){
        return cardsLeft;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    //ad card to deck
    public void addToDeck(Card m){
        deck.add(m);
    }
}
