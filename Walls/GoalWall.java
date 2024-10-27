package Walls;

import java.awt.Color;

/**
 * The GoalWall class is-a GameWall.
 * Creates the goal block. Once the user reaches this block the level is completed.
 */
public class GoalWall extends GameWall {

    /**
     * The constructor for the GoalWall which inherits from the GameWall.
     * @param x x position of the Goal block
     * @param y y position of the Goal block
     * @param width width of the goal block
     * @param height height of the goal block
     */
    public GoalWall(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color = new Color(71, 212, 90); 
    }

    
}
