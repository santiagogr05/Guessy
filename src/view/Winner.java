
package view;
import businessLogic.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Winner implements ActionListener{
    
    MyFrame frame;
    JPanel panel;
    JLabel label1, label2, label3;
    JButton again, exit, stats;
    Player player;        
    
    public Winner(Player player){

        this.player = player;
        
        frame = new MyFrame(450, 450, 400, 300 , "EL GOAT");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        panel = new JPanel();
        panel.setBounds(45, 25, 300, 280);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        
        label1 = new JLabel();
        label1.setBounds(100, 5, 100, 100);
        label1.setText("Felicidades!!");
        label1.setFont(new Font("Arial", Font.BOLD, 14));
        
        label2 = new JLabel();
        label2.setBounds(10, 20, 300, 100);
        label2.setText("Eres el mas crack en 1mt a la redonda :0");
        label2.setFont(new Font("Arial", Font.BOLD, 14));
        
        label3 = new JLabel();
        label3.setBounds(105, 60, 100, 100);
        label3.setText("Intentos " + this.player.getContador());
        label3.setFont(new Font("Arial", Font.BOLD, 15));
        
        again = new JButton();
        again.setText("Jugar");
        again.setBounds(180, 150, 100, 30);
        again.setFocusable(false);
        again.setBorder(BorderFactory.createEmptyBorder());
        again.addActionListener(this);
        
        
        exit = new JButton();
        exit.setText("Salir");
        exit.setBounds(20, 150, 100, 30);
        exit.setFocusable(false);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.addActionListener(this);

        stats = new JButton();
        stats.setText("Estadisticas");
        stats.setBounds(80, 190, 120, 30);
        stats.setFocusable(false);
        stats.setBorder(BorderFactory.createEmptyBorder());
        stats.addActionListener(this);
        
        
        frame.add(panel);
        
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(again);
        panel.add(exit);
        panel.add(stats);
    }

    @Override
    public void actionPerformed(ActionEvent e) {                        
        
        Stats stats = new Stats(this.player);
        
        if(e.getSource() == this.again){
            
            this.frame.dispose();            
            Start start = new Start();
            
            
        } else if(e.getSource() == this.stats){

            stats.showStats();
            this.frame.dispose();

        } else {
            
            this.frame.dispose();

            
        }
    }
    
}
