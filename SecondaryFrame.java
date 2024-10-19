import javax.swing.JFrame;
import java.awt.Color;
import java.util.HashMap;

public class SecondaryFrame extends JFrame{
    HashMap<Coord, Integer> filledCoords;
    
    public SecondaryFrame(HashMap<Coord, Integer> filledCoords) {
        setSize(960, 687);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Block World");
        setLocationRelativeTo(null);
        setVisible(true);

        GamePanel panel = new GamePanel(filledCoords);
        panel.setSize(this.getSize());
        panel.setBackground(Color.WHITE);
        panel.setVisible(true);
        this.add(panel);

        addKeyListener(new KeyChecker(panel));

    }

}
