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
 * Class to test the game flow logic oriented to test driven development
 *
 */
public class TennisGameTest {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test of the game flow of execution
	 */
	@Test
	public void testTennisGameFlow() {
		
		//Set the players
		Player playerA = new PlayerHuman("Player A", 10);
		Player playerB = new PlayerHuman("Player B", 10);
		
		//Set the ball
		Ball ball = new Ball();
		
		//Initiates the score board
		Score score = new Score(playerA, playerB);
		


		//The ball moves around 
		ball.updateSpeed(100, 100);
		ball.move(); //100,100
		ball.updateSpeed(50, 50);
		ball.move(); //150,150
		ball.updateSpeed(0, 0);
		ball.move(); //150,150
		float[] ballPose = ball.getPosition();
		assertEquals("bad ball move", 150, ballPose[0], 1e-5);
		assertEquals("bad ball move", 150, ballPose[1], 1e-5);
		
		//Players moves around
		playerA.move(Direction.UP); //10,0
		playerA.move(Direction.UP); //20,0
		playerA.move(Direction.UP); //30,0
		playerA.move(Direction.UP); //40,0
		float[] posePlayerA = playerA.getPosition();
		assertEquals("bad player move", 40, posePlayerA[0], 1e-5);
		assertEquals("bad player move", 0, posePlayerA[1], 1e-5);
		
		//Player A scores a point 1-0
		score.addScore(playerA);	
		//Present scores
		int[] scores = score.getScore();
		assertEquals("bad scores", 1, scores[0]);
		assertEquals("bad scores", 0, scores[1]);
		String[] scoreDescritions = score.getScoreDescription();
		assertEquals("Bad score description", "Fifteen", scoreDescritions[0]);
		assertEquals("Bad score description", "Love", scoreDescritions[1]);
		//Check if is end of the game 
		assertFalse("Bad winning detection", score.isGameOver());
		
		//Player A scores a point 2-0
		score.addScore(playerA);	
		//Present scores
		scores = score.getScore();
		assertEquals("bad scores", 2, scores[0]);
		assertEquals("bad scores", 0, scores[1]);
		scoreDescritions = score.getScoreDescription();
		assertEquals("Bad score description", "Thirty", scoreDescritions[0]);
		assertEquals("Bad score description", "Love", scoreDescritions[1]);
		//Check if is end of the game 
		assertFalse("Bad winning detection", score.isGameOver());
		
		//Player B scores a point 2-1
		score.addScore(playerB);	
		//Present scores
		scores = score.getScore();
		assertEquals("bad scores", 2, scores[0]);
		assertEquals("bad scores", 1, scores[1]);
		scoreDescritions = score.getScoreDescription();
		assertEquals("Bad score description", "Thirty", scoreDescritions[0]);
		assertEquals("Bad score description", "Fifteen", scoreDescritions[1]);
		//Check if is end of the game 
		assertFalse("Bad winning detection", score.isGameOver());		
		
		//Player B scores a point 2-2
		score.addScore(playerB);	
		//Present scores
		scores = score.getScore();
		assertEquals("bad scores", 2, scores[0]);
		assertEquals("bad scores", 2, scores[1]);
		scoreDescritions = score.getScoreDescription();
		assertEquals("Bad score description", "Thirty", scoreDescritions[0]);
		assertEquals("Bad score description", "Thirty", scoreDescritions[1]);
		//Check if is end of the game 
		assertFalse("Bad winning detection", score.isGameOver());	
		
		//Player A scores a point 3-2
		score.addScore(playerA);	
		//Present scores
		scores = score.getScore();
		assertEquals("bad scores", 3, scores[0]);
		assertEquals("bad scores", 2, scores[1]);
		scoreDescritions = score.getScoreDescription();
		assertEquals("Bad score description", "Forty", scoreDescritions[0]);
		assertEquals("Bad score description", "Thirty", scoreDescritions[1]);
		//Check if is end of the game 
		assertFalse("Bad winning detection", score.isGameOver());	
		
		//Player B scores a point 3-3
		score.addScore(playerB);	
		//Present scores
		scores = score.getScore();
		assertEquals("bad scores", 3, scores[0]);
		assertEquals("bad scores", 3, scores[1]);
		scoreDescritions = score.getScoreDescription();
		assertEquals("Bad score description", "Deuce", scoreDescritions[0]);
		assertEquals("Bad score description", "Deuce", scoreDescritions[1]);
		//Check if is end of the game 
		assertFalse("Bad winning detection", score.isGameOver());	
		
		//Player B scores a point 3-4
		score.addScore(playerB);	
		//Present scores
		scores = score.getScore();
		assertEquals("bad scores", 3, scores[0]);
		assertEquals("bad scores", 4, scores[1]);
		scoreDescritions = score.getScoreDescription();
		assertEquals("Bad score description", "", scoreDescritions[0]);
		assertEquals("Bad score description", "Advantage", scoreDescritions[1]);
		//Check if is end of the game 
		assertFalse("Bad winning detection", score.isGameOver());	
		
		//Player B scores a point 3-5
		score.addScore(playerB);	
		//Present scores
		scores = score.getScore();
		assertEquals("bad scores", 3, scores[0]);
		assertEquals("bad scores", 5, scores[1]);
		scoreDescritions = score.getScoreDescription();
		assertEquals("Bad score description", "You lose!", scoreDescritions[0]);
		assertEquals("Bad score description", "You win!", scoreDescritions[1]);
		//Check if is end of the game 
		assertTrue("Bad winning detection", score.isGameOver());
	}



}
