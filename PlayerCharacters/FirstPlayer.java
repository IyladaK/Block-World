package PlayerCharacters;
import java.awt.Color;

import Panels.Game;

public class FirstPlayer extends BoxPeople{

    public FirstPlayer(int x, int y, Game panel) {
        super(x, y, panel);
        this.color = new Color(255, 0, 118);
    }
    
}
