package Walls;

import java.awt.Color;

/**
 * The StartWall class is-a GameWall.
 * Creates the start block which the user will start at
 */
public class StartWall extends GameWall {

    /**
     * The StartWall constructor which inherits from the GameWall.
     * @param x x position of the block
     * @param y y position of the block
     * @param width width of the block
     * @param height height of the block
     */
    public StartWall(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color = new Color(237, 99, 44); 
    }

    
}
