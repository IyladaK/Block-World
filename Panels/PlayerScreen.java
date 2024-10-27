package Panels;

import Frames.MainFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The playerScreen class.
 * creates the panel which prompts the user to select which 
 */
public class PlayerScreen extends JPanel {

    public MainFrame parentFrame; //parent frame for panel switching functions
    private Image bg = new ImageIcon("resources/ChoosePlayers.png").getImage();
    boolean isMultiplayer;
    final int WIDTH = 960;
    final int HEIGHT = 687;
    

    /**
     * The playerScreen constructor.
     * @param parentFrame the mainframe used for panel switching functions
     */
    public PlayerScreen(MainFrame parentFrame) {
        this.parentFrame = parentFrame;

        setPreferredSize(new Dimension(960, 687));
        setLayout(null);

        JButton toGameOneP = new JButton();
        JButton toGameTwoP = new JButton();

        // creating invisible buttons
        toGameTwoP.setBounds(600, 555, 205, 90);
        toGameOneP.setBounds(165, 555, 205, 90);
        // setting the game to multiplayer when this button is pressed
        toGameTwoP.addActionListener(e -> {
            this.parentFrame.switchPlayerToLevelB();
            isMultiplayer = true;
        });
        toGameTwoP.setOpaque(false);
        toGameTwoP.setContentAreaFilled(false);
        toGameTwoP.setBorderPainted(false);

        // setting the game to singleplayer when this button is pressed
        toGameOneP.addActionListener(e -> {
            this.parentFrame.switchPlayerToLevelB();
            isMultiplayer = false;
        });
        toGameOneP.setOpaque(false);
        toGameOneP.setContentAreaFilled(false);
        toGameOneP.setBorderPainted(false);

        add(toGameOneP);
        add(toGameTwoP);

    }

    /**
     * getter method for isMultiplayer.
     * @return - boolean isMultiplayer
     */
    public boolean getMultiplayer() {
        return isMultiplayer;
    }

    /**
     * Overriden paintComponent method which draws the ChoosePlayers.png image.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
