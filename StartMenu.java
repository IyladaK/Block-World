import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends JPanel{

    public GameFrame parentFrame;
    final int originalTileSize = 1;
    final int scale = 40;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 9;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    public StartMenu(GameFrame parentFrame){
        this.parentFrame = parentFrame;
    }


    public JPanel StartPanel() {

        // creating the panel
        JPanel startPanel = new JPanel();
        startPanel.setPreferredSize(new Dimension(screenWidth, screenHeight));
        startPanel.setBackground(Color.WHITE);
        startPanel.setLayout(null);
        //not sure if this is necessary 
        startPanel.setDoubleBuffered(true);

        // creating components for the start panel 
        JLabel title = new JLabel("Welcome to Box World");
        title.setFont(new Font("Arial", Font.PLAIN, 24));
        title.setBounds(200, 5, 300, 50);
        title.setForeground(Color.BLACK);

        JLabel description = new JLabel("Create your own map and play with up to 3 friends!");
        description.setFont(new Font("Arial", Font.PLAIN, 20));
        description.setBounds(80, 50, 600, 50);
        description.setForeground(Color.BLACK);

        JLabel rules = new JLabel("Rules:");
        rules.setFont(new Font("Arial", Font.PLAIN, 18));
        rules.setBounds(40, 100, 100, 50);
        rules.setForeground(Color.BLACK);

        JLabel greenS = new JLabel("");
        greenS.setOpaque(true);
        greenS.setBackground(Color.GREEN);
        greenS.setBounds(20, 150, 50, 10);

        JLabel lGreen = new JLabel("The starting point");
        lGreen.setFont(new Font("Arial", Font.PLAIN, 18));
        lGreen.setBounds(100, 130, 600, 50);
        lGreen.setForeground(Color.GREEN);

        JLabel blackS = new JLabel("");
        blackS.setOpaque(true);
        blackS.setBackground(Color.BLACK);
        blackS.setBounds(20, 180, 50, 10);

        JLabel lBlack = new JLabel("A regular boundary block for the floor and walls");
        lBlack.setFont(new Font("Arial", Font.PLAIN, 18));
        lBlack.setBounds(100, 160, 600, 50);
        lBlack.setForeground(Color.BLACK);

        JLabel blueS = new JLabel("");
        blueS.setOpaque(true);
        blueS.setBackground(Color.BLUE);
        blueS.setBounds(20, 210, 50, 10);

        JLabel lBlue = new JLabel("A climable block! Press W and watch you block person climb");
        lBlue.setFont(new Font("Arial", Font.PLAIN, 18));
        lBlue.setBounds(100, 190, 600, 50);
        lBlue.setForeground(Color.BLUE);

        JLabel redS = new JLabel("");
        redS.setOpaque(true);
        redS.setBackground(Color.RED);
        redS.setBounds(20, 240, 50, 10);

        JLabel lRed = new JLabel("Instant death! Your block person will respawn at the start block");
        lRed.setFont(new Font("Arial", Font.PLAIN, 18));
        lRed.setBounds(100, 220, 600, 50);
        lRed.setForeground(Color.RED);

        JLabel orangeS = new JLabel("");
        orangeS.setOpaque(true);
        orangeS.setBackground(Color.ORANGE);
        orangeS.setBounds(20, 270, 50, 10);

        JLabel lOrange = new JLabel("The end point. Reach this block to win the game!");
        lOrange.setFont(new Font("Arial", Font.PLAIN, 18));
        lOrange.setBounds(100, 250, 600, 50);
        lOrange.setForeground(Color.ORANGE);


        JButton toGame = new JButton("Start Playing");
        toGame.setBounds(500, 300, 120, 50);
        toGame.addActionListener(e -> {
            this.parentFrame.switchMenuToGame();
        });
        
        
        // adding all the components to the start panel
        startPanel.add(title);
        startPanel.add(description);
        startPanel.add(rules);
        startPanel.add(toGame);
                
        startPanel.add(lGreen);
        startPanel.add(lBlack);
        startPanel.add(lBlue);
        startPanel.add(lRed);
        startPanel.add(lOrange);

        startPanel.add(greenS);
        startPanel.add(blackS);
        startPanel.add(blueS);
        startPanel.add(redS);
        startPanel.add(orangeS);





        return startPanel;

    }


}
