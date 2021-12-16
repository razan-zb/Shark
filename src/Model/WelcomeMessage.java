package Model;

import java.awt.Graphics2D;

import Controller.PacmanActor;
import Controller.PacmanGame;
import Utils.State;

/**
 * @author dzimiks
 */
public class WelcomeMessage extends PacmanActor {

	private String text = "SHARK PRESENTS";
    private int textIndex;

    public WelcomeMessage(PacmanGame game) {
        super(game);
    }

    @Override
    public void updateWelcomeMessage() {
    	
        yield:
        while (true) {
            switch (instructionPointer) {
                case 0:
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 1;
                case 1:
                    while (System.currentTimeMillis() - waitTime < 100) 
                        break yield;
                    
                    textIndex++;
                    
                    if (textIndex < text.length()) {
                        instructionPointer = 0;
                        break yield;
                    }
                    
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 2;
                case 2:
                    while (System.currentTimeMillis() - waitTime < 3000) 
                        break yield;
                    
                    visible = false;
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 3;
                case 3:
                    while (System.currentTimeMillis() - waitTime < 1500) 
                        break yield;
                    
                    game.setState(State.TITLE);
                    break yield;
            }
        }
    }

    @Override
    public void draw(Graphics2D g) {
        if (!visible) 
            return;
        
        game.drawText(g, text.substring(0, textIndex), 50, 130);
    }

    
    @Override
    public void stateChanged() {
        visible = false;
        
        if (game.state == State.WELCOME_MESSAGE) {
            visible = true;
            textIndex = 0;
        }
    }
}