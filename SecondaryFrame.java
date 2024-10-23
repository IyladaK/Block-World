import javax.swing.JFrame;
import java.awt.Color;
import java.util.HashMap;

public class SecondaryFrame extends JFrame{
    HashMap<Coord, Integer> filledCoords;
    Coord startCoord;
    Coord goalCoord;
    boolean isMultiplayer;
    
    public SecondaryFrame(HashMap<Coord, Integer> filledCoords, Coord startCoord, Coord goalCoord, boolean isMultiplayer) {
        this.startCoord = startCoord;
        this.goalCoord = goalCoord;
        this.isMultiplayer = isMultiplayer;
        
        setSize(960, 687);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Block World");
        setLocationRelativeTo(null);
        setVisible(true);

        GamePanel panel = new GamePanel(filledCoords, startCoord, goalCoord, isMultiplayer);
        panel.setSize(this.getSize());
        panel.setBackground(Color.WHITE);
        panel.setVisible(true);
        this.add(panel);

        addKeyListener(new KeyChecker(panel.player));
        if (isMultiplayer){
            addKeyListener(new KeyChecker(panel.playerTwo));
        }

    }

}
