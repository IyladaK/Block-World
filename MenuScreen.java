import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;


public class MenuScreen extends JPanel{
    
    public MainFrame parentFrame; //parent frame for panel switching functions
    private Image bg = new ImageIcon("resources/MenuScreen-1.jpg").getImage();
    private Image bgTwo = new ImageIcon("resources/MenuScreen-2.jpg").getImage();

    public MenuScreen(MainFrame parentFrame){
        this.parentFrame = parentFrame;

        setPreferredSize(new Dimension(960, 687));
        setLayout(null);

        JButton toGame = new JButton();

        // creating invisible start button
        toGame.setBounds(672, 513, 228, 126);
        toGame.addActionListener(e -> {
            this.parentFrame.switchMenuToGame();
        });
        toGame.setOpaque(false);
        toGame.setContentAreaFilled(false);
        toGame.setBorderPainted(false);

        add(toGame);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    
}
