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

    private Card boss1CurCard;

    public Game(){
        player = new Player("");
        boss1 = new Player("");
        charPool = new ArrayList<Card>();
        Image image1 = new ImageIcon("Resources/_草.png").getImage();
        Image image2 = new ImageIcon("Resources/水.png").getImage();
        Image image3 = new ImageIcon("Resources/火.png").getImage();
        Image image4;
        Image image5;
        Image image6;
        Image image7;
        Image image8;
        Image image9;
        Image image10;
        screen = new Screen(this,"Instructions");
        charPool.add(new Card("草",100,1,"", screen, image1));
        charPool.add(new Card("水",150,2,"", screen, image2));
        charPool.add(new Card("火",125,3,"", screen, image3));
//        charPool.add(new Card("3",100,3,"", screen,image3));
//        charPool.add(new Card("4",100,4,"", screen,image4));
//        charPool.add(new Card("5",100,5,"", screen,image5));
//        charPool.add(new Card("6",100,6,"", screen,image6));
//        charPool.add(new Card("7",100,7,"", screen,image7));
//        charPool.add(new Card("8",100,8,"", screen,image8));
//        charPool.add(new Card("9",100,9,"", screen,image9));
//        charPool.add(new Card("10",100,10,"", screen,image10));
        screen.addKeyListener(this);
        makeCard1();
        makeCard2();
        makeCard3();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startup();
        game.getCards();
        game.battle();
    }
    public void makeCard1(){
        charPool.get(0).setMove1("Razor Leaf",60, 0,"Grass");
        charPool.get(0).setMove2("Giga Drain",40, 20, "Grass");
        charPool.get(0).setType("Grass");
    }

    public void makeCard2(){
        charPool.get(1).setMove1("Water Gun",60, 0,"Water");
        charPool.get(1).setMove2("Aqua Tail",40,0 ,"Water");
        charPool.get(1).setType("Water");
    }

    public void makeCard3(){
        charPool.get(2).setMove1("Flamethrower",70, 0,"Fire");
        charPool.get(2).setMove2("Nova Punch",50,0 ,"Normal");
        charPool.get(2).setType("Fire");
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
                if (screen.getState1().equals("battle")){
                    boss1CurCard.setHealth(screen.getCurCard().doMove1(boss1CurCard.getType()));
                    if (randBossMover() == 1){
                        screen.getCurCard().setHealth(boss1CurCard.doMove1(screen.getCurCard().getType()));
                    }
                    else{
                        screen.getCurCard().setHealth(boss1CurCard.doMove2(screen.getCurCard().getType()));
                    }
                    screen.repaint();
                    if (!checkDeckState(player)){
                        screen.setState("Lost");
                    }
                    else if (!checkDeckState(boss1)){
                        screen.setState("Win");
                    }

                }
                break;

            case KeyEvent.VK_2:
                if (screen.getState1().equals("battle")){
                    boss1CurCard.setHealth(screen.getCurCard().doMove2(boss1CurCard.getType()));
                    if (randBossMover() == 1){
                        screen.getCurCard().setHealth(boss1CurCard.doMove1(screen.getCurCard().getType()));
                    }
                    else{
                        screen.getCurCard().setHealth(boss1CurCard.doMove2(screen.getCurCard().getType()));
                    }
                    screen.repaint();
                    if (!checkDeckState(player)){
                        screen.setState("Lost");
                    }
                    else if (!checkDeckState(boss1)){
                        screen.setState("Win");
                    }

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
        boss1.addToDeck(charPool.get(0));
        boss1CurCard = boss1.getDeck().get(0);
    }

    public void getCards(){
        int selector = (int)(Math.random()*3);
        player.addToDeck(charPool.get(selector));



    }

    public boolean checkDeckState(Player toCheck){
        for (int i = 0; i < toCheck.getDeck().size(); i++){
            if (toCheck.getDeck().get(i).getLivingStatus() == true){
                return true;
            }
        }
        return false;
    }

    public Card getBoss1CurCard(){
        return boss1CurCard;
    }

    public void battle(){
        screen.setState("battle");
        screen.setCurCard(player.getDeck().get(0));
        screen.repaint();
//        Card opCard = boss1.getDeck().get(0);
//        opCard.draw(screen.getGraphics(),300,100);
        //prompt user for a move


    }





}
