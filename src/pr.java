import java.awt.*;
import javax.swing.*;

public class pr {

    public static JFrame frame1;

    public static void main(String[] args) {
        // Create the frame
        frame1 = new JFrame("WELCOME");
        frame1.setSize(500, 500);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null); // Center the frame on screen

        // Create the welcome label
        JLabel label1 = new JLabel("Welcome");
        label1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);

        // Load and scale the image for the background
        ImageIcon wicon = new ImageIcon("welcome.jpg");
        Image icon1 = wicon.getImage();
        Image resize = icon1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);  // Scaling the image to fit the frame
        wicon = new ImageIcon(resize);

        // Create a label for the image
        JLabel label2 = new JLabel();
        label2.setIcon(wicon);

        // Using a layered pane to position components
        JLayeredPane layer1 = new JLayeredPane();
        layer1.setLayout(new OverlayLayout(layer1)); // Use OverlayLayout to layer components

        // Add components to the layered pane
        layer1.add(label2, Integer.valueOf(1));  // Background image
        layer1.add(label1, Integer.valueOf(2));  // Welcome text on top

        // Add the layered pane to the frame
        frame1.add(layer1);
        frame1.setVisible(true);  // Make the frame visible
    }
}
