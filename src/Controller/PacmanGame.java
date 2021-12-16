package Controller;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.Random;

import Model.Game;
import Utils.State;
import Model.Ghost;
import Model.Pacman;
import Model.Player;
import Model.PowerBall;
import Model.QuestionBall;
import Model.Point;
import Model.Actor;
import Model.Ready;
import Model.HUD;
import Model.GameOver;
import Model.WelcomeMessage;
import Model.Title;
import Model.Background;
import Model.Food;
import Model.Initializer;
import Model.winGame;



/**
 * @author 
 */
public class PacmanGame extends Game {


	// maze[row][col] 
    // 36 x 31 
    // cols: 0-3 | 4-31 | 32-35
    public int maze[][] = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 0, 0, 0, 0, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 3, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 3, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    
    public static State state = State.INITIALIZING;
    public int lives = 3;
    public int score;
    public int highscore;
    
    public Player p;
    public int level=1;
    public int numQuestion=0;
    static Pacman pacman;
    static Ghost g1;
    static Ghost g2;
    static Ghost g3;
    
    
    public Ghost catchedGhost;
    public int currentCatchedGhostScoreTableIndex = 0;
    public final int[] catchedGhostScoreTable = {200, 400, 800, 1600};
    public int foodCount;
    public int currentFoodCount;
    
    public PacmanGame(Player p) {
    	this.p=p;
        screenSize = new Dimension(224, 288);
        screenScale = new Point2D.Double(2, 2);
    }

   

	public static State getState() {
        return state;
    }

    public void setState(State state) {
        if (this.state != state) {
            this.state = state;
            broadcastMessage("stateChanged");
        }
    }
    
    
    /**
     * 
     * @param point the point that well be added to the final score
     */
    public void addScore(int point) {
        score += point;
        if(score<0)
        	score=0;
        //to change the player score
        if(score==50)
        	level=2;
        else if(score==100)
        	level=3;
        else if(score==150)
        	level=4;
        p.setScore(score);
        if(score>199) {
        	broadcastMessage("hideAll");
        	isLevelCleared();
        	setState(State.Win_Game);
        	broadcastMessage("updateLevelCleared");
            
        }

        try {
			Main.saveDB();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (score > highscore) 
        	highscore = score;
    }
    
    public String getScore() {
        String scoreStr = "0000000" + score;
        scoreStr = scoreStr.substring(scoreStr.length() - 7, scoreStr.length());
        return scoreStr;
    }

    public String getHiscore() {
        String hiscoreStr = "0000000" + highscore;
        hiscoreStr = hiscoreStr.substring(hiscoreStr.length() - 7, hiscoreStr.length());
        return hiscoreStr;
    }
    
    public String getLevel() {
        String levelS = "0" + level;
        levelS = levelS.substring(levelS.length() - 1, levelS.length());
        return levelS;
    }
    
    @Override
    public void init() {
        addAllObjs();
        initAllObjs();
    }
    
    /**
     * to add all the objects to the game
     */
    private void addAllObjs() {
    	
         pacman = new Pacman(this);
        actors.add(new Initializer(this));
        actors.add(new WelcomeMessage(this));
        actors.add(new Title(this));
        actors.add(new Background(this));
        foodCount = 0;
        
        creat_ballQuaetion();
        creat_ballQuaetion();
        creat_ballQuaetion();

        for (int row = 0; row < 31; row++) {
            for (int col = 0; col < 36; col++) {
                if (maze[row][col] == 1) 
                    maze[row][col] = -1; // wall convert to -1 for ShortestPathFinder
                
                else if (maze[row][col] == 2) {
                    maze[row][col] = 0;
                    actors.add(new Food(this, col, row));
                    foodCount++;
                }
                else if (maze[row][col] == 3) {
                    maze[row][col] = 0;
                    actors.add(new PowerBall(this, col, row));
                }

            }
        } 
        
        // max: 3
        for (int i = 0; i < 3; i++) 
            actors.add(new Ghost(this, pacman, i));
        
        actors.add(pacman);
        actors.add(new Point(this, pacman));
        actors.add(new Ready(this));
        actors.add(new GameOver(this));
        actors.add(new winGame(this));
        actors.add(new HUD(this));
    }
    
    public void creat_ballQuaetion(){
    	Random rand = new Random();
        boolean flag=true;
        while(flag) {
        	int rand_int1 = rand.nextInt(31);
            int rand_int2 = rand.nextInt(36);
            if( maze[rand_int1][rand_int2]== 2) {
            	maze[rand_int1][rand_int2] = 0;
                actors.add(new QuestionBall(this, rand_int2, rand_int1));
                flag=false;
            	
            }
        	
        }
    	
    }
    

    //test black box 1
    public boolean check_one_pacman_three_ghosts() {
    	int numPacman=0;
    	int numGhost=0;
    	for (Actor actor : actors) {
    		if(actor.getClass().toString().equals("class Model.Pacman"))
    			numPacman++;
    		else if(actor.getClass().toString().equals("class Model.Ghost"))
    			numGhost++;
    	}
    	if(numPacman==1 && numGhost==3)
    		return true;
    	else return false;
   
    		
    }
    
    //test black box 2
    public boolean chek_level() {
    	boolean flage=false;
    	if(score>-1 && score<51 &&level==1)
    		flage=true;
    	if(score>49 && score<101 &&level==2)
    		flage=true;
    	if(score>99 && score<151 &&level==3)
    		flage=true;
    	if(score>150 && level==4)
    		flage=true;
    	return flage;
    	
    }
    
  //test black box 10
    public boolean can_eat_dot(Pacman p,Food f)
    {
    	if(p.col-1==f.getCol() && p.row==f.getRow())
    		return true;
    	if(p.col+1==f.getCol() && p.row==f.getRow())
    		return true;
    	if(p.col==f.getCol() && p.row-1==f.getRow())
    		return true;
    	if(p.col==f.getCol() && p.row+1==f.getRow())
    		return true;
    	return false;
    }
    
    private void initAllObjs() {
        for (Actor actor : actors) 
            actor.init();
        System.out.println(check_one_pacman_three_ghosts()+" "+"There is one pacman and three ghosts");

    }
    
    public void restoreCurrentFoodCount() {
        currentFoodCount = foodCount;
    }

    public boolean isLevelCleared() {
        return currentFoodCount == 0;
    }
    
    public void startGame() {
        setState(State.READY);
    }
    
    public void startGhostVulnerableMode() {
        currentCatchedGhostScoreTableIndex = 0;
        broadcastMessage("startGhostVulnerableMode");
    }
    
    public void ghostCatched(Ghost ghost) {
        catchedGhost = ghost;
        setState(State.GHOST_CATCHED);
    }
    
    public void nextLife() {
        lives--;
        
        if (lives == 0) 
            setState(State.GAME_OVER);
        else 
            setState(State.READY2);
    }

    public void levelCleared() {
        setState(State.LEVEL_CLEARED);
    }

    public void nextLevel() {
        setState(State.READY);
    }

    public void returnToTitle() {
        lives = 3;
        score = 0;
        setState(State.TITLE);
    }
  
}