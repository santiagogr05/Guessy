package view;

import businessLogic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class StatsWindow implements ActionListener {

    MyFrame frame;
    JPanel panel;
    JButton exit, play;
    static Player[] stats = new Player[100];

    public StatsWindow(Player[] players) {

        for(int k = 0; k < players.length; k++){
            if(StatsWindow.stats == null){
                break;
            } else {
                StatsWindow.stats[k] = players[k];
            }
        }
        

        this.frame = new MyFrame(250, 420, 760, 600, "Estadisticas");
        this.frame.setLocationRelativeTo(null);
        this.frame.setLayout(null);
        
        this.panel = new JPanel(new GridLayout(stats.length + 1, 3));
        this.panel.setBackground(Color.LIGHT_GRAY);
        this.panel.setBounds(40, 10, 720, 520);
        this.panel.setLayout(null);

        // Add headers
        JLabel username = new JLabel();
        username.setText("Jugador");
        username.setBounds(40, 20, 200, 40);
        username.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        username.setHorizontalAlignment(JLabel.CENTER);
        username.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel date = new JLabel();
        date.setText("Fecha");
        date.setBounds(240, 20, 200, 40);
        date.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        date.setHorizontalAlignment(JLabel.CENTER);
        date.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel tries = new JLabel();        
        tries.setText("Intentos");
        tries.setBounds(440, 20, 200, 40);
        tries.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tries.setHorizontalAlignment(JLabel.CENTER);
        tries.setFont(new Font("Arial", Font.BOLD, 16));

        exit = new JButton();
        exit.setText("Salir");
        exit.setBounds(20, 470, 100, 30);
        exit.setFocusable(false);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.addActionListener(this);

        play = new JButton();
        play.setText("Jugar");
        play.setBounds(570, 470, 100, 30);
        play.setFocusable(false);
        play.setBorder(BorderFactory.createEmptyBorder());
        play.addActionListener(this);
        
        // Add info users
        int height = 20;

        for(int i = 0; i < StatsWindow.stats.length; i ++){
            
            if (StatsWindow.stats[i] == null){
                break;
            } else {
                height += 40;
                for(int j = 0; j < 3; j++){

                    if(j == 0){

                        JLabel username1 = new JLabel();
                        username1.setText(StatsWindow.stats[i].getUsername());
                        username1.setBounds(40, height, 200, 40);
                        username1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                        username1.setHorizontalAlignment(JLabel.CENTER); 
                        username1.setFont(new Font("Arial", Font.BOLD, 14));
                        this.panel.add(username1);

                    } else if (j == 1){
                        JLabel date1 = new JLabel();
                        date1.setText("" + StatsWindow.stats[i].getFecha());
                        date1.setBounds(240, height, 200, 40);
                        date1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                        date1.setHorizontalAlignment(JLabel.CENTER);
                        date1.setFont(new Font("Arial", Font.BOLD, 14));
                        this.panel.add(date1);

                    } else if (j == 2){
                        JLabel tries1 = new JLabel();        
                        
                        if (StatsWindow.stats[i].getContador() == 12){
                            tries1.setText("No Adivino");
                        } else {
                            tries1.setText("" +StatsWindow.stats[i].getContador());
                        }
                        tries1.setBounds(440, height, 200, 40);
                        tries1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                        tries1.setHorizontalAlignment(JLabel.CENTER);
                        tries1.setFont(new Font("Arial", Font.BOLD, 14));
                        this.panel.add(tries1);
                    }
                }
            }
        }
        
        this.panel.add(username);
        this.panel.add(date);
        this.panel.add(tries);
        this.panel.add(exit);
        this.panel.add(play);

        Dimension panelSize = new Dimension(720, height + 40); // Adjust width as needed

        panel.setPreferredSize(panelSize);
    
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(40, 10, 720, 520);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        this.frame.add(scrollPane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.exit){
            this.frame.dispose();

        } else if(e.getSource() == this.play){

            this.frame.dispose();
            Start start = new Start();
        }

    }
}
