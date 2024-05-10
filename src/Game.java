import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game implements KeyListener {

    private Screen screen;

    private ArrayList<Card> charPool;

    private Player boss1;

    private Player boss2;

    private Player player;

    private int currentCard;

    private Card boss1CurCard;

    private Card boss2CurCard;

    private int boss1CurCardNum;

    private int boss2CurCardNum;

    public Game(){
        currentCard = 0;
        boss1CurCardNum = 0;
        boss2CurCardNum = 0;
        player = new Player("");
        boss1 = new Player("");
        boss2 = new Player("");
        charPool = new ArrayList<Card>();
        Image image1 = new ImageIcon("Resources/_草.png").getImage();
        Image image2 = new ImageIcon("Resources/水.png").getImage();
        Image image3 = new ImageIcon("Resources/火.png").getImage();
        Image image4 = new ImageIcon("Resources/熊猫.png").getImage();
        Image image5 = new ImageIcon("Resources/花.png").getImage();
        Image image6 = new ImageIcon("Resources/电.png").getImage();;
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
        charPool.add(new Card("电",300,6,"", screen,image6));
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
        makeCard6(charPool.get(5));
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

    public void makeCard6(Card a){
        a.setMove1("Thunderstorm",75, 0,"Normal",25);
        a.setMove2("Lightning Breath",100,0 ,"Normal",0);
        a.setType("Normal");
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
                    attackBoss(boss1CurCard,1);
                    if (!checkBoss1State(boss1)){
                        screen.repaint();
                        break;
                    }
                    attackPlayer(boss1CurCard);
                    if (!checkPlayerState()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                }
                else if (screen.getState1().equals("FinalBossBattle")) {
                    screen.repaint();
                    attackBoss(boss2CurCard,1);
                    if (!checkBoss2State()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                    attackPlayer(boss2CurCard);
                    if (!checkPlayerState()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                }

                break;

            case KeyEvent.VK_2:
                if (screen.getState1().equals("Battle")) {
                    attackBoss(boss1CurCard,2);
                    if (!checkBoss1State(boss1)){
                        screen.repaint();
                        break;
                    }
                    attackPlayer(boss1CurCard);
                    if (!checkPlayerState()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                }
                else if (screen.getState1().equals("FinalBossBattle")){
                    attackBoss(boss2CurCard,2);
                    if (!checkBoss2State()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                    attackPlayer(boss2CurCard);
                    if (!checkPlayerState()){
                        screen.repaint();
                        break;
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
                else if (screen.getState1().equals("FinalBoss")){
                    screen.setState("FinalBossBattle");
                    finalbattle();
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

    public boolean checkBoss2State(){
        if (!checkDeckState(boss2)) {
            screen.setState("Win");
            return false;
        }
        else if (!boss2CurCard.getLivingStatus()) {
            boss2CurCard = boss2.getDeck().get(++boss2CurCardNum);
            boss2.setCardsLeft(boss2.getCardsLeft() - 1);
            return false;
        }
        return true;
    }
    public boolean checkPlayerState(){
        if (!checkDeckState(player)){
            screen.setState("Lost");
            return false;
        }
        else if (!screen.getCurCard().getLivingStatus()){
            screen.setCurCard(player.getDeck().get(++currentCard));
            return false;
        }
        return true;
    }
    public void attackPlayer(Card bossCurCard){
        if (randBossMover() == 1){
            int d = bossCurCard.doMove1(screen.getCurCard().getType());
            screen.getCurCard().setHealth(d);
        }
        else{
            int d = bossCurCard.doMove2(screen.getCurCard().getType());
            screen.getCurCard().setHealth(d);
        }
    }
    public boolean checkBoss1State(Player boss){
        if (!checkDeckState(boss)){
            screen.setState("FinalBoss");
            player.deckReset();
            currentCard = 0;
            return false;
        }
        else if (!boss1CurCard.getLivingStatus()){
            boss1CurCard = boss1.getDeck().get(++boss1CurCardNum);
            boss1.setCardsLeft(boss1.getCardsLeft()-1);
            return false;
        }
        return true;
    }

    public void attackBoss(Card bossCurCard, int move){
        if (move == 1){
            bossCurCard.setHealth(screen.getCurCard().doMove1(bossCurCard.getType()));
        }
        else{
            bossCurCard.setHealth(screen.getCurCard().doMove2(bossCurCard.getType()));
        }

    }
    public int randBossMover(){
        return (int)(Math.random()*2) + 1;
    }

    public Player getBoss2(){
        return boss2;
    }

    public Card getBoss2CurCard(){
        return boss2CurCard;
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
        boss2.addToDeck(new Card(charPool.get(5)));
        boss2CurCard = boss2.getDeck().get(0);
        makeCard6(boss2CurCard);
        boss2.setCardsLeft(1);
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

    public void finalbattle(){
        screen.setCurCard(player.getDeck().get(0));
        screen.setState("FinalBossBattle");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startup();
    }





}
