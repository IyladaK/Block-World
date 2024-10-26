import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.HashMap;

public class TestFrame extends JFrame{
    Container contentPane; 
    

    public TestFrame(){
        setTitle("BloxWorld");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 687);
        setResizable(false);
        setLocationRelativeTo(null);

        contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JButton("Button 1"));
        contentPane.add(new JButton("Button 2"));
        contentPane.add(new JButton("Button 3"));

        // Remove all components after a delay
        Timer timer = new Timer(2000, e -> {
            contentPane.removeAll();  // Remove all components
            GamePanel panel = new GamePanel(new HashMap<Coord, Integer>(), new Coord(12, 12), new Coord(13, 12), false);
            panel.setPreferredSize(contentPane.getSize());  // Use contentPane's size
            panel.setBackground(Color.WHITE);

            contentPane.add(panel);  // Add panel to contentPane
            panel.setFocusable(true);  // Make panel focusable
            panel.requestFocusInWindow();
            panel.addKeyListener(new KeyChecker(panel.player));

            contentPane.revalidate(); // Revalidate layout
            contentPane.repaint(); 
        });
        timer.setRepeats(false); // Run only once
        timer.start();

        

        setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame();
    }

    
}
