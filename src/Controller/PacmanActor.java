package Controller;

import Model.Actor;
import Controller.PacmanActor;
import Controller.PacmanGame;
import Utils.State;


/**
 * @author 
 */
public class PacmanActor extends Actor<PacmanGame> {

	public PacmanActor(PacmanGame game) {
		super(game);
	}

	@Override
    public void update() {
        switch (game.getState()) {
            case INITIALIZING: 
            	updateInitializing(); 
            	break;
            case WELCOME_MESSAGE: 
            	updateWelcomeMessage(); 
            	break;
            case TITLE: 
            	updateTitle(); 
            	break;
            case READY: 
            	updateReady();
            	break;
            case READY2: 
            	updateReady2(); 
            	break;
            case PLAYING:
            	updatePlaying(); 
            	break;
            case PACMAN_DIED: 
            	updatePacmanDied();
            	break;
            case GHOST_CATCHED: 
            	updateGhostCatched(); 
            	break;
            case LEVEL_CLEARED: 
            	updateLevelCleared(); 
            	break;
            case GAME_OVER:
            	updateGameOver();
            	break;
            case Win_Game:
            	updateWinGame();
            	break;
            case READY3:
            	updateWinGame();
            	break;
            
            	
            	
        }
    }
	
	 public void setInstructionPointer(int num) {
	    	this.instructionPointer=num;
	   }

    public void updateInitializing() {
    	
    }
    

    public void updateWelcomeMessage() {

    }

    public void updateTitle() {
    
    }

    public void updateReady() {
    
    }

    public void updateReady2() {
    
    }

    public void updatePlaying() {
    	
    }
    

    public void updatePacmanDied() {
    
    }

    public void updateGhostCatched() {
    
    }

    public void updateLevelCleared() {
    
    }

    public void updateGameOver() {
    
    }

    public void stateChanged() {
    
    }
    public void updateWinGame() {
        
    }
    
    public void updateReady3() {
        yield:
        while (true) {
            switch (instructionPointer) {
                case 1:
                    if (System.currentTimeMillis() - waitTime < 20000) // || game.sounds.get("start").isPlaying()) {
                        break yield;
                    
                    //game.setState(State.PLAYING);
                    break yield;
            }
        }

    }

    
}