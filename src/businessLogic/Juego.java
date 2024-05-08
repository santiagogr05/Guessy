
package businessLogic;
import java.util.Random;
import view.*;

public class Juego {
    
    public void iniciarJuego(Jugador jugador){
        Tablero tablero = new Tablero(jugador);
    }
    
    public void compararNum(){
        
    }
    
    public void mostrarStats(){
        
    }
    
    public void limpiarCampos(){
        
    }
    
    public void crearTablero(){
        int[][] tablero = new int [13] [4];
        
    }
    
    public void crearNumero(int[] nums){
        
        // Crea nuestro numero a adivinar
  
        llenar(nums);
        
    }
    
    public void llenar(int[] nums){
        
        // Llena un array con numeros diferentes
        
        Random rnd = new Random();
        int len = 0;
        
        while(len < nums.length){
            
            int num = rnd.nextInt(10);
            
            if(buscar(nums, num)){
                nums[len] = num;
                len++;
            }
        }
        
    }
    
    public boolean buscar(int[] nums,int num){
        
        // Busca un numero dentro de un array
        
        for(int i = 0; i < nums.length; i++){
            if(num == nums[i]){
                return false;
            }
        }
        return true;
    }
    
}
