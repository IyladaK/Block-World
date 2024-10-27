package HelperClasses;

import PlayerCharacters.BoxPeople;
import PlayerCharacters.FirstPlayer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The keyChecker class is-a keyAdapter.
 * Handles key input for player movement
 * Differentiates between player one which used WASD keys 
 * and player two which uses arrow keys 
 * 
 */
public class KeyChecker extends KeyAdapter {

    BoxPeople player;
    Boolean isPlayerOne;

    /**
     * KeyChecker contructor. 

     * 
     * @param player an instance of the box people class representing the player
     *               determines which control scheme to use.
     */
    public KeyChecker(BoxPeople player) {
        this.player = player;
        if (player instanceof FirstPlayer) {
            isPlayerOne = true;
        } else {
            isPlayerOne = false;
        }
        
    }

    /**
     * The key switch method.
     * @param e the keyEvent representing the key action
     * @param isPress a boolean indicating wether a key is pressed (true) or released (false)
     */
    private void keySwitch(KeyEvent e, boolean isPress) {
        if (isPlayerOne) {
            switch (e.getKeyChar()) {
                case 'w':
                    player.keyUp = isPress;
                    break;
                case 'a':
                    player.keyLeft = isPress;
                    break;
                case 'd':
                    player.keyRight = isPress;
                    break;
                default:
                    break;
            }
        } else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    player.keyUp = isPress;
                    break;
                case KeyEvent.VK_RIGHT:
                    player.keyRight = isPress;
                    break;
                case KeyEvent.VK_LEFT:
                    player.keyLeft = isPress;
                    break;
                default:
                    break;
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keySwitch(e, true);
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        keySwitch(e, false);
        
    }


}
