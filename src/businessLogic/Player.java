
//Clase jugador se encargara de crear cada jugador

package businessLogic;
import java.time.LocalDate;

public class Player {
    private String username;
    private LocalDate fecha;
    private int contador;
    private int id;
    private static int genId = 0;
    
    public Player(String username){
        this.username = username;
        this.fecha = LocalDate.now();
        this.contador = 0;
        this.id = Player.genId++;
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
    
    public void incrementarIntento(){
        this.contador++;
    }
    
    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Jugador{" + "username: " + this.username + ", fecha:" + this.fecha + ", ID: " + this.getId() + ", Contador: " + this.getContador() +'}';
    }
    
    
}
