
//Clase jugador se encargara de crear cada jugador

package businessLogic;
import java.time.LocalDate;

public class Jugador {
    private String username;
    private LocalDate fecha;
    private int contador;
    private boolean victoria;
    
    public Jugador(String username){
        this.username = username;
        this.fecha = LocalDate.now();
        this.victoria = false;
    }
    
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public int getContador(){
        return this.contador;
    }
    public void setContador(int contador){
        this.contador = contador;
    }
    
    public LocalDate getFecha(){
        return this.fecha;
    }
    
    public boolean getVictoria(){
        return this.victoria;
    }
    
    public void incrementarIntento(){
        this.contador++;
    }
    
    public void gana(){
        this.victoria = true;
    }

    @Override
    public String toString() {
        return "Jugador{" + "username: " + username + ", fecha:" + fecha + '}';
    }
    
    
}
