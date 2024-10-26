import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Container;


public class MainFrame extends JFrame {
    MenuScreen menuScreen = new MenuScreen(this);
    PlayerScreen playerScreen = new PlayerScreen(this);
    LevelBuilder levelBuilderObj = new LevelBuilder(this);
    JPanel levelBuilder = levelBuilderObj.levelBuilder();
    GamePanel game;
    Container contentPane;

    public MainFrame(){
        setTitle("BloxWorld");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 725);
        setResizable(true);
        setLocationRelativeTo(null);

        contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(menuScreen);

        setVisible(true);
    }

    public void switchMenuToPlayerScreen(){
        contentPane.removeAll();  // Remove all components
        contentPane.add(playerScreen);
        contentPane.revalidate(); // Revalidate layout
        contentPane.repaint();    // Repaint to update UI

    }

    public void switchPlayerToLevelB(){
        contentPane.removeAll();  // Remove all components
        contentPane.add(levelBuilder);
        contentPane.revalidate(); // Revalidate layout
        contentPane.repaint();    // Repaint to update UI
    }

    public void switchLevelBuilderToGame(){
        contentPane.removeAll();  // Remove all components
        
        new GamePanel(this, contentPane);

        contentPane.revalidate();
        contentPane.repaint(); 
    }

    public void switchGameToLevelBuilder(){
        contentPane.removeAll();

        contentPane.add(levelBuilder);

        contentPane.revalidate();
        contentPane.repaint();
    }
}
