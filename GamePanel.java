import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Container;
import java.awt.FlowLayout;


public class GamePanel extends JPanel{
    
    MainFrame parentFrame;
    Container contentPane;

    public GamePanel(MainFrame parentFrame, Container contentPane){
        this.parentFrame = parentFrame;
        this.contentPane = contentPane;

        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel description = new JLabel("Play!");
        description.setFont(new Font("Arial", Font.PLAIN, 25));
        header.add(description);

        Game panel = new Game(parentFrame.levelBuilderObj.getFilledCoords(), 
                        parentFrame.levelBuilderObj.getStartCoord(), 
                        parentFrame.levelBuilderObj.getGoalCoord(), 
                        parentFrame.playerScreen.getMultiplayer(), parentFrame);
        panel.setPreferredSize(contentPane.getSize());  // Use contentPane's size
        panel.setBackground(Color.WHITE);
        panel.setFocusable(true);

        JButton editLevel = new JButton("Edit Level");
        editLevel.addActionListener(e -> {
            parentFrame.switchGameToLevelBuilder();
            panel.requestFocusInWindow();
        });
        
        editLevel.setPreferredSize(new Dimension(210, 40));
        header.add(editLevel);

        contentPane.add(header);
        contentPane.add(panel);

        panel.requestFocusInWindow();

        panel.addKeyListener(new KeyChecker(panel.player));
        if (parentFrame.playerScreen.getMultiplayer()) {
            panel.addKeyListener(new KeyChecker(panel.playerTwo));
        }


    }



    

}
