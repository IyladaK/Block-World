package PlayerCharacters;
import java.awt.Color;

import Panels.Game;

public class SecondPlayer extends BoxPeople{

    public SecondPlayer(int x, int y, Game panel){
        super(x, y, panel);
        this.color = new Color(90, 0, 180); 
    }
    
}
