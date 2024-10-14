import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class GridWindow extends JPanel {

    private static final int ROWS = 9;
    private static final int COLS = 16;
    private static final int CELL_SIZE = 60;

    public GridWindow() {
        setPreferredSize(new Dimension(COLS * CELL_SIZE, ROWS * CELL_SIZE));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(200, 200, 200)); // Set grid line color to black

        // Draw the grid
        for (int row = 0; row <= ROWS; row++) {
            g.drawLine(0, row * CELL_SIZE, COLS * CELL_SIZE, row * CELL_SIZE); // Horizontal lines
        }

        for (int col = 0; col <= COLS; col++) {
            g.drawLine(col * CELL_SIZE, 0, col * CELL_SIZE, ROWS * CELL_SIZE); // Vertical lines
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("16x10 Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the grid panel
        GridWindow gridPanel = new GridWindow();

        // Panel for the first row of buttons (Red, Blue, Black, Erase)
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new GridLayout(1, 4, 10, 10)); // 1 row, 4 columns, 10px gaps

        JButton button1 = new JButton("Black - BORDER");
        JButton button2 = new JButton("Blue - CLIMB");
        JButton button3 = new JButton("Red - DAMAGE");
        JButton button4 = new JButton("Erase");

        buttonPanel1.add(button1);
        buttonPanel1.add(button2);
        buttonPanel1.add(button3);
        buttonPanel1.add(button4);

        // Panel for the second row (Finish button, right-aligned)
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Right-align the Finish button
        JButton button5 = new JButton("Finish");
        button5.setPreferredSize(new Dimension(210, 40));
        buttonPanel2.add(button5);

        // Create a main panel to hold both button panels
        JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setLayout(new BorderLayout());
        mainButtonPanel.add(buttonPanel1, BorderLayout.NORTH);
        mainButtonPanel.add(buttonPanel2, BorderLayout.SOUTH);

        // Set up the main layout with BorderLayout
        frame.setLayout(new BorderLayout());
        frame.add(gridPanel, BorderLayout.CENTER); // Add the grid to the center
        frame.add(mainButtonPanel, BorderLayout.SOUTH); // Add the button panel to the bottom (south)

        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window
        frame.setResizable(false); // Make the window unadjustable
        frame.setVisible(true);
    }
}
