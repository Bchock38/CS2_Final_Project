//Benjamin Chock
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

    private Card curCard;

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
        //Intialize all card images
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
        //Add all cards to the character pool
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
       //Set up each card with the correct moves
        makeCard1(charPool.get(0));
        makeCard2(charPool.get(1));
        makeCard3(charPool.get(2));
        makeCard4(charPool.get(3));
        makeCard5(charPool.get(4));
        makeCard6(charPool.get(5));
    }

    //Make card 1
    public void makeCard1(Card a){
        a.setMove1("Razor Leaf",60, 0,"Grass",0);
        a.setMove2("Giga Drain",40, 20, "Grass",0);
        a.setType("Grass");
    }

    //Make card 2
    public void makeCard2(Card a){
        a.setMove1("Water Gun",60, 0,"Water",0);
        a.setMove2("Aqua Tail",40,0 ,"Water",30);
        a.setType("Water");
    }

    //Make card 3
    public void makeCard3(Card a){
        a.setMove1("Flamethrower",70, 0,"Fire",0);
        a.setMove2("Nova Punch",50,0 ,"Normal",0);
        a.setType("Fire");
    }

    //Make card 4
    public void makeCard4(Card a){
        a.setMove1("Body Slam",40, 0,"Normal",0);
        a.setMove2("Recover",10,50 ,"Normal",0);
        a.setType("Normal");
    }

    //Make card 5
    public void makeCard5(Card a){
        a.setMove1("Hydro Pump",75, 0,"Water",0);
        a.setMove2("Solar Beam",90,0 ,"Grass",0);
        a.setType("WATERGRASS");
    }

    //Make card 6
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
                //check if user used move one while fighting boss1
                if (screen.getState1().equals("Battle")){
                    //deal damage to boss
                    attackBoss(boss1CurCard,1);
                    //check if the bosses card is dead or if his whole team is dead
                    if (!checkBoss1State(boss1)){
                        screen.repaint();
                        break;
                    }
                    //Have boss attack player
                    attackPlayer(boss1CurCard);
                    //check if players card or deck is still alive
                    if (!checkPlayerState()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                }
                //check if user used move one while fighting boss2
                else if (screen.getState1().equals("FinalBossBattle")) {
                    screen.repaint();
                    //attack current boss
                    attackBoss(boss2CurCard,1);
                    //check if current bosses card or deck is still alive
                    if (!checkBoss2State()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                    //deal damage to player
                    attackPlayer(boss2CurCard);
                    //check if players card or deck is still alive
                    if (!checkPlayerState()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                }
                break;

            case KeyEvent.VK_2:
                //check if user used move two while fighting boss1
                if (screen.getState1().equals("Battle")) {
                    //deal damage to current boss
                    attackBoss(boss1CurCard,2);
                    //check if bosses card or deck is still alive
                    if (!checkBoss1State(boss1)){
                        screen.repaint();
                        break;
                    }
                    //deal damage to player
                    attackPlayer(boss1CurCard);
                    //check if players card or deck is still alive
                    if (!checkPlayerState()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                }
                //check if user used move two while fighting boss2
                else if (screen.getState1().equals("FinalBossBattle")){
                    //deal damage to current boss
                    attackBoss(boss2CurCard,2);
                    //check if current bosses card and deck is still alive
                    if (!checkBoss2State()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                    //deal damage to player
                    attackPlayer(boss2CurCard);
                    //check if players card or deck is still alive
                    if (!checkPlayerState()){
                        screen.repaint();
                        break;
                    }
                    screen.repaint();
                }
                break;

            case KeyEvent.VK_SPACE:
                //if space is pressed during intro change to get cards screen
                if (screen.getState1().equals("Intro")){
                    getCards();
                }
                //if space is pressed during Drawed change to battle screen
                else if (screen.getState1().equals("Drawed")){
                    screen.setState("Battle");
                    battle();
                    screen.repaint();
                }
                //if space is pressed during FinalBoss change to FinalBossBattle
                else if (screen.getState1().equals("FinalBoss")){
                    screen.setState("FinalBossBattle");
                    finalbattle();
                    screen.repaint();
                }
                break;

            case KeyEvent.VK_D:
                //if D is pressed during Draw stage change state to Drawed
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
        //check if boss2 deck is still alive, if not have player win
        if (!checkDeckState(boss2)) {
            screen.setState("Win");
            return false;
        }
        //check if boss2 current card is still alive, if not change current card to next card in deck
        else if (!boss2CurCard.getLivingStatus()) {
            boss2CurCard = boss2.getDeck().get(++boss2CurCardNum);
            boss2.setCardsLeft(boss2.getCardsLeft() - 1);
            return false;
        }
        return true;
    }
    public boolean checkPlayerState(){
        //check if player deck is still alive, if not player losses
        if (!checkDeckState(player)){
            screen.setState("Lost");
            return false;
        }
        //check if player's current card is still alive if not next card in deck is set to current card
        else if (!curCard.getLivingStatus()){
            curCard = (player.getDeck().get(++currentCard));
            return false;
        }
        return true;
    }
    public void attackPlayer(Card bossCurCard){
        //get a random # 1 or 2 if 1 than use move one
        if (randBossMover() == 1){
            //calculate damage based on base damage, type, and crit chance
            int d = bossCurCard.doMove1(curCard.getType());
            //have health minus damage
            curCard.setHealth(d);
        }
        else{
            //calculate damage based on base damage, type, and crit chance
            int d = bossCurCard.doMove2(curCard.getType());
            //have health minus damage
            curCard.setHealth(d);
        }
    }
    public boolean checkBoss1State(Player boss){
        //check if boss1 deck is still alive, if not have set up boss2 battle
        if (!checkDeckState(boss)){
            screen.setState("FinalBoss");
            //reset all cards to full health
            player.deckReset();
            //set current card to top of deck
            currentCard = 0;
            return false;
        }
        //check if boss1 current card is alive, if not set current card to next in deck
        else if (!boss1CurCard.getLivingStatus()){
            boss1CurCard = boss1.getDeck().get(++boss1CurCardNum);
            boss1.setCardsLeft(boss1.getCardsLeft()-1);
            return false;
        }
        return true;
    }

    public void attackBoss(Card bossCurCard, int move){
        //if move is move one deal move ones damge to boss
        if (move == 1){
            bossCurCard.setHealth(curCard.doMove1(bossCurCard.getType()));
        }
        //otherwise use move 2s damage
        else{
            bossCurCard.setHealth(curCard.doMove2(bossCurCard.getType()));
        }

    }
    public int randBossMover(){
        //pick a random move for boss to use
        return (int)(Math.random()*2) + 1;
    }

    public Player getBoss2(){
        return boss2;
    }

    public Card getBoss2CurCard(){
        return boss2CurCard;
    }

    public void setUpBossCard(Card bossCard, int selector){
        if (selector == 0){
            makeCard1(bossCard);
        }
        else if (selector == 1){
            makeCard2(bossCard);
        }
        else if (selector == 2){
            makeCard3(bossCard);
        }
        else if (selector == 3){
            makeCard4(bossCard);
        }
        else {
            makeCard5(bossCard);
        }
    }
    public void startup(){
        //pick a random card
        int selector = (int)(Math.random()*5);
        //add it to the bosses deck
        boss1.addToDeck(new Card (charPool.get(selector)));
        //set boss1s current card to the first card in his deck
        boss1CurCard = boss1.getDeck().get(0);
        //set up the card
        setUpBossCard(boss1CurCard,selector);
        //pick another random card
        selector = (int)(Math.random()*5);
        //add it to boss1's deck
        boss1.addToDeck(new Card (charPool.get(selector)));
        //set up the card
        setUpBossCard(boss1.getDeck().get(1),selector);
        //pick another random card
        selector = (int)(Math.random()*5);
        //add it to boss1's deck
        boss1.addToDeck(new Card (charPool.get(selector)));
        //set up the card
        setUpBossCard(boss1.getDeck().get(2),selector);
        //give boss2 the boss card
        boss2.addToDeck(new Card(charPool.get(5)));
        //set boss2's current card to the first card in his deck
        boss2CurCard = boss2.getDeck().get(0);
        //set up boss2's card
        makeCard6(boss2CurCard);
        //set that boss2 only has one card
        boss2.setCardsLeft(1);
        //change state to intro state
        screen.setState("Intro");
    }

    public void getCards(){
        //pick a random card
        int selector = (int)(Math.random()*5);
        //give to player
        player.addToDeck(charPool.get(selector));
        charPool.remove(selector);
        //pick a different random card
        selector = (int)(Math.random()*4);
        //give to player
        player.addToDeck(charPool.get(selector));
        charPool.remove(selector);
        //pick a different random card
        selector = (int)(Math.random()*3);
        //give to player
        player.addToDeck(charPool.get(selector));
        //set state to draw
        screen.setState("Draw");
        screen.repaint();
    }

    public boolean checkDeckState(Player toCheck){
        //check if all cards in deck are alive or not
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
        //set state to battle
        curCard = (player.getDeck().get(currentCard));
        screen.setState("Battle");
    }

    public Card getCurCard(){
        return curCard;
    }

    public void finalbattle(){
        //set state to FinalBossBattle
        curCard = (player.getDeck().get(0));
        screen.setState("FinalBossBattle");
    }

    public static void main(String[] args) {
        //make game
        Game game = new Game();
        //run it
        game.startup();
    }





}
