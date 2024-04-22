import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Screen extends JFrame{

    private Game a;
    private final int WINDOW_WIDTH = 1500;
    private final int WINDOW_HEIGHT = 1000;
    private final int TITLE_BAR_HEIGHT = 23;

    public Screen(Game a){
        this.a = a;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Screen");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

}
