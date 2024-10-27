package Panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import HelperClasses.Coord;
import Frames.MainFrame;



public class LevelBuilder extends JPanel {
    MainFrame parentFrame;

    private static final int ROWS = 18;
    private static final int COLS = 32;
    private static final int C_S = 30;
    private HashMap<Coord, Integer> filledCoords = new HashMap<Coord, Integer>();
    int curColor = 1;

    private Image bg = new ImageIcon("resources/gridCloudBg.png").getImage();

    private final Color red = new Color(237, 50, 46);
    private final Color blue = new Color(15, 158, 213);
    private final Color orange = new Color(237, 99, 44);
    private final Color green = new Color(71, 212, 90);


    private boolean hasStart;
    private boolean hasGoal;
    private Coord startCoord;
    private Coord goalCoord;
    

    public LevelBuilder(MainFrame parentFrame) {
        this.parentFrame = parentFrame;

        createFloor();

        setPreferredSize(new Dimension(COLS * C_S, ROWS * C_S));
        setBackground(Color.WHITE);

        // Add mouse listeners to handle clicks and drags
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Output the mouse position when clicked
                int row = e.getX() / C_S;
                int col = e.getY() / C_S;

                Coord curCoord = new Coord(row, col);

                colorChecker(curCoord);
                paintComponent(getGraphics());
                
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int row = e.getX() / C_S;
                int col = e.getY() / C_S;

                Coord curCoord = new Coord(row, col);

                colorChecker(curCoord);
                paintComponent(getGraphics());
            }
        });
    }

    private void colorChecker(Coord curCoord) {
        if (curColor == 0) {
            filledCoords.remove(curCoord);
            
        } else if (curColor == 5) {
            hasGoal = true;
            goalCoord = curCoord;
        } else if (curColor == 4) {
            hasStart = true;
            startCoord = curCoord;
        } else {
            filledCoords.put(curCoord, curColor);
        }
    }

    private void createFloor() {
        for(int i = 0; i < COLS; i++){
            filledCoords.put(new Coord(i, 17), 1);
        }
    }

    private void setCurColor(int newColor) {
        curColor = newColor;
    }

    public HashMap<Coord, Integer> getFilledCoords() {
        return filledCoords;
    }

    public Coord getStartCoord() {
        return this.startCoord;
    }

    public Coord getGoalCoord() {
        return this.goalCoord;
    }

    public void restartGameState() {
        filledCoords.clear();
        hasStart = false;
        hasGoal = false;
        startCoord = null;
        goalCoord = null;
        createFloor();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);

        for (Coord coord : filledCoords.keySet()) {
            switch (filledCoords.get(coord)) {
                case 1:
                    g.setColor(Color.BLACK);
                    break;
                case 2:
                    g.setColor(this.blue);
                    break;
                case 3:
                    g.setColor(this.red);
                    break;
                default:
                    break;
            }
            g.fillRect(coord.x * C_S, coord.y * C_S, C_S, C_S);
        }

        if (hasStart) {
            g.setColor(this.orange);
            g.fillRect(startCoord.x * C_S, startCoord.y * C_S, C_S, C_S);
        }

        if (hasGoal) {
            g.setColor(this.green);
            g.fillRect(goalCoord.x * C_S, goalCoord.y * C_S, C_S, C_S);
        }
    }

    public JPanel levelBuilder(){

        JPanel compiler = new JPanel();

        // Panel for the first row of buttons (Red, Blue, Black, Erase)
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new GridLayout(1, 4, 10, 10)); // 1 row, 4 columns, 10px gaps

        JButton black = new JButton("Black - BORDER");
        JButton blue = new JButton("Blue - CLIMB");
        JButton red = new JButton("Red - DAMAGE");
        JButton erase = new JButton("Erase");

        buttonPanel1.add(black);
        buttonPanel1.add(blue);
        buttonPanel1.add(red);
        buttonPanel1.add(erase);

        erase.addActionListener(e -> {
            this.setCurColor(0);
        });

        black.addActionListener(e -> {
            this.setCurColor(1);
        });
        blue.addActionListener(e -> {
            this.setCurColor(2);
        });
        red.addActionListener(e -> {
            this.setCurColor(3);
        });

        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel description = new JLabel("Create your map!");
        description.setFont(new Font("Arial", Font.PLAIN, 25));
        header.add(description);
        
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel buttonPanel3 = new JPanel();

        JButton start = new JButton("Set Start");
        JButton goal = new JButton("Set Goal");
        JButton finish = new JButton("Finish");
        finish.setPreferredSize(new Dimension(210, 40));
        buttonPanel2.add(finish);
        buttonPanel3.add(start);
        buttonPanel3.add(goal);
        finish.addActionListener(e -> {
            if (!this.hasGoal) {
                description.setText("Please set a goal block");
                description.setForeground(Color.RED);
            } else if (!this.hasStart) {
                description.setText("Please set a start block");
                description.setForeground(Color.RED);
            } else {
                filledCoords.remove(startCoord);
                filledCoords.remove(goalCoord);
                this.parentFrame.switchLevelBuilderToGame();
            }
            
        });
        start.addActionListener(e -> {
            this.setCurColor(4);
        });
        goal.addActionListener(e -> {
            this.setCurColor(5);
        });

        // Create a main panel to hold both button panels
        JPanel secondaryPanel = new JPanel();
        secondaryPanel.setLayout(new BorderLayout());
        secondaryPanel.add(buttonPanel2, BorderLayout.EAST);
        secondaryPanel.add(buttonPanel3, BorderLayout.WEST);


        JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setLayout(new BorderLayout());
        mainButtonPanel.add(buttonPanel1, BorderLayout.NORTH);
        mainButtonPanel.add(secondaryPanel, BorderLayout.SOUTH);

        // Set up the main layout with BorderLayout
        compiler.setLayout(new BorderLayout());
        compiler.add(this, BorderLayout.CENTER);
        compiler.add(mainButtonPanel, BorderLayout.SOUTH);
        compiler.add(header, BorderLayout.NORTH);

        return compiler;

    }

}
