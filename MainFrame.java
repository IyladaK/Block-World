import javax.swing.JFrame;
import java.awt.Color;

public class MainFrame extends JFrame{
    
    public MainFrame() {

        GamePanel panel = new GamePanel();
       // panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.WHITE);
        panel.setVisible(true);
        this.add(panel);

        addKeyListener(new KeyChecker(panel));



    }

}
