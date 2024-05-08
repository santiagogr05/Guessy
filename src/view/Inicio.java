
package view;

import businessLogic.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;


/**
 *  Displays the initial modal to start
 * 
 */
public class Inicio implements ActionListener{    
    
    MyFrame frame;
    JButton comenzar;
    JButton salir;
    JTextField textField;
    
    public Inicio(){
        
        JLabel label = new JLabel();
        label.setText("Usuario:");
        label.setBounds(70, 65, 50, 15);
        label.setForeground(Color.BLACK);
        
        textField = new JTextField();
        textField.setBounds(125, 63, 150, 20);
        textField.setBorder(BorderFactory.createEtchedBorder(0, Color.lightGray, Color.LIGHT_GRAY));
        textField.setBackground(Color.LIGHT_GRAY);
        
        comenzar = new JButton();
        comenzar.setText("Comenzar");
        comenzar.setBounds(175, 130, 100, 35);
        comenzar.addActionListener(this);
        comenzar.setFocusable(false);
        comenzar.setBorder(BorderFactory.createEmptyBorder());
        
        salir = new JButton();
        salir.setText("Salir");
        salir.setBounds(70, 130, 70, 35);
        salir.addActionListener(this);
        salir.setFocusable(false);
        salir.setBorder(BorderFactory.createEmptyBorder());
        
               
        
        frame = new MyFrame(550, 200, 450,450,"Inicio");
                
        JPanel panel = new RoundedPanel(15, 15);
        panel.setBackground(Color.GRAY);
        panel.setBounds(55, 100, 330, 200);
        panel.setLayout(null);
        
        frame.add(panel);
        panel.add(label);
        panel.add(textField);
        panel.add(this.comenzar);
        panel.add(this.salir);
        
        
       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.comenzar){
            
            String user = this.textField.getText();
            
            if(user.equals("") || user.equals(" ")){
                System.out.println("Please Type your Username!");
                
            } else {                
                Jugador jugador = new Jugador(user);
                Juego juego = new Juego();               
                juego.iniciarJuego(jugador);
                
                this.frame.dispose();
                
            }
            
            
        } else if (e.getSource()==this.salir){
                        
            this.frame.dispose();
            
        }
            
        
    }
    
    
}

class RoundedPanel extends JPanel {
    private int arcWidth;
    private int arcHeight;

    public RoundedPanel(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();
        g2d.setColor(getBackground());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arcWidth, arcHeight));
        g2d.setColor(getForeground());
        g2d.draw(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arcWidth, arcHeight));
        g2d.dispose();
    }
}
