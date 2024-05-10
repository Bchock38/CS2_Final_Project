import java.awt.*;

public class Card {

    private String name;

    private int health;

    private int indexNum;

    private String owner;

    private Screen screen;

    private boolean isAlive;

    private int move1D;
    private String move1N;
    private int move2D;
    private String move2N;

    private String type;

    private Image card;

    private String move1T;
    private String move2T;
    private int move1H;
    private int move2H;

    private int move1Crit;

    private int move2Crit;

    private int orgH;

    public Card(String name, int health, int indexNum, String owner, Screen screen, Image image){
        this.name = name;
        this.health = health;
        orgH = health;
        this.indexNum = indexNum;
        this.owner = owner;
        this.screen = screen;
        move1D = 0;
        move1N = "";
        move2D = 0;
        move2N = "";
        move1H = 0;
        move2H = 0;
        card = image;
        isAlive = true;
        type = "";
    }

    public Card(Card card) {
        this.name = card.getName();
        this.health = card.getHealth();
        orgH = card.getHealth();
        move1D = 0;
        move1N = "";
        move2D = 0;
        move2N = "";
        move1H = 0;
        move2H = 0;
        this.card = card.getImage();
        isAlive = true;
        type = "";
    }

    public Image getImage(){
        return card;
    }
    public String getName(){
        return name;
    }
    public void setType(String type){
        this.type = type;
    }

    public void setMove1(String name, int damage, int heal, String moveType, int crit){
        move1D = damage;
        move1N = name;
        move1H = heal;
        move1T = moveType;
        move1Crit = crit;
    }

    public boolean getLivingStatus(){
        if (health <= 0){
            isAlive = false;
        }
        return isAlive;
    }
    public void setMove2(String name, int damage, int heal, String moveType, int crit){
        move2D = damage;
        move2N = name;
        move2H = heal;
        move2T = moveType;
        move2Crit = crit;
    }

    public void reset(){
        health = orgH;
        isAlive = true;
    }
    public void setHealth(int damage){
        health -=damage;
    }

    public String getType(){
        return type;
    }
    public int doMove1(String oponentType){
        health += move1H;
        if (move1Crit != 0){
            int probability = (int)(Math.random()*100)+1;
            if (probability <= move1Crit){
                move1D *=2 ;
            }
        }
        if (move1T.equals("Fire") && oponentType.equals("Water")){
            return move1D/2;
        }
        else if (move1T.equals("Fire") && oponentType.equals("Grass")){
            return move1D*2;
        }
        else if (move1T.equals("Water") && oponentType.equals("Grass")){
            return move1D/2;
        }
        else if (move1T.equals("Water") && oponentType.equals("Fire")){
            return move1D*2;
        }
        else if (move1T.equals("Grass") && oponentType.equals("Fire")){
            return move1D/2;
        }
        else if (move1T.equals("Grass") && oponentType.equals("Water")){
            return move1D*2;
        }
        else if (move1T.equals("Grass") && oponentType.equals("WATERGRASS")){
            return (int) (move1D/2);
        }
        else {
            return move1D;
        }


    }

    public int doMove2(String oponentType){
        health += move2H;
        if (move2Crit != 0){
            int probability = (int)(Math.random()*100)+1;
            if (probability <= move2Crit){
                move2D *=2;
            }
        }
        if (move2T.equals("Fire") && oponentType.equals("Water")){
            return move2D/2;
        }
        else if (move2T.equals("Fire") && oponentType.equals("Grass")){
            return move2D*2;
        }
        else if (move2T.equals("Water") && oponentType.equals("Grass")){
            return move2D/2;
        }
        else if (move2T.equals("Water") && oponentType.equals("Fire")){
            return move2D*2;
        }
        else if (move2T.equals("Grass") && oponentType.equals("Fire")){
            return move2D/2;
        }
        else if (move2T.equals("Grass") && oponentType.equals("Water")){
            return move2D*2;
        }
        else if (move2T.equals("Grass") && oponentType.equals("WATERGRASS")){
            return (int) (move2D/2);
        }
        else {
            return move2D;
        }
    }

    public String getMove1N(){
        return move1N;
    }
    public String getMove2N(){
        return move2N;
    }

    public int getHealth(){
        return health;
    }
    public void draw(Graphics g, int x, int y){
        g.setFont(new Font("Default",Font.PLAIN,50));
        g.drawImage(card,x,y,260,400,screen);
    }
}
