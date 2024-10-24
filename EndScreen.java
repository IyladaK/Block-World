import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EndScreen extends JPanel{

    public MainFrame parentFrame; //parent frame for panel switching functions
    private Image bg = new ImageIcon("resources/EndScreen.jpg").getImage();

     public EndScreen(MainFrame parentFrame){
        this.parentFrame = parentFrame;

        setPreferredSize(new Dimension(960, 687));
        setLayout(null);

        JButton toMenu = new JButton();

        // creating invisible start button
        toMenu.setBounds(672, 513, 228, 126);
        toMenu.addActionListener(e -> {
            this.parentFrame.switchMenuToGame();
        });
        // toMenu.setOpaque(false);
        // toMenu.setContentAreaFilled(false);
        // toMenu.setBorderPainted(false);

        add(toMenu);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
}
