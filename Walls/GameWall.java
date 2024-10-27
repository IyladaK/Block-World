package Walls;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The GameWall class.
 * Creates the walls and blocks in the game. 
 */
public class GameWall {
    
    int x;
    int y;
    int width;
    int height;

    Color color;

    public Rectangle hitBox;

    /**
     * The GameWall contstructor.
     * @param x x position of the wall
     * @param y y position of the wall
     * @param width width of the wall
     * @param height height of the wall
     */
    public GameWall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x, y, width, height);
        
    }

    /**
     * The method to draw the blocks as filled rectangles.
     */
    public void draw(Graphics2D gtd) {
        gtd.setColor(this.color);
        gtd.fillRect(x, y, width, height);
    }
}
