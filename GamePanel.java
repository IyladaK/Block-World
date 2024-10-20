import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{

    HashMap<Coord, Integer> filledCoords;
    BoxPeople player;
    ArrayList<GameWall> walls = new ArrayList<>();
    
    Timer gameTimer;

    public GamePanel(HashMap<Coord, Integer> filledCoords) {
        this.filledCoords = filledCoords;

        player = new BoxPeople(400, 300, this);

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

    public void makeWalls() {
    
        for(Coord key: filledCoords.keySet()){
            walls.add(new GameWall(key.x * 30, key.y * 30, 30, 30));
        }


    }

    public void paint(Graphics g) {
        
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);

        for( GameWall wall: walls) wall.draw(gtd);
        
        
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
