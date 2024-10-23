import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyChecker extends KeyAdapter{

    BoxPeople player;
    Boolean isPlayerOne;

    public KeyChecker (BoxPeople player) {
        this.player = player;
        if(player instanceof FirstPlayer){
            isPlayerOne = true;
        } else {
            isPlayerOne = false;
        }
        
    }

    private void keySwitch(KeyEvent e, boolean isPress){
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
