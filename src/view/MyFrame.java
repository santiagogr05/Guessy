
package view;
import java.awt.Color;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    
    public MyFrame(int bound_x, int bound_y,int width, int height, String tittle){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.setBounds(bound_x, bound_y, width, height);
        
        this.setSize(width, height);
        this.setTitle(tittle);
        
        
        
        
    }
    
}
