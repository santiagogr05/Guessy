/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import businessLogic.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MSI
 */
public class Loser implements ActionListener{
    
        MyFrame frame;
    JPanel panel;
    JLabel label1, label2;
    JButton again, exit;
    Player player;
    
    public Loser(Player player){
        
        this.player = player;
        
        frame = new MyFrame(450, 450, 400, 300 , "Malardo");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        panel = new JPanel();
        panel.setBounds(45, 25, 300, 200);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        
        label1 = new JLabel();
        label1.setBounds(105, 10, 100, 100);
        label1.setText("Lastima!!");
        label1.setFont(new Font("Arial", Font.BOLD, 14));
        
        label2 = new JLabel();
        label2.setBounds(90, 30, 300, 100);
        label2.setText("Que malardo");
        label2.setFont(new Font("Arial", Font.BOLD, 14));
        
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
        
        
        frame.add(panel);
        
        panel.add(label1);
        panel.add(label2);
        panel.add(again);
        panel.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Stats stats = new Stats(this.player);
        
        if(e.getSource() == this.again){
            
            this.frame.dispose();            
            Start start = new Start();
            
            
        } else {
            
            this.frame.dispose();
            stats.showStats();
            
        }
    }
    
}
