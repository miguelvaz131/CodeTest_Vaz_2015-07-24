/**
 * 
 */
package tennisGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tennisGame.Player.Direction;


/**
 * @author Miguel
 *
 * Class to test the player specific logic oriented to a test driven development
 */
public class PlayerTest {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
	}


	/**
	 * Teste the movement of the player
	 */
	@Test
	public void testPlayerMovements() {
		//Set the Players
		Player playerA = new PlayerHuman("PlayerA", 10);
		
		float[] position = new float[2];
		
		//testing the initial position
		position = playerA.getPosition();
		assertEquals("Bad position", 0, position[0], 1e-5);
		assertEquals("Bad position", 0, position[0], 1e-5);
		
		
		//testing the moving up
		playerA.move(Direction.UP); //to 10,0
		position = playerA.getPosition();
		assertEquals("Bad position", 10, position[0], 1e-5);
		assertEquals("Bad position", 0, position[1], 1e-5);
		
		//testing the moving right
		playerA.move(Direction.RIGHT); //to 10,10
		position = playerA.getPosition();
		assertEquals("Bad position", 10, position[0], 1e-5);
		assertEquals("Bad position", 10, position[1], 1e-5);
		
		//testing the moving down
		playerA.move(Direction.DOWN); //to 0,10
		position = playerA.getPosition();
		assertEquals("Bad position", 0, position[0], 1e-5);
		assertEquals("Bad position", 10, position[1], 1e-5);
		
		//testing the moving left
		playerA.move(Direction.LEFT); //to 0,0
		position = playerA.getPosition();
		assertEquals("Bad position", 0, position[0], 1e-5);
		assertEquals("Bad position", 0, position[1], 1e-5);
		
		
		
	}


}
