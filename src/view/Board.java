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


public class Board implements ActionListener {
    
    Player player;
    int[] nums;
    MyFrame frame;
    TextField[][] textFieldsNums;
    TextField[][] textFieldsHints;
    JButton[][] keyboardButtons;
    JButton reset;
    JButton back;
    JButton send;
    
    public Board(Player player, int[] nums){
        
        this.nums = nums;
        this.player = player;
        this.frame = new MyFrame(0, 0 , 700, 800, "GUESSY");
        this.frame.setLocationRelativeTo(null);
        
        JPanel redpanel = new JPanel(new GridLayout(12, 4, 50, 10));
        redpanel.setBackground(Color.LIGHT_GRAY);
        redpanel.setBounds(20, 10, 400, 540);
        redpanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        redpanel.setLayout(null);
        
        JLabel label = new JLabel();
        label.setText("Jugador: " + player.getUsername());
        label.setBounds(45, 0, 200, 15);
        
        JPanel matrix = new JPanel(new GridLayout(12, 4, 40, 10));
        matrix.setBackground(Color.LIGHT_GRAY);
        matrix.setBounds(50, 20, 300, 500);
                                
        this.textFieldsNums = new TextField[12][4];
        
         for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4; j++) {
                TextField textField = new TextField();
                textField.setEditable(false); 
                textField.setFocusable(false); 
                textField.setBackground(Color.LIGHT_GRAY.brighter());             
                this.textFieldsNums[i][j] = textField;
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
        
        this.textFieldsHints = new TextField[12][2];
        
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
                this.textFieldsHints[i][j] = textField;
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
        
        this.keyboardButtons = new JButton[3][3];
        
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.setFocusable(false);
            button.setBorder(BorderFactory.createEmptyBorder());
            button.addActionListener(this::ButtonActionPerformed);
            this.keyboardButtons[(i - 1) / 3][(i - 1) % 3] = button; 
            keyboard.add(button); 
        }
        
        JPanel comms = new JPanel();
        comms.setBackground(Color.RED);
        comms.setBounds(420, 10, 150, 150);
        comms.setLayout(null);
        
        this.send = new JButton();
        this.send.setText("OK");
        this.send.setBounds(0, 0, 150, 100);
        this.send.setFocusable(false);
        this.send.setFont(new Font("Arial", Font.BOLD, 20));
        this.send.setEnabled(false);        
        this.send.addActionListener(this);

        this.back = new JButton();
        this.back.setText("←");
        this.back.setBounds(0, 100, 75, 50);
        this.back.setFocusable(false);
        this.back.setFont(new Font("Arial", Font.BOLD, 30));
        this.back.addActionListener(this);
        
        this.reset = new JButton();
        this.reset.setText("Reset");
        this.reset.setBounds(75, 100, 75, 50);
        this.reset.setFocusable(false);
        this.reset.setFont(new Font("Arial", Font.BOLD, 13));
        this.reset.addActionListener(this);
    
       
        
        this.frame.add(redpanel);
        this.frame.add(bluepanel);
        this.frame.add(greenpanel);
        
        redpanel.add(matrix);
        redpanel.add(label);
        
        bluepanel.add(hints);
        
        greenpanel.add(keyboard);
        greenpanel.add(comms);
        comms.add(send);
        comms.add(back);
        comms.add(reset);
    }

    // Atributtes don't forget to put them up when your done with this :)
    int max = 0;
    int[] numIngresado = new int[4];
    int k=0;
    int fila = 0;
    JButton[] pressed = new JButton[4];
    
    public void ButtonActionPerformed(ActionEvent e) {
        
        JButton source = (JButton) e.getSource();
        send.setEnabled(false);
        
        if(max < 4){
            
            int row = -1, col = -1;
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (source == keyboardButtons[i][j]) {
                        row = i;
                        col = j;
                        this.pressed[max] = keyboardButtons[i][j];                                                                        
                        keyboardButtons[i][j].setEnabled(false);
                        break;
                    }
                }
                if (row != -1 && col != -1) {
                    break;
                }
            }

            if (row != -1 && col != -1) {
                
                int i = this.fila;
                
                for (int j = 0; j < 4; j++) {
                    if (this.textFieldsNums[i][j].getText().isEmpty()) {  
                        
                        String currentText = this.textFieldsNums[i][j].getText();
                        this.textFieldsNums[i][j].setText(currentText + "  " + source.getText());
                        this.textFieldsNums[i][j].setFont(new Font("Arial", Font.BOLD, 20));                           
                        this.numIngresado[k] = Integer.parseInt(source.getText());                            
                        this.k += 1;
                        this.max++;                        
                        if(this.max == 4){
                            this.send.setEnabled(true);
                        }
                        return;
                    }
                }
                
            }  
            
        }
        
        for(int i = 0;i < this.numIngresado.length;i++){
            System.out.print(numIngresado[i] + " ");
        }
        System.out.println("");
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Game game = new Game();
        Stats stats = new Stats(this.player);
        
        if(e.getSource() == this.reset){
            
             game.startGame(this.player);
             this.frame.dispose();
         } else if (e.getSource() == this.send){
             
             int[] result = new int[2];
             game.compareNums(this.nums, this.numIngresado, result);
             
            int i = this.fila;
            
            for(int j = 0; j < 2; j++){
               if (i < 12 && this.textFieldsHints[i][j].getText().isEmpty()){
               String currentText = this.textFieldsHints[i][j].getText();
               this.textFieldsHints[i][j].setText(currentText + "  " + result[j]);
               this.textFieldsHints[i][j].setFont(new Font("Arial", Font.BOLD, 20));
               }
            }
            
            this.max = 0;
            this.k = 0;
            resetButtons();
            this.fila++;
            this.player.incrementarIntento();
            
            if(this.fila == 12 || result[1] == 4){
                
                this.frame.dispose();
                game.gameOver(this.player);
                stats.saveStats();
            }
         } else if (e.getSource() == this.back){
             
             if (this.max > 0){
                
                this.textFieldsNums[fila][max-1].setText("");                 
                this.pressed[this.max-1].setEnabled(true);
                this.max--;
                this.k--;
                 
             }
            
         }
    }
    
    public void resetButtons(){
        for (int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j++){
                this.keyboardButtons[i][j].setEnabled(true);
            }
        }
    }
    
}
