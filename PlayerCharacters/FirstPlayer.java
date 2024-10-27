package PlayerCharacters;

import Panels.Game;
import java.awt.Color;

/**
 * First player class. Is-a BoxPeople, sets a pink player character for 
 * both single player and multiplayer.
 */
public class FirstPlayer extends BoxPeople {

    /**
     * Constructor for FirstPlayer that inherits from BoxPeople.
     * @param x - initial x coordinate.
     * @param y - initial y coordinate
     * @param panel - the game panel where the player is instantiated
     */
    public FirstPlayer(int x, int y, Game panel) {
        super(x, y, panel);
        this.color = new Color(255, 0, 118);
    }
    
}
