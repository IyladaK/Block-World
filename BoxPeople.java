import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BoxPeople {

    GamePanel panel;

    int x;
    int y;
    int width;
    int height;

    double xSpeed;
    double ySpeed;

    Rectangle hitBox;

    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;

    public BoxPeople(int x, int y, GamePanel panel) {
        
        this.panel = panel;
        this.x = x;
        this.y = y;

        width = 30;
        height = 60;

        hitBox = new Rectangle(x, y, width, height);

    }

    public void set() {

        if (keyLeft && keyRight || !keyLeft && !keyRight) {
            xSpeed *= 0.8;
        } else if (keyLeft && !keyRight) {
            xSpeed--;
        } else if (keyRight && !keyLeft) {
            xSpeed++;
        }

        if (xSpeed > 0 && xSpeed < 0.75) {
            xSpeed = 0;
        }
        if (xSpeed < 0 && xSpeed > -0.75) {
            xSpeed = 0;
        }

        if (xSpeed > 7) {
            xSpeed = 7;
        }

        if (xSpeed < -7) {
            xSpeed = -7;
        }

        if (keyUp) {
            //Check if touching ground
            hitBox.y++;

            for (GameWall wall: panel.walls) {

                if (wall.hitBox.intersects(hitBox)) {
                    ySpeed = -6;
                }
                hitBox.y--;

            }

        }

        ySpeed += 0.3;

        //horizontal collisions 
        hitBox.x += xSpeed;
        for (GameWall wall : panel.walls) {
            if (hitBox.intersects(wall.hitBox)) {
                hitBox.x -= xSpeed;
                while (!wall.hitBox.intersects(hitBox)) {
                    hitBox.x += Math.signum(xSpeed);
                }
                hitBox.x -=  Math.signum(xSpeed);
                xSpeed = 0;
                x = hitBox.x;
            }
        }

        //vertical collisions

        hitBox.y += ySpeed;
        for (GameWall wall : panel.walls) {
            if (hitBox.intersects(wall.hitBox)) {
                hitBox.y -= ySpeed;
                while (!wall.hitBox.intersects(hitBox)) {
                    hitBox.y += Math.signum(ySpeed);
                }
                hitBox.y -=  Math.signum(ySpeed);
                ySpeed = 0;
                y = hitBox.y;
            }
        }

        x += xSpeed;
        y += ySpeed;

        hitBox.x = x;
        hitBox.y = y;
         
    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.PINK);
        gtd.fillRect(x, y, width, height);

    }



}