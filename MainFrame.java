import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class MainFrame extends JFrame{

    CardLayout cardLayout;
    private MenuScreen menuScreen = new MenuScreen(this);
    private LevelBuilder lb = new LevelBuilder(this);
    private JPanel levelBuilder = lb.levelBuilder();
    
    public MainFrame() {
        setSize(960, 687);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Blox World");
        setLocationRelativeTo(null);
        setVisible(true);

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(this.menuScreen, "menuScreen");
        add(this.levelBuilder, "levelBuilder");

    }

    public void switchMenuToGame(){
        this.cardLayout.show(getContentPane(), "levelBuilder");

    }

    public void switchLevelBuilderToGame(){
        new SecondaryFrame(lb.getFilledCoords(), lb.getStartCoord(), lb.getGoalCoord(), true);

    }

}
