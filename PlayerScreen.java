import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class PlayerScreen extends JPanel{

    public MainFrame parentFrame; //parent frame for panel switching functions
    private Image bg = new ImageIcon("resources/ChoosePlayers.jpg").getImage();
    
    public PlayerScreen(MainFrame parentFrame){
        this.parentFrame = parentFrame;

        setPreferredSize(new Dimension(960, 687));
        setLayout(null);

        JButton toGameOneP = new JButton();
        JButton toGameTwoP = new JButton();

        // // creating invisible start button
        toGameOneP.setBounds(590, 530, 200, 80);
        toGameTwoP.setBounds(160, 530, 200, 80);

        toGameOneP.addActionListener(e -> {
            this.parentFrame.switchPlayerToLevelB();
        });
        toGameOneP.setOpaque(false);
        toGameOneP.setContentAreaFilled(false);
        toGameOneP.setBorderPainted(false);

        toGameTwoP.addActionListener(e -> {
            this.parentFrame.switchPlayerToLevelB();
        });
        toGameTwoP.setOpaque(false);
        toGameTwoP.setContentAreaFilled(false);
        toGameTwoP.setBorderPainted(false);


        add(toGameOneP);
        add(toGameTwoP);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
