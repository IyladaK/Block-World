package PlayerCharacters;

import Panels.Game; 
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


/**
 * The box people class.
 * The class which creates the Box characters, constantly updating their x and y positions using
 * the KeyChecker class to listen to player key inputs. Checks for collisions and defines the
 * interactions with different Wall objects.
 */

public class BoxPeople {

    Game panel;

    private int x;
    private int y;
    private final int INIT_X;
    private final int INIT_Y;

    int width;
    int height;

    double xSpeed;
    double ySpeed;

    Rectangle hitBox;

    Color color;

    public boolean keyLeft;
    public boolean keyRight;
    public boolean keyUp;
    public boolean keyDown;

    public boolean reachedGoal = false;


    /**
     * The constructor for the box people.
     * @param x x coordinate of the position of the box person 
     * @param y y coordinate of the position of the box person
     * @param panel creates an instance of the GamePanel class 
     */
    public BoxPeople(int x, int y, Game panel) {
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.INIT_X = x;
        this.INIT_Y = y;

        width = 30;
        height = 60;

        hitBox = new Rectangle(x, y, width, height);

    }

    /**
     * Dual Setter method for the x and y coordinates of the Box Character.
     * @param x - int x coordinate.
     * @param y - int y coordinate.
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * If the character hits a red block, they die and respawn at the start block. 
     */
    public void hitRed() {
        this.x = INIT_X;
        this.y = INIT_Y - 30;
    }


    /**
     * the set method.
     * this links key input to the movement of the box people
     * 
     */
    public void set() {

        // Slows down the person if no keys are being pressed
        if (keyLeft && keyRight || !keyLeft && !keyRight) {
            xSpeed *= 0.6;
        } else if (keyLeft && !keyRight) {
            //moves to the left
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

        // Maximum value for yspeed 
        if (ySpeed > 8) {
            ySpeed = 8;
        }

        //Gravity
        ySpeed += 0.3; 

        if (keyUp) {
            //Character should be able to jump only if it's touching the ground
            boolean onGround = false;

            hitBox.y++;

            for (Walls.GameWall wall: panel.getWalls()) {
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

        //Horizontal collisions, checks to see if movement will cause a collision
        hitBox.x += xSpeed;
        for (Walls.GameWall wall : panel.getWalls()) {
            if (hitBox.intersects(wall.hitBox)) {
                if (!(wall instanceof Walls.BlueWall)) {
                    hitBox.x -= xSpeed;
                    // moves closer while not intersecting
                    while (!wall.hitBox.intersects(hitBox)) {
                        hitBox.x += Math.signum(xSpeed);
                    }
                    hitBox.x -=  Math.signum(xSpeed);
                    //stops if intersecting
                    xSpeed = 0;
                    x = hitBox.x;

                    //color hit detection
                    if (wall instanceof Walls.RedWall) {
                        this.hitRed();
                    }

                    //Player must stand on goal block
                } 
            }
        }

        //vertical collisions
        hitBox.y += ySpeed;
        for (Walls.GameWall wall : panel.getWalls()) {
            if (hitBox.intersects(wall.hitBox)) {

                if (!(wall instanceof Walls.BlueWall)) {
                    hitBox.y -= ySpeed;

                    while (!wall.hitBox.intersects(hitBox)) {
                        hitBox.y += Math.signum(ySpeed);
                    }
                    hitBox.y -=  Math.signum(ySpeed);
                    ySpeed = 0;
                    y = hitBox.y;
                }


                //color hit detection
                if (wall instanceof Walls.RedWall) {
                    this.hitRed();
                }

                // goal block vertical collision changes booleans
                if (wall instanceof Walls.GoalWall) {
                    reachedGoal = true;
                    panel.checkReachedGoal();
                } else {
                    reachedGoal = false;
                }
            }
        }

        x += xSpeed;
        y += ySpeed;

        hitBox.x = x;
        hitBox.y = y;
         
    }

    /**
     * Draws the box person as a filled rectangle using its color, position and size.
     * @param gtd the Graphics2D context for rendering the box person.
     */
    public void draw(Graphics2D gtd) {
        gtd.setColor(this.color);
        gtd.fillRect(x, y, width, height);

    }



}