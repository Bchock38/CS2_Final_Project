import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Screen extends JFrame{

    private Game a;
    private final int WINDOW_WIDTH = 1500;
    private final int WINDOW_HEIGHT = 1000;
    private final int TITLE_BAR_HEIGHT = 23;

    private String state;

    private Card curCard;

    public Screen(Game a, String State){
        this.a = a;
        this.state = State;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Screen");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public String getState1(){
        return state;
    }

    public void setCurCard(Card newCurCard){
        curCard = newCurCard;
    }

    public Card getCurCard(){
        return curCard;
    }
    public void setState (String newState){
        state = newState;
    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        g.setColor(Color.black);
        if (state.equals("Draw")){
            g.setFont(new Font("Default", Font.PLAIN,70));
            g.drawString("Press D to draw your deck",300,200);
        }
        else if (state.equals("Drawed")){
            g.setFont(new Font("Default", Font.PLAIN,70));
            g.drawString("You got",600,300);
            for (int i = 0; i <  + a.getPlayer().getDeck().size(); i++){
                g.drawString( a.getPlayer().getDeck().get(i).getName(),200 + i*500, 400);
                a.getPlayer().getDeck().get(i).draw(g,100 + 500*i,500);
            }
            g.setFont(new Font("Default", Font.PLAIN,40));
            g.drawString("Press Space to Continue", 800, 200);
        }
        else if (state.equals("Intro")){
            g.setFont(new Font("Default",Font.PLAIN,20));
            g.drawString("Welcome to the world of Animon", 500, 500);
            g.drawString("Draw your partners and prepare for battle",500,600);
            g.drawString("Press Space to Continue", 800, 800);
        }
        else if(state.equals("Battle")){
            curCard.draw(g,200,450);
            g.setFont(new Font("Default",Font.PLAIN,50));
            g.drawString("1. " + curCard.getMove1N(),100,100);
            g.drawString("2. " + curCard.getMove2N(),500,100);
            g.drawString("Player 1: ", 200,400);
            g.drawString( "Current Card Health: " + Integer.toString(curCard.getHealth()),100,300);
            a.getBoss1CurCard().draw(g,1000,100);
            g.drawString("Boss 1: ", 1000,600);
            g.drawString( "Boss1 Card Health: " + Integer.toString(a.getBoss1CurCard().getHealth()),700,700);
        }
        if(state.equals("Win")){
            g.setFont(new Font("Default",Font.PLAIN,100));
            g.drawString("You Win", 500,500);
        }
        if(state.equals("Lost")){
            g.setFont(new Font("Default",Font.PLAIN,100));
            g.drawString("You Lost", 500,500);
        }
    }

    public void paintBattle(){

    }

}
