package Panels;

import Frames.MainFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * MenuScreen class is-a JPanel. First screen that player is met with, houses button
 * which switches the PlayerScreen.
 * MenuScreen panel is hosued within MainFrame.
 */
public class MenuScreen extends JPanel {
    
    public MainFrame parentFrame; //parent frame for panel switching functions
    private Image bg = new ImageIcon("resources/MenuScreen.png").getImage();

    /**
     * Constructor for MenuScreen. Sets the size and layout specifics and defines the 
     * boundaries of an invisible button to switch to PlayerScreen.
     * @param parentFrame - the MainFrame parent object which houses this MenuScreen object.
     */
    public MenuScreen(MainFrame parentFrame) {
        this.parentFrame = parentFrame;

        setPreferredSize(new Dimension(960, 687));
        setLayout(null);

        JButton toPlayers = new JButton();

        // creating invisible start button
        toPlayers.setBounds(672, 513, 228, 126);
        toPlayers.addActionListener(e -> {
            this.parentFrame.switchMenuToPlayerScreen();
        });
        toPlayers.setOpaque(false);
        toPlayers.setContentAreaFilled(false);
        toPlayers.setBorderPainted(false);

        add(toPlayers);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    
}
