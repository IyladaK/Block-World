package Walls;

import java.awt.Color;

/**
 * The blackWall class. Is-a GameWall.
 * Created the border blocks for the game.
 * 
 */
public class BlackWall extends GameWall {

    /**
     * The constructor for the black wall which inherits from the GameWall class. 
     * @param x x position of the block
     * @param y y position of the block
     * @param width the width of the block
     * @param height the height of the block
     */
    public BlackWall(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color = Color.BLACK; 
    }

    
}
