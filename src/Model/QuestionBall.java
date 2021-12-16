package Model;

import java.awt.Rectangle;

import Controller.Main;
import Controller.PacmanActor;
import Controller.PacmanGame;
import Controller.SysData;
import Utils.DifficultyLevel;
import Utils.State;
import View.PopUpQuestion;


/**
 * 
 * @author Razan Zbedy
 *
 */
public class QuestionBall  extends PacmanActor {
	
	private int col;
    private int row;
    private boolean eated;
    private Question q;
    public static PopUpQuestion p;
    public static boolean isGo=true;
    public static boolean a=true;
    /**
     * 
     * @param game  the game
     * @param col the column of the question ball
     * @param row the row of the question ball
     * @param  q the question that the ball have
     */ 
    
    public QuestionBall(PacmanGame game, int col, int row) {
        super(game);
        this.col = col;
        this.row = row;
    }
    
    


	public static boolean isGo() {
		return isGo;
	}




	public static void setGo(boolean isGo) {
		QuestionBall.isGo = isGo;
	}




	@Override
    public void init() {
		Integer size=SysData.getInstance().getQuestionList().size();
		if(game.numQuestion==size)
			game.numQuestion=0;
    	q=(Question) SysData.getThegame().getQuestionList().values().toArray()[game.numQuestion];
    	if(q.getDifficulty()==DifficultyLevel.EASY)
    		loadFrames("/res/q1.png");
    	else if(q.getDifficulty()==DifficultyLevel.MEDIUM)
    		loadFrames("/res/intermediate_question.png");
    	else if(q.getDifficulty()==DifficultyLevel.HARD)
    		loadFrames("/res/hard_question.png");
    	game.numQuestion++;
    	
        x = col * 8 + 1 - 32;
        y = (row + 3) * 8 + 1;
        collider = new Rectangle(0, 0, 4, 4);
        eated = true;
    }

    @Override
    public void update() {
        visible = !eated && (int) (System.nanoTime() * 0.0000000075) % 2 == 0;
        
        if (eated || game.getState() == State.PACMAN_DIED) 
            return;
        
        if (game.checkCollision(this, Pacman.class) != null) {
            eated = true;
            visible = false;
            game.addScore(1);
            int c1,c2,c3,c4;
            int r1,r2,r3,r4;
            Pacman a1=null;
            Ghost a2=null;
            Ghost a3=null;
            Ghost a4=null;
            int i=0;
            for(Actor a:game.actors) {
            	
            	if(a.getClass().toString().equals("class Model.Pacman")){
            		a1=(Pacman) a;
            		a.visible=false;
            		
            	}
            	if(a.getClass().toString().equals("class Model.Ghost") ) {
            		if(i==0) {
            			a2=(Ghost) a;
            			i++;
            		}
            		else if(i==1) {
            			a3=(Ghost) a;
            			i++;
            		}
            		else if(i==2) {
            			a4=(Ghost) a;
            			i++;
            		}
            		a.visible=false;
            		
            	}
            }
         
            p=new PopUpQuestion(q,game);
            p.setVisible(true);
            int x1=a1.dx,y1=a1.dy;
            
            int dx2=a2.dx , dy2=a2.dy , a2col=a2.col , a2row=a2.row;
            int dx3=a3.dx , dy3=a3.dy , a3col=a3.col , a3row=a3.row;
            int dx4=a4.dx , dy4=a4.dy , a4col=a4.col , a4row=a4.row;
            
            System.out.println(a2.col);
           

            setGo(false);
            while(!isGo) {
            	QuestionBall.a=false;

            }
            setGo(true);
            
            a1.col=this.col;  a1.row=this.row;  a1.dx=x1;  a1.dy=y1;
            a2.dx=dx2; a2.dy=dy2; a2.col=a2col;  a2.row=a2row;
            a3.dx=dx3; a3.dy=dy3; a3.col=a3col;  a3.row=a3row;
            a4.dx=dx4; a4.dy=dy4; a4.col=a4col;  a4.row=a4row;
            
            a1.updatePosition();
            a2.updatePosition(a2col, a2row);
            a3.updatePosition(a3col, a3row);
            a4.updatePosition(a4col, a4row);
            
            System.out.println(a2.col); 
           long  waitTime1 = System.currentTimeMillis();
            while(System.currentTimeMillis() - waitTime1 < 2000) {
            	
            }
            a1.visible=true;
        	a2.visible=true;
        	a3.visible=true;
        	a4.visible=true;
            
            
            

             
            new java.util.Timer().schedule( 
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                        	Food f=new Food(game, col, row);
                        	game.actors.add(f);
                        	game.foodCount++;
                        	f.init();
                        	f.visible=true;
                        
                        }
                    }, 
                    30000 
            );
            		
            }
            	
           
            
            
            
        }
    
    
    @Override
    public void stateChanged() {
        if (game.getState() == State.TITLE ||
            game.getState() == State.LEVEL_CLEARED ||
            game.getState() == State.GAME_OVER) {
            eated = true;
        }
        else if (game.getState() == State.READY) {
            eated = false;
            visible = true;
        }
    }

    public void hideAll() {
        visible = false;
    }

}
