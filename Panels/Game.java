package Panels;

import Frames.MainFrame;
import HelperClasses.Coord;
import PlayerCharacters.FirstPlayer;
import PlayerCharacters.SecondPlayer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Class for Game, is-a JPanel. Creates the game environment using Walls and BoxPeople. 
 * Takes filledCoords passed down from levelBuilder and instantiates Wall Objects of 
 * the correct type in the correct coordinates.
 * Instantiates BoxPeople (one for single player and two for multiplayer) and runs the game.
 */
public class Game extends JPanel {

    MainFrame parentFrame; // MainFrame object which houses the panel
    // passed in HashMap mapping coordinates to colors (denoted by Integers)
    HashMap<Coord, Integer> filledCoords; 

    private boolean isMultiplayer;

    public FirstPlayer player;
    public SecondPlayer playerTwo;

    ArrayList<Walls.GameWall> walls = new ArrayList<>();

    private Image bg = new ImageIcon("resources/cloudBg.png").getImage();

    Coord startCoord;
    Coord goalCoord;
    final int COLS = 32;
    final int ROWS = 18;
    
    Timer gameTimer;

    /**
     * Constructor for the Game Object. Houses the gameloop run function, and creates the 
     * game environment.
     * @param filledCoords - Hashmap(Coords -> Integer) passed in from levelBuilder.
     * @param startCoord - Starting coordinate passed in from levelBuilder
     * @param goalCoord - Goal coordinate passed in from levelBuilder
     * @param isMultiplayer - Boolean of whether mulitplayer was chosen in PlayerScreen
     * @param parentFrame - MainFrame Object where the game panel is house, used to call 
     *                      switch functions
     */
    public Game(HashMap<Coord, Integer> filledCoords, Coord startCoord, Coord goalCoord, 
                boolean isMultiplayer, MainFrame parentFrame) {

        this.parentFrame = parentFrame;
        this.filledCoords = filledCoords;
        this.startCoord = startCoord;
        this.goalCoord = goalCoord;
        this.isMultiplayer = isMultiplayer;

        setPreferredSize(new Dimension(32 * 30, 18 * 30));


        player = new FirstPlayer((startCoord.x) * 30, (startCoord.y - 1) * 30, this);
        if (isMultiplayer) {
            playerTwo = new SecondPlayer(startCoord.x * 30, (startCoord.y - 1) * 30, this);
        }
        

        makeWalls();

        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {



            @Override
            public void run() {
                // TODO 
                player.set();
                if (isMultiplayer) {
                    playerTwo.set();
                }
   
                repaint();
            }
            
        }, 0, 17);
    }

    public ArrayList<Walls.GameWall> getWalls() {
        return this.walls;
    }

    public MainFrame getParentFrame() {
        return this.parentFrame; 
    }
   
    public void addRedWall(Coord key) {
        walls.add(new Walls.RedWall(key.x * 30, key.y * 30, 30, 30));
    }

    public void addBlackWall(Coord key) {
        walls.add(new Walls.BlackWall(key.x * 30, key.y * 30, 30, 30));
    }

    public void addBlueWall(Coord key) {
        walls.add(new Walls.BlueWall(key.x * 30, key.y * 30, 30, 30));
    }

    /**
     * Called when any BoxPlayer character vertically collides with the goal block.
     * Sets the position of the character away from the goal block to avoid interference,
     * resests the reachedGoal to false.
     * 
     * For multiplayer, both characters must be on the goal block at the same time.
     */
    public void checkReachedGoal() {
        if (isMultiplayer) {
            if (player.reachedGoal && playerTwo.reachedGoal) {
                player.reachedGoal = false;
                playerTwo.reachedGoal = false;

                player.setXY(startCoord.x * 30, startCoord.y * 30);
                playerTwo.setXY(startCoord.x * 30, startCoord.y * 30);

                parentFrame.switchGameToEndScreen();
            }
        } else {
            if (player.reachedGoal) {
                player.reachedGoal = false;

                player.setXY(startCoord.x * 30, startCoord.y * 30);
                
                parentFrame.switchGameToEndScreen();
            }
        }
    }

    /**
     * Creates off-screen boundaries and red blocks in the bottom void. Iterates through the passed
     * in filledCoords HashMap and adds the corresponding Walls to the walls double array used in
     * the game environment. 
     */
    public void makeWalls() {
        // setting the start and goal blocks
        walls.add(new Walls.StartWall(startCoord.x * 30, startCoord.y * 30, 30, 30));
        walls.add(new Walls.GoalWall(goalCoord.x * 30, goalCoord.y * 30, 30, 30));

        // creating off screen red layer for void death
        // creating top off-screeen black layer for window bounds
        for (int i = 0; i < 30 * this.COLS; i += 30) {
            walls.add(new Walls.RedWall(i, (ROWS + 8) * 30, 30, 30));
            walls.add(new Walls.BlackWall(i, -30, 30, 30));
        }

        //creating off screen black layer for window bounds
        for (int i = -30; i < 30 * (ROWS + 8); i += 30) {
            walls.add(new Walls.BlackWall(-30, i, 30, 30));
            walls.add(new Walls.BlackWall((COLS) * 30, i, 30, 30));
        }

    
        for (Coord key: filledCoords.keySet()) {
            switch (filledCoords.get(key)) {
                case 1:
                    walls.add(new Walls.BlackWall(key.x * 30, key.y * 30, 30, 30));
                    break;
                case 2:
                    walls.add(new Walls.BlueWall(key.x * 30, key.y * 30, 30, 30));
                    break;
                case 3:
                    walls.add(new Walls.RedWall(key.x * 30, key.y * 30, 30, 30));
                    break;
                default:
                    break;
            }
        }



    }

    @Override
    public void paint(Graphics g) {
        
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;
        gtd.drawImage(bg, 0, 0, 32 * 30, 21 * 30, this);

        player.draw(gtd);
        
        if (isMultiplayer) {
            playerTwo.draw(gtd);
        }
        
        for (Walls.GameWall wall: walls) {
            wall.draw(gtd);
        }       
    }

}
