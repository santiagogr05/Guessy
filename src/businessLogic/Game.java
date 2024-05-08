
package businessLogic;
import java.util.Random;
import view.*;

public class Game {
    
    public void startGame(Player jugador){
        
        // Starts the game
        
        Board tablero = new Board(jugador);
    }
    
    public void compareNums(){
        
    }
    
    public void showStats(){
        
    }    
    
    public void createNumber(int[] nums){
        
        // creates the guessing number
  
        fill(nums);
        
    }
    
    public void fill(int[] nums){
        
        // Fill an array with different numbers
        
        Random rnd = new Random();
        int len = 0;
        
        while(len < nums.length){
            
            int num = rnd.nextInt(10);
            
            if(search(nums, num)){
                nums[len] = num;
                len++;
            }
        }
        
    }
    
    public boolean search(int[] nums,int num){
        
        // search for a number into an array
        
        for(int i = 0; i < nums.length; i++){
            if(num == nums[i]){
                return false;
            }
        }
        return true;
    }
    
}
