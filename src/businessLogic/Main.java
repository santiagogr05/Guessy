
package businessLogic;
import view.*;


public class Main {
    
    public static void main(String[] args) {
//        Jugador jg = new Jugador("Santty");
//        System.out.println(jg.getFecha() + " " + jg.getUsername() + " " + jg.getContador());
//        jg.incrementarIntento();
//        System.out.println(jg.getFecha() + " " + jg.getUsername() + " " + jg.getContador());
//        
        Game juego = new Game();
        
        int[] nums = new int[4];
        juego.createNumber(nums);
        
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
        
       //Inicio inicio = new Inicio();
       
       
       Player jugador = new Player("Santty");
       Board tablero = new Board(jugador, nums);
        
        
        
        
        
        
        
        
    }
}
