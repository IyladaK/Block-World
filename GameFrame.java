import java.awt.CardLayout;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame{

    CardLayout cardLayout;

    private JPanel levelBuilder = (new LevelBuilder()).levelBuilder();
    private JPanel startMenu = (new StartMenu(this)).StartPanel();
    private JPanel menuScreen = new MenuScreen(this);

    public GameFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BlockWorld");

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(this.menuScreen);
        add(this.startMenu);
        add(this.levelBuilder, "levelBuilder");
        System.out.println(levelBuilder.getWidth() + " " + levelBuilder.getHeight());
        pack();

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        System.out.println(getWidth());
        System.out.println(getHeight());

    }

    public void switchMenuToGame(){
        this.cardLayout.show(getContentPane(), "levelBuilder");
    }

}
