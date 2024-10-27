package Walls;

import java.awt.Color;

/**
 * The redWall class is-a GameWall.
 * Creates the red block which cause instant death. 
 * The user will die and respawn at the Start block when they collide with these. 
 */
public class RedWall extends GameWall {

    /**
     * Constructor for the red wall which inherits from the game wall.
     * @param x x position of the block
     * @param y y position of the block
     * @param width width of the block
     * @param height height of the block
     */
    public RedWall(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color = new Color(237, 50, 46); 
    }

    
}
