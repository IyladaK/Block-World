package Frames; 

import javax.swing.JFrame;
import javax.swing.JPanel;

import Panels.EndScreen;
import Panels.GamePanel;
import Panels.LevelBuilder;
import Panels.MenuScreen;
import Panels.PlayerScreen;

import java.awt.FlowLayout;
import java.awt.Container;


public class MainFrame extends JFrame {
    MenuScreen menuScreen = new MenuScreen(this);
    PlayerScreen playerScreen = new PlayerScreen(this);
    LevelBuilder levelBuilderObj = new LevelBuilder(this);
    JPanel levelBuilder = levelBuilderObj.levelBuilder();
    GamePanel game;
    EndScreen endScreen = new EndScreen(this);

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

    public LevelBuilder getLevelBuilderObj(){
        return this.levelBuilderObj;
    }

    public PlayerScreen getPlayerScreen(){
        return this.playerScreen;
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

        this.game = new GamePanel(this, contentPane);
        game.gamePanel();

        contentPane.revalidate();
        contentPane.repaint(); 
    }

    public void switchGameToLevelBuilder(){
        contentPane.removeAll();

        contentPane.add(levelBuilder);

        contentPane.revalidate();
        contentPane.repaint();
    }

    public void switchGameToEndScreen(){
        contentPane.removeAll();

        contentPane.add(endScreen);

        contentPane.revalidate();
        contentPane.repaint();
    }

    public void switchEndScreenToGame(){
        contentPane.removeAll();
        game.gamePanel();

        contentPane.revalidate();
        contentPane.repaint();

    }

    public void switchEndScreenToPlayerScreen(){
        contentPane.removeAll();
        this.levelBuilderObj.restartFilledCoords();
        contentPane.add(playerScreen);
        contentPane.revalidate();
        contentPane.repaint();

    }
}
