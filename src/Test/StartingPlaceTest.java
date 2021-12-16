package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.PacmanGame;
import pacman.actors.Pacman;
import pacman.actors.Point;

class StartingPlaceTest {

	@Test
	void test() {
		PacmanGame game = new PacmanGame();
        Pacman pacman=new Pacman(game);
        pacman.init();
		assertEquals((int)pacman.x,104);
		assertEquals((int)pacman.y,204);
	}

}
