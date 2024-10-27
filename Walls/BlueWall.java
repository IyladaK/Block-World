package Walls;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * The blueWall class. Is-a GameWall.
 * Creates the climable blocks for the game.
 * 
 */
public class BlueWall extends GameWall {

    /**
     * The constuctor for the blue walls which inherits from the GameWall class.
     * @param x x position of the block
     * @param y y position of the block
     * @param width width of the block
     * @param height height of the block
     */
    public BlueWall(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color = new Color(15, 158, 213);
    }

    @Override
    public void draw(Graphics2D gtd) {
        gtd.setColor(this.color);
        gtd.fillRect(x + 7, y, width - 14, height);
    }

    
}