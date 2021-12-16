package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Player;
import pacman.PacmanActor;
import pacman.PacmanGame;
import pacman.actors.GameOver;
import pacman.actors.Ghost;
import pacman.actors.Pacman;

class ScoreTest {

	@Test
	void test() {
		Controller.PacmanGame game=new Controller.PacmanGame(new Player(""));
		game.score=100;
		game.lives=1;
		game.ghostCatched(new Model.Ghost(game, new Model.Pacman(game), 0));
		game.nextLife();
		Model.GameOver gOver=new Model.GameOver(game);
		gOver.setInstructionPointer(1);
		gOver.updateGameOver();
		assertEquals(game.score,0);
	}

}
