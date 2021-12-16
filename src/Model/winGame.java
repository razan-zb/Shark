package Model;

import Controller.PacmanActor;
import Controller.PacmanGame;
import Utils.State;

/**
 * @author razan
 */
public class winGame extends PacmanActor {

	public winGame(PacmanGame game) {
        super(game);
    }

    @Override
    public void init() {
        x = 50;
        y = 80;
        loadFrames("/res/Win.png");
    }
    


	@Override
    public void updateWinGame() {
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
        
        if (game.state == State.Win_Game) {
            visible = true;
            instructionPointer = 0;
        }
    }
    
	
  
}