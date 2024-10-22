import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{

    HashMap<Coord, Integer> filledCoords;
    HashMap<Integer, Runnable> wallMap;

    BoxPeople player;
    ArrayList<Walls.GameWall> walls = new ArrayList<>();

    private Image bg = new ImageIcon("resources/cloudBg.jpg").getImage();

    Coord startCoord;
    Coord goalCoord;
    final int COLS = 32;
    final int ROWS = 18;
    
    Timer gameTimer;

    public GamePanel(HashMap<Coord, Integer> filledCoords, Coord startCoord, Coord goalCoord) {
        this.filledCoords = filledCoords;
        this.startCoord = startCoord;
        this.goalCoord = goalCoord;

        player = new BoxPeople(startCoord.x * 30, (startCoord.y - 1) * 30, this);

        makeWalls();

        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {



            @Override
            public void run() {
                // TODO 
                player.set();
                repaint();

                
            }
            
        },0, 17 );


    }

    public void addRedWall(Coord key) {
        walls.add(new Walls.RedWall(key.x * 30, key.y * 30, 30, 30));
    }

    public void addBlackWall(Coord key) {
        walls.add(new Walls.BlackWall(key.x * 30, key.y * 30, 30, 30));
    }

    public void addBlueWall(Coord key) {
        walls.add(new Walls.BlueWall(key.x * 30, key.y * 30, 30, 30));
    }



    public void makeWalls() {
        // setting the start and goal blocks
        walls.add(new Walls.StartWall(startCoord.x * 30, startCoord.y * 30, 30, 30));
        walls.add(new Walls.GoalWall(goalCoord.x * 30, goalCoord.y * 30, 30, 30));

        // creating off screen red layer for void death
        // creating top off-screeen black layer for window bounds
        for (int i = 0; i < 30 * this.COLS; i += 30) {
            walls.add(new Walls.RedWall(i, (ROWS + 8) * 30, 30, 30));
            walls.add(new Walls.BlackWall(i, -30, 30, 30));
        }

        //creating off screen black layer for window bounds
        for (int i = -30; i < 30 * (ROWS + 8); i += 30) {
            walls.add(new Walls.BlackWall(-30, i, 30, 30));
            walls.add(new Walls.BlackWall((COLS) * 30, i, 30, 30));
        }

    
        for (Coord key: filledCoords.keySet()) {
            switch (filledCoords.get(key)) {
                case 1:
                    walls.add(new Walls.BlackWall(key.x * 30, key.y * 30, 30, 30));
                    break;
                case 2:
                    walls.add(new Walls.BlueWall(key.x * 30, key.y * 30, 30, 30));
                    break;
                case 3:
                    walls.add(new Walls.RedWall(key.x * 30, key.y * 30, 30, 30));
                    break;
                default:
                    break;
            }
        }



    }

    public void paint(Graphics g) {
        
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;
        gtd.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);

        player.draw(gtd);

        for(Walls.GameWall wall: walls){
            wall.draw(gtd);
        }       
    }




    
    /**
     * .
     * @param e - .
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            player.keyLeft = true;
        } 
        if (e.getKeyChar() == 'w') {
            player.keyUp = true;
        } 
        if (e.getKeyChar() == 's') {
            player.keyDown = true;
        } 
        if (e.getKeyChar() == 'd') {
            player.keyRight = true;
        }
    }

    /**
     * method for key release.
     * @param e method 
     */
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            player.keyLeft = false;
        } 
        if (e.getKeyChar() == 'w') {
            player.keyUp = false;
        } 
        if (e.getKeyChar() == 's') {
            player.keyDown = false;
        } 
        if (e.getKeyChar() == 'd') {
            player.keyRight = false;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
       
    }

    
}
