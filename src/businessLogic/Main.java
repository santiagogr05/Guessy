
package businessLogic;
import view.*;


public class Main {
    
    public static void main(String[] args) {
//        Jugador jg = new Jugador("Santty");
//        System.out.println(jg.getFecha() + " " + jg.getUsername() + " " + jg.getContador());
//        jg.incrementarIntento();
//        System.out.println(jg.getFecha() + " " + jg.getUsername() + " " + jg.getContador());
//        
        Juego juego = new Juego();
        
        int[] nums = new int[4];
        juego.crearNumero(nums);
        
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
        
       Inicio inicio = new Inicio();
       
       
//       Jugador jugador = new Jugador("Santty");
//       Tablero tablero = new Tablero(jugador);
        
        
        
        
        
        
        
        
    }
}
