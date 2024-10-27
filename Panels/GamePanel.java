package Panels;

import Frames.MainFrame;
import HelperClasses.KeyChecker;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Class for GamePanel, is-a JPanel. 
 * This houses the game and additionally creates the header and edit level 
 * button into the content pane in MainFrame. 
 */
public class GamePanel extends JPanel {
    
    MainFrame parentFrame;
    Container contentPane;
    Game panel;

    /**
     * Construcer for GamePanel.
     * @param parentFrame - MainFrame which houses the panel.
     * @param contentPane - the Container contentPane where panels need to be added. 
     */
    public GamePanel(MainFrame parentFrame, Container contentPane){
        this.parentFrame = parentFrame;
        this.contentPane = contentPane;
    }

    /**
     * Method gamePanel which is called to instantiate a new game and populate the
     * contentPane with the correct components.
     * Defines the switch function for the editlevel button.
     */
    public void gamePanel(){
        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel description = new JLabel("Play!");
        description.setFont(new Font("Arial", Font.PLAIN, 25));
        header.add(description);

        LevelBuilder levelBuilder = parentFrame.getLevelBuilderObj();

        panel = new Game(levelBuilder.getFilledCoords(), levelBuilder.getStartCoord(), 
                            levelBuilder.getGoalCoord(), 
                            parentFrame.getPlayerScreen().getMultiplayer(), parentFrame);
        panel.setPreferredSize(contentPane.getSize());
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
        if (parentFrame.getPlayerScreen().getMultiplayer()) {
            panel.addKeyListener(new KeyChecker(panel.playerTwo));
        }
    }

    public Game getPanel() {
        return this.panel;
    }
    

}
