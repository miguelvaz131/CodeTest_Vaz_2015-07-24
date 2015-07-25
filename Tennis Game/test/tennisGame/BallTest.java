/**
 * 
 */
package tennisGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author Miguel
 *
 * Class to test the ball specific logic oriented to test driven development
 */
public class BallTest {

	@BeforeClass
	public static void setUpBeforeClass()  {
	}


	@Before
	public void setUp() {
	}

	/**
	 * 
	 * Test the moving of the ball
	 */
	@Test
	public void testMoveOfTheBall() {
		
		//init the ball class
		Ball ball = new Ball();
		
		//Get the initial position
		float[] startPosition = ball.getPosition();
		
		//Increase the ball speed to move it
		ball.updateSpeed(11, 12);
		
		//Make the move
		ball.move();
		
		//Get the finish position
		float[] endPosition = ball.getPosition();
		
		//Test if the difference between the start position and the end position is equal to the speed
		float diff[] = new float[2];
		diff[0] = endPosition[0] - startPosition[0];
		diff[1] = endPosition[1] - startPosition[1];
		
		assertEquals("bad ball move", 11, diff[0], 1e-5);
		assertEquals("bad ball move", 12, diff[1], 1e-5);

	}


	
}
