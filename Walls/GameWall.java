package Walls;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameWall{
    
    int x;
    int y;
    int width;
    int height;

    Color color;

    public Rectangle hitBox;

    public GameWall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x, y, width, height);
        
    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(this.color);
        gtd.fillRect(x, y, width, height);
    }
}
