import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
 * The box people class.
 */

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

    /**
     * The constructor for the box people.
     * @param x x coordinate of the position of the box person 
     * @param y y coordinate of the position of the box person
     * @param panel creates an instance of the GamePanel class 
     */
    public BoxPeople(int x, int y, GamePanel panel) {
        
        this.panel = panel;
        this.x = x;
        this.y = y;

        width = 30;
        height = 60;

        hitBox = new Rectangle(x, y, width, height);

    }

    /**
     * the set method.
     * this links key input to the movemento of the box people
     * 
     */
    public void set() {
        // Slows down the person if no keys are being pressed
        if (keyLeft && keyRight || !keyLeft && !keyRight) {
            xSpeed *= 0.6;
        } else if (keyLeft && !keyRight) {
            //moves to th left
            xSpeed--;
        } else if (keyRight && !keyLeft) {
            //moves to the right
            xSpeed++;
        }

        //stops the box person when it is moving very slowly
        if (xSpeed > 0 && xSpeed < 0.75) {
            xSpeed = 0;
        }
        if (xSpeed < 0 && xSpeed > -0.75) {
            xSpeed = 0;
        }

        // Restricts x speed to a specified range
        if (xSpeed > 5) {
            xSpeed = 5;
        }
        if (xSpeed < -5) {
            xSpeed = -5;
        }

        // Maximum value for y
        if (ySpeed > 8) {
            ySpeed = 8;
        }

        //Gravity
        ySpeed += 0.3; 

        if (keyUp) {
            //Jump only if touching ground
            boolean onGround = false;

            hitBox.y++;

            for (GameWall wall: panel.walls) {
                if (wall.hitBox.intersects(hitBox) && wall.hitBox.y > hitBox.y) {
                    onGround = true;
                    break;
                }
            }

            if (onGround) {
                ySpeed = -5;
            }
            hitBox.y--;
        }

        //Horizontal collisions, checks to see if movement will cause a collision.
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