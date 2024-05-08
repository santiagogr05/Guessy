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
import java.awt.geom.RoundRectangle2D;

public class Board implements ActionListener {
    
    Player jugador;
    MyFrame frame;
    TextField[][] textFields;
    JButton[][] keyboardButtons;
    JButton reset;
    JButton back;
    JButton send;
    
    public Board(Player jugador){
        this.jugador = jugador;
        frame = new MyFrame(0, 0 , 700, 800, "GUESSY");
        frame.setLocationRelativeTo(null);
        
        JPanel redpanel = new JPanel(new GridLayout(12, 4, 50, 10));
        redpanel.setBackground(Color.LIGHT_GRAY);
        redpanel.setBounds(20, 10, 400, 540);
        redpanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        redpanel.setLayout(null);
        
        JLabel label = new JLabel();
        label.setText("Jugador: " + jugador.getUsername());
        label.setBounds(45, 0, 100, 15);
        
        JPanel matrix = new JPanel(new GridLayout(12, 4, 40, 10));
        matrix.setBackground(Color.LIGHT_GRAY);
        matrix.setBounds(50, 20, 300, 500);
                                
        textFields = new TextField[12][4];
        
         for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4; j++) {
                TextField textField = new TextField();
                textField.setEditable(false); 
                textField.setFocusable(false); 
                textField.setBackground(Color.LIGHT_GRAY.brighter());             
                textFields[i][j] = textField;
                matrix.add(textField);
            }
        }
       
        
        JPanel bluepanel = new JPanel();
        bluepanel.setBackground(Color.LIGHT_GRAY);
        bluepanel.setBounds(430, 10, 240, 540);
        bluepanel.setLayout(null);
        
        JPanel hints = new JPanel(new GridLayout(12, 2, 20, 10));
        hints.setBackground(Color.LIGHT_GRAY);
        hints.setBounds(45, 20, 100 , 500);
        
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < 2; j++){
                TextField textField = new TextField();
                textField.setEditable(false);
                textField.setFocusable(false);
                
                if( j == 0){
                    textField.setBackground(Color.YELLOW.darker());
                } else {
                    textField.setBackground(Color.GREEN.darker());
                }
                hints.add(textField);
                
            }
        }
        
        
        JPanel greenpanel = new JPanel();
        greenpanel.setBackground(Color.LIGHT_GRAY);
        greenpanel.setBounds(20, 560, 650, 170);
        greenpanel.setLayout(null);
        
        JPanel keyboard = new JPanel(new GridLayout(3, 3, 20, 10));
        keyboard.setBackground(Color.LIGHT_GRAY);
        keyboard.setBounds(50, 10, 300, 150);
        
        keyboardButtons = new JButton[3][3];
        
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(Integer.toString(i)); // Create button with number label
            button.setFocusable(false);
            button.setBorder(BorderFactory.createEmptyBorder());
            button.addActionListener(this::ButtonActionPerformed);
            keyboardButtons[(i - 1) / 3][(i - 1) % 3] = button; 
            keyboard.add(button); 
        }
        
        JPanel comms = new JPanel();
        comms.setBackground(Color.RED);
        comms.setBounds(420, 10, 150, 150);
        comms.setLayout(null);
        
        send = new JButton();
        send.setText("OK");
        send.setBounds(0, 0, 150, 100);
        send.setFocusable(false);
        send.setFont(new Font("Arial", Font.BOLD, 20));
        send.addActionListener(this);

        back = new JButton();
        back.setText("←");
        back.setBounds(0, 100, 75, 50);
        back.setFocusable(false);
        back.setFont(new Font("Arial", Font.BOLD, 30));
        back.addActionListener(this);
        
        reset = new JButton();
        reset.setText("Reset");
        reset.setBounds(75, 100, 75, 50);
        reset.setFocusable(false);
        reset.setFont(new Font("Arial", Font.BOLD, 13));
        reset.addActionListener(this);
    
       
        
        frame.add(redpanel);
        frame.add(bluepanel);
        frame.add(greenpanel);
        
        redpanel.add(matrix);
        redpanel.add(label);
        
        bluepanel.add(hints);
        
        greenpanel.add(keyboard);
        greenpanel.add(comms);
        comms.add(send);
        comms.add(back);
        comms.add(reset);
    }

    int max = 0;
    int[] numIngresado = new int[4];
    int k=0;
    
    public void ButtonActionPerformed(ActionEvent e) {
        
        JButton source = (JButton) e.getSource();
        
        
        while(max < 4){
            
            int row = -1, col = -1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (e.getSource() == keyboardButtons[i][j]) {
                        row = i;
                        col = j;
                        keyboardButtons[i][j].setEnabled(false);
                        break;
                    }
                }
                if (row != -1 && col != -1) {
                    break;
                }
            }

            if (row != -1 && col != -1) {
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (i < 4 && textFields[i][j].getText().isEmpty()) {                            
                            String currentText = textFields[i][j].getText();
                            textFields[i][j].setText(currentText + "  " +source.getText());
                            textFields[i][j].setFont(new Font("Arial", Font.BOLD, 20));                           
                            numIngresado[k] = Integer.parseInt(source.getText());                            
                            k += 1;
                            max++;
                            return;
                        }
                    }
                }
                
            }  
            
        }
        
        for(int i=0;i<numIngresado.length;i++){
            System.out.print(numIngresado[i] + " ");
        }
        System.out.println("");
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == this.reset){
             this.frame.dispose();
             Game juego = new Game();
             juego.startGame(this.jugador);
         }
    }
    
}
