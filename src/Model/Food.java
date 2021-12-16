package Model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Controller.PacmanActor;
import Controller.PacmanGame;
import Utils.State;

/**
 * @author dzimiks
 */
public class Food extends PacmanActor {

	private int col;
    private int row;
    
    public Food(PacmanGame game, int col, int row) {
        super(game);
        this.col = col;
        this.row = row;
    }
    
    

    public int getCol() {
		return col;
	}



	public int getRow() {
		return row;
	}



	public void setCol(int col) {
		this.col = col;
	}



	public void setRow(int row) {
		this.row = row;
	}



	@Override
    public void init() {
        loadFrames("/res/food.png");
        x = col * 8 + 3 - 32;
        y = (row + 3) * 8 + 3;
        collider = new Rectangle(0, 0, 2, 2);
    }

    @Override
    public void updatePlaying() {
//        // for debug purpose A key clear level
//        if (Keyboard.keyPressed[KeyEvent.VK_A]) 
//            game.currentFoodCount = 0;
        
        if (game.checkCollision(this, Pacman.class) != null) {
            visible = false;
            game.currentFoodCount--;
            game.addScore(1);
            //System.out.println("Current food count: " + game.currentFoodCount);
            
            new java.util.Timer().schedule( 
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                        	visible = true;
                        }
                    }, 
                    30000 
            );
            
        }
    }
    


    @Override
    public void draw(Graphics2D g) {
    	if (!visible) 
            return;
        
        g.setColor(Color.WHITE);
        g.fillRect((int) (x), (int) (y), 2, 2);
    }
    
    @Override
    public void stateChanged() {
        if (game.getState() == State.TITLE ||game.getState() == State.Win_Game) 
            visible = false;
        else if (game.getState() == State.READY) 
            visible = true;
    }

    public void hideAll() {
        visible = false;
    }
    

}