
package businessLogic;
import java.util.Random;
import view.*;

public class Game {
    
    public void startGame(Player player){
        
        // Starts the game
        Game juego = new Game();
        
        int[] nums = new int[4];
        juego.createNumber(nums);
        
        for(int i = 0; i < nums.length; i++){///
            System.out.print(nums[i] + " ");/// Temp?
        }
        System.out.println(""); ///
        
        Board tablero = new Board(player, nums);
    }
    
    public int[] compareNums(int[] rndNum, int[] guessNum, int[] result){
        
        int counter = 0;
        int rightPos = 0;        
        
        for (int i = 0; i < guessNum.length; i++){
            boolean res = search(rndNum, guessNum[i]);
            if(!res){
                counter++;
                if(guessNum[i] == rndNum[i]){
                    rightPos++;
                }
            } 
        }
        counter -= rightPos;
        result[0] = counter;
        result[1] = rightPos;
                    
        return result;
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
