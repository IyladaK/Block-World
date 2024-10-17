import javax.swing.JFrame;

public class GameFrame {

    public JFrame createFrame(){
        JFrame frame = new JFrame("GridWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add((new LevelBuilder()).levelBuilder());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        return frame;
    }
}
