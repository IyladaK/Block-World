package Panels;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import Frames.MainFrame;
import java.awt.Image;
import java.awt.Dimension;


public class EndScreen extends JPanel{

    MainFrame parentFrame;
    private Image bgImg = new ImageIcon("resources/EndScreen.png").getImage();

    public EndScreen(MainFrame parentFrame) {
        this.parentFrame = parentFrame;

        setPreferredSize(new Dimension(960, 687));
        setLayout(null);

        JButton newLevel = new JButton();
        JButton replayLevel = new JButton();


        // creating invisible start button
        newLevel.setBounds(593, 469, 255, 143);
        newLevel.addActionListener(e -> {
            this.parentFrame.switchEndScreenToPlayerScreen();
        });
        newLevel.setOpaque(false);
        newLevel.setContentAreaFilled(false);
        newLevel.setBorderPainted(false);

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
