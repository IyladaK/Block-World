import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class PlayerScreen extends JPanel{

    public MainFrame parentFrame; //parent frame for panel switching functions
    private Image bg = new ImageIcon("resources/ChoosePlayers.png").getImage();
    boolean isMultiplayer;
    final int WIDTH = 960;
    final int HEIGHT = 687;
    

    public PlayerScreen(MainFrame parentFrame){
        this.parentFrame = parentFrame;

        setPreferredSize(new Dimension(960, 687));
        setLayout(null);

        JButton toGameOneP = new JButton();
        JButton toGameTwoP = new JButton();

        // // creating invisible start button
        toGameTwoP.setBounds(600, 555, 205, 90);
        toGameOneP.setBounds(165, 555, 205, 90);

        toGameTwoP.addActionListener(e -> {
            this.parentFrame.switchPlayerToLevelB();
            isMultiplayer = true;
        });
        toGameTwoP.setOpaque(false);
        toGameTwoP.setContentAreaFilled(false);
        toGameTwoP.setBorderPainted(false);

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

    public boolean getMultiplayer() {
        return isMultiplayer;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
