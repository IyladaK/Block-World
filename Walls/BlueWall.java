package Walls;

import java.awt.Color;
import java.awt.Graphics2D;

public class BlueWall extends GameWall{

    public BlueWall(int x, int y, int width, int height){
        super(x, y, width, height);
        this.color = new Color(15, 158, 213);
    }

    @Override
    public void draw(Graphics2D gtd) {
        gtd.setColor(this.color);
        gtd.fillRect(x + 5, y, width - 10, height);
    }

    
}