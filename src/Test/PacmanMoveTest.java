package Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Player;
import pacman.PacmanGame;
import pacman.actors.Pacman;

class PacmanMoveTest {

	@Test
	void test() {
		Controller.PacmanGame game=new Controller.PacmanGame(new Player(""));
		Model.Pacman pacman=new Model.Pacman(game);
		pacman.init();
		
		game.startGame();
		pacman.moveToTargetPosition(100, 50, 10);
		assertNotEquals((int)pacman.x,104);
		assertNotEquals((int)pacman.y,204);
	}

}
