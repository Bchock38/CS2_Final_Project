import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game implements KeyListener {

    private Screen screen;

    private ArrayList<Card> charPool;

    private Player boss1;

    private Player player;

    private int currentCard;

    private Card boss1CurCard;

    private int boss1CurCardNum;

    public Game(){
        currentCard = 0;
        boss1CurCardNum = 0;
        player = new Player("");
        boss1 = new Player("");
        charPool = new ArrayList<Card>();
        Image image1 = new ImageIcon("Resources/_草.png").getImage();
        Image image2 = new ImageIcon("Resources/水.png").getImage();
        Image image3 = new ImageIcon("Resources/火.png").getImage();
        Image image4 = new ImageIcon("Resources/熊猫.png").getImage();
        Image image5 = new ImageIcon("Resources/花.png").getImage();
        Image image6;
        Image image7;
        Image image8;
        Image image9;
        Image image10;
        screen = new Screen(this,"Instructions");
        charPool.add(new Card("草",100,1,"", screen, image1));
        charPool.add(new Card("水",150,2,"", screen, image2));
        charPool.add(new Card("火",125,3,"", screen, image3));
        charPool.add(new Card("熊喵",250,4,"", screen,image4));
        charPool.add(new Card("花",80,5,"", screen,image5));
//        charPool.add(new Card("6",100,6,"", screen,image6));
//        charPool.add(new Card("7",100,7,"", screen,image7));
//        charPool.add(new Card("8",100,8,"", screen,image8));
//        charPool.add(new Card("9",100,9,"", screen,image9));
//        charPool.add(new Card("10",100,10,"", screen,image10));
        screen.addKeyListener(this);
        makeCard1(charPool.get(0));
        makeCard2(charPool.get(1));
        makeCard3(charPool.get(2));
        makeCard4(charPool.get(3));
        makeCard5(charPool.get(4));
    }

    public void makeCard1(Card a){
        a.setMove1("Razor Leaf",60, 0,"Grass",0);
        a.setMove2("Giga Drain",40, 20, "Grass",0);
        a.setType("Grass");
    }

    public void makeCard2(Card a){
        a.setMove1("Water Gun",60, 0,"Water",0);
        a.setMove2("Aqua Tail",40,0 ,"Water",30);
        a.setType("Water");
    }

    public void makeCard3(Card a){
        a.setMove1("Flamethrower",70, 0,"Fire",0);
        a.setMove2("Nova Punch",50,0 ,"Normal",0);
        a.setType("Fire");
    }

    public void makeCard4(Card a){
        a.setMove1("Body Slam",40, 0,"Normal",0);
        a.setMove2("Recover",10,50 ,"Normal",0);
        a.setType("Normal");
    }

    public void makeCard5(Card a){
        a.setMove1("Hydro Pump",75, 0,"Water",0);
        a.setMove2("Solar Beam",90,0 ,"Grass",0);
        a.setType("WATERGRASS");
    }

    public void keyTyped(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_1:
                if (screen.getState1().equals("Battle")){
                    boss1CurCard.setHealth(screen.getCurCard().doMove1(boss1CurCard.getType()));
                    if (!checkDeckState(boss1)){
                        screen.setState("Win");
                    }
                    else if (!checkDeckState(player)){
                        screen.setState("Lost");
                    }
                    else if (!screen.getCurCard().getLivingStatus()){
                        screen.setCurCard(player.getDeck().get(++currentCard));
                    }
                    else if (!boss1CurCard.getLivingStatus()){
                        boss1CurCard = boss1.getDeck().get(++boss1CurCardNum);
                        boss1.setCardsLeft(boss1.getCardsLeft()-1);
                    }
                    screen.repaint();
                    if (randBossMover() == 1){
                        screen.getCurCard().setHealth(boss1CurCard.doMove1(screen.getCurCard().getType()));
                    }
                    else{
                        screen.getCurCard().setHealth(boss1CurCard.doMove2(screen.getCurCard().getType()));
                    }
                    screen.repaint();
                    if (!checkDeckState(boss1)){
                        screen.setState("Win");
                    }
                    else if (!checkDeckState(player)){
                        screen.setState("Lost");
                    }
                    else if (!screen.getCurCard().getLivingStatus()){
                        screen.setCurCard(player.getDeck().get(++currentCard));
                    }
                    else if (!boss1CurCard.getLivingStatus()){
                        boss1CurCard = boss1.getDeck().get(++boss1CurCardNum);
                        boss1.setCardsLeft(boss1.getCardsLeft()-1);
                    }
                    screen.repaint();
                }
                break;

            case KeyEvent.VK_2:
                if (screen.getState1().equals("Battle")){
                    boss1CurCard.setHealth(screen.getCurCard().doMove2(boss1CurCard.getType()));
                    if (!checkDeckState(boss1)){
                        screen.setState("Win");
                    }
                    else if (!checkDeckState(player)){
                        screen.setState("Lost");
                    }

                    else if (!screen.getCurCard().getLivingStatus()){
                        screen.setCurCard(player.getDeck().get(++currentCard));
                    }
                    else if (!boss1CurCard.getLivingStatus()){
                        boss1CurCard = boss1.getDeck().get(++boss1CurCardNum);
                        boss1.setCardsLeft(boss1.getCardsLeft()-1);
                    }
                    screen.repaint();
                    if (randBossMover() == 1){
                        screen.getCurCard().setHealth(boss1CurCard.doMove1(screen.getCurCard().getType()));
                    }
                    else{
                        screen.getCurCard().setHealth(boss1CurCard.doMove2(screen.getCurCard().getType()));
                    }
                    screen.repaint();
                    if (!checkDeckState(boss1)){
                        screen.setState("Win");
                    }
                    else if (!checkDeckState(player)){
                        screen.setState("Lost");
                    }
                    else if (!screen.getCurCard().getLivingStatus()){
                        screen.setCurCard(player.getDeck().get(++currentCard));
                    }
                    else if (!boss1CurCard.getLivingStatus()){
                        boss1CurCard = boss1.getDeck().get(++boss1CurCardNum);
                        boss1.setCardsLeft(boss1.getCardsLeft()-1);
                    }
                    screen.repaint();

                }
                break;

            case KeyEvent.VK_SPACE:
                if (screen.getState1().equals("Intro")){
                    getCards();
                }
                else if (screen.getState1().equals("Drawed")){
                    screen.setState("Battle");
                    battle();
                    screen.repaint();

                }
                break;

            case KeyEvent.VK_D:
                if (screen.getState1().equals("Draw")){
                    screen.setState("Drawed");
                    screen.repaint();
                }
                break;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // The keyCode lets you know which key was pressed

    }

    public int randBossMover(){
        return (int)(Math.random()*2) + 1;
    }

    public void startup(){
        int selector = (int)(Math.random()*5);
        boss1.addToDeck(new Card (charPool.get(selector)));
        boss1CurCard = boss1.getDeck().get(0);
        if (selector == 0){
            makeCard1(boss1CurCard);
        }
        else if (selector == 1){
            makeCard2(boss1CurCard);
        }
        else if (selector == 2){
            makeCard3(boss1CurCard);
        }
        else if (selector == 3){
            makeCard4(boss1CurCard);
        }
        else {
            makeCard5(boss1CurCard);
        }
        selector = (int)(Math.random()*5);
        boss1.addToDeck(new Card (charPool.get(selector)));
        if (selector == 0){
            makeCard1(boss1.getDeck().get(1));
        }
        else if (selector == 1){
            makeCard2(boss1.getDeck().get(1));
        }
        else if (selector == 2){
            makeCard3(boss1.getDeck().get(1));
        }
        else if (selector == 3){
            makeCard4(boss1.getDeck().get(1));
        }
        else {
            makeCard5(boss1.getDeck().get(1));
        }
        selector = (int)(Math.random()*5);
        boss1.addToDeck(new Card (charPool.get(selector)));
        if (selector == 0){
            makeCard1(boss1.getDeck().get(2));
        }
        else if (selector == 1){
            makeCard2(boss1.getDeck().get(2));
        }
        else if (selector == 2){
            makeCard3(boss1.getDeck().get(2));
        }
        else if (selector == 3){
            makeCard4(boss1.getDeck().get(2));
        }
        else {
            makeCard5(boss1.getDeck().get(2));
        }

//
        screen.setState("Intro");
    }

    public void getCards(){
        int selector = (int)(Math.random()*5);
        player.addToDeck(charPool.get(selector));
        charPool.remove(selector);
        selector = (int)(Math.random()*4);
        player.addToDeck(charPool.get(selector));
        charPool.remove(selector);
        selector = (int)(Math.random()*3);
        player.addToDeck(charPool.get(selector));
        screen.setState("Draw");
        screen.repaint();
    }

    public boolean checkDeckState(Player toCheck){
        for (int i = 0; i < toCheck.getDeck().size(); i++){
            if (toCheck.getDeck().get(i).getLivingStatus()){
                return true;
            }
        }
        return false;
    }

    public Card getBoss1CurCard(){
        return boss1CurCard;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getBoss1(){
        return boss1;
    }

    public void battle(){
        screen.setCurCard(player.getDeck().get(currentCard));
        screen.setState("Battle");


    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startup();
    }





}
