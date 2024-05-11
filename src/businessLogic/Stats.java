
package businessLogic;
import view.StatsWindow;

public class Stats {
    
    Player player;
    private static Player[] players = new Player[100];
    
    public Stats(Player player){
        this.player = player;       
    }
    
    public void showStats(){
        
        for(int i = 0; i < 100; i++){
            
            if(Stats.players[i] == null){
                break;
            } else {                
                StatsWindow statsWindow = new StatsWindow(Stats.players);
            }
        }
    }
    
    public void saveStats(){
        Stats.players[this.player.getId()] = this.player;        
    }
    
    
    
}
