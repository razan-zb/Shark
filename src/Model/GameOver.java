package Model;

import Controller.PacmanActor;
import Controller.PacmanGame;
import Utils.State;

/**
 * @author dzimiks
 */
public class GameOver extends PacmanActor {

	public GameOver(PacmanGame game) {
        super(game);
    }

    @Override
    public void init() {
        x = 77;
        y = 160;
        loadFrames("/res/gameover.png");
    }
    


	@Override
    public void updateGameOver() {
        yield:
        while (true) {
            switch (instructionPointer) {
                case 0:
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 1;
                case 1:
                    if (System.currentTimeMillis() - waitTime < 3000) 
                        break yield;
                    
                    game.returnToTitle();
                    break yield;
            }
            
        }
    }
    
  @Override
    public void stateChanged() {
        visible = false;
        
        if (game.state == State.GAME_OVER) {
            visible = true;
            instructionPointer = 0;
        }
    }
    
	
  
}