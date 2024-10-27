package PlayerCharacters;

import Panels.Game;
import java.awt.Color;

/**
 * SecondPlayer class, is-a BoxPeople. Used to create a purple player 
 * character, only used in dual-player mode.
 */
public class SecondPlayer extends BoxPeople {

    /**
     * Constructor for SecondPlayer class, which inherits from BoxPeople.
     * Sets color to Purple.
     * @param x - initial x coordinate.
     * @param y - initial y coordinate.
     * @param panel - game panel in which the character is instantiated.
     */
    public SecondPlayer(int x, int y, Game panel) {
        super(x, y, panel);
        this.color = new Color(90, 0, 180); 
    }
    
}
