package Panels;

import Frames.MainFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * EndScreen class is-a JPanel. Final screen players are faced with each game progression,
 * and is loaded only when the player (or both players) stand on top of the goal block.
 * Prompts the player to either play the same level again which redirects them to the game
 * or create a new level which redirects to PlayerScreen to create a fully new empty level.
 */
public class EndScreen extends JPanel {

    MainFrame parentFrame; // reference to the MainFrame that houses this EndScreen
    private Image bgImg = new ImageIcon("resources/EndScreen.png").getImage();

    /**
     * Constructor for EndScreen instances. Sets bounds for invisible buttons and calls
     * to methods in MainFrame to switch game states.
     * @param parentFrame - the MainFrame which houses this EndScreen.
     */
    public EndScreen(MainFrame parentFrame) {
        this.parentFrame = parentFrame;

        setPreferredSize(new Dimension(960, 687));
        setLayout(null);

        JButton newLevel = new JButton();
        JButton replayLevel = new JButton();


        // setting bounds and action for invisible newLevel button
        newLevel.setBounds(593, 469, 255, 143);
        newLevel.addActionListener(e -> {
            this.parentFrame.switchEndScreenToPlayerScreen();
        });
        newLevel.setOpaque(false);
        newLevel.setContentAreaFilled(false);
        newLevel.setBorderPainted(false);

        // setting bounds and action for invisible replayLevel button
        replayLevel.setBounds(95, 469, 255, 143);
        replayLevel.addActionListener(e -> {
            this.parentFrame.switchEndScreenToGame();
        });
        replayLevel.setOpaque(false);
        replayLevel.setContentAreaFilled(false);
        replayLevel.setBorderPainted(false);


        add(newLevel);
        add(replayLevel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImg, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
}
