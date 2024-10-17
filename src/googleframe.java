

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class googleframe extends JFrame {
    
    googleframe(){
        this.setTitle("GOOGLE FRAME");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
        this.setVisible(true);
        
    }
    
}
