import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Color;
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
        
        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel description = new JLabel("Play!");
        description.setFont(new Font("Arial", Font.PLAIN, 25));
        header.add(description);

        GamePanel panel = new GamePanel(levelBuilderObj.getFilledCoords(), 
                        levelBuilderObj.getStartCoord(), levelBuilderObj.getGoalCoord(), 
                        playerScreen.getMultiplayer());
        panel.setPreferredSize(contentPane.getSize());  // Use contentPane's size
        panel.setBackground(Color.WHITE);
        panel.setFocusable(true);

        JButton editLevel = new JButton("Edit Level");
        editLevel.addActionListener(e -> {
            panel.requestFocusInWindow();
        });
        
        editLevel.setPreferredSize(new Dimension(210, 40));
        header.add(editLevel);

        contentPane.add(header);
        contentPane.add(panel);

        panel.requestFocusInWindow();

        panel.addKeyListener(new KeyChecker(panel.player));
        if (playerScreen.getMultiplayer()) {
            panel.addKeyListener(new KeyChecker(panel.playerTwo));
        }

        contentPane.revalidate();
        contentPane.repaint(); 
        

    }
}
