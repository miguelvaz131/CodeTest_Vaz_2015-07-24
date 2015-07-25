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
 * Class to test the score specific logic oriented to test driven development
 */
public class ScoreTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test the starting of the score and the point system
	 */
	@Test
	public void testStartScoreAndAddScoreToPlayer() {
		//initiate the players
		Player playerA = new PlayerHuman("PlayerA", 0);
		Player playerB = new PlayerHuman("PlayerB", 0);
		
		//initiate score
		Score score = new Score(playerA, playerB);
		
		//test if all playes start with 0
		int[] scores = score.getScore();
		assertEquals("Score bad initiated", 0, scores[0]);
		assertEquals("Score bad initiated", 0, scores[1]);
		
		//Add a score to player A and player B
		score.addScore(playerA);
		score.addScore(playerB);
		
		//Teste the scores after pointing
		scores = score.getScore();
		assertEquals("Bad score", 1, scores[0]);
		assertEquals("Bad score", 1, scores[1]);
		
	}
	

	/**
	 * Test the point system with the winning condition
	 */
	@Test
	public void testSeveralScoreAndWin() {
		//initiate the players
		Player playerA = new PlayerHuman("PlayerA", 0);
		Player playerB = new PlayerHuman("PlayerB", 0);
		
		//initiate score
		Score score = new Score(playerA, playerB);
		
		//test if all playes start with 0
		int[] scores = score.getScore();
		assertEquals("Score bad initiated", 0, scores[0]);
		assertEquals("Score bad initiated", 0, scores[1]);		
		
		//Test the scores after pointing
		score.addScore(playerA);  //Player A scores
		scores = score.getScore();
		assertEquals("Bad score", 1, scores[0]);
		assertEquals("Bad score", 0, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		
		score.addScore(playerA); //Player A scores
		scores = score.getScore();
		assertEquals("Bad score", 2, scores[0]);
		assertEquals("Bad score", 0, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		
		score.addScore(playerB); //Player B scores
		scores = score.getScore();
		assertEquals("Bad score", 2, scores[0]);
		assertEquals("Bad score", 1, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		
		score.addScore(playerB); //Player B scores
		scores = score.getScore(); 
		assertEquals("Bad score", 2, scores[0]);
		assertEquals("Bad score", 2, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		
		score.addScore(playerB); //Player B scores
		scores = score.getScore();
		assertEquals("Bad score", 2, scores[0]);
		assertEquals("Bad score", 3, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		
		score.addScore(playerA); //Player A scores
		scores = score.getScore();
		assertEquals("Bad score", 3, scores[0]);
		assertEquals("Bad score", 3, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		
		score.addScore(playerA); //Player A scores
		scores = score.getScore();
		assertEquals("Bad score", 4, scores[0]);
		assertEquals("Bad score", 3, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		
		score.addScore(playerA); //Player A scores
		scores = score.getScore();
		assertEquals("Bad score", 5, scores[0]);
		assertEquals("Bad score", 3, scores[1]);
		assertTrue("Bad winning detection", score.isGameOver());
		
	}

	
	/**
	 * Test the point system with the winning condition and score description
	 */
	@Test
	public void testSeveralScoreDescriptionAndWin() {
		//initiate the players
		Player playerA = new PlayerHuman("PlayerA", 0);
		Player playerB = new PlayerHuman("PlayerB", 0);
		
		//initiate score
		Score score = new Score(playerA, playerB);
		
		//test if all playes start with 0
		int[] scores = score.getScore();
		assertEquals("Score bad initiated", 0, scores[0]);
		assertEquals("Score bad initiated", 0, scores[1]);
		String[] descriptions = score.getScoreDescription();
		assertEquals("Bad score description", "Love", descriptions[0]);
		assertEquals("Bad score description", "Love", descriptions[1]);
		
		//Teste the scores after pointing
		//Player A scores; 1-0
		score.addScore(playerA);  
		scores = score.getScore();
		assertEquals("Bad score", 1, scores[0]);
		assertEquals("Bad score", 0, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		//teste descriptions
		descriptions = score.getScoreDescription();
		assertEquals("Bad score description", "Fifteen", descriptions[0]);
		assertEquals("Bad score description", "Love", descriptions[1]);
		
		//Player A scores; 2-0
		score.addScore(playerA);
		scores = score.getScore();
		assertEquals("Bad score", 2, scores[0]);
		assertEquals("Bad score", 0, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		//teste descriptions
		descriptions = score.getScoreDescription();
		assertEquals("Bad score description", "Thirty", descriptions[0]);
		assertEquals("Bad score description", "Love", descriptions[1]);
		
		//Player B scores; 2-1
		score.addScore(playerB); 
		scores = score.getScore();
		assertEquals("Bad score", 2, scores[0]);
		assertEquals("Bad score", 1, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		//teste descriptions
		descriptions = score.getScoreDescription();
		assertEquals("Bad score description", "Thirty", descriptions[0]);
		assertEquals("Bad score description", "Fifteen", descriptions[1]);
		
		//Player B scores; 2-2
		score.addScore(playerB); 
		scores = score.getScore(); 
		assertEquals("Bad score", 2, scores[0]);
		assertEquals("Bad score", 2, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		//teste descriptions
		descriptions = score.getScoreDescription();
		assertEquals("Bad score description", "Thirty", descriptions[0]);
		assertEquals("Bad score description", "Thirty", descriptions[1]);
		
		//Player B scores; 2-3
		score.addScore(playerB); 
		scores = score.getScore();
		assertEquals("Bad score", 2, scores[0]);
		assertEquals("Bad score", 3, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		//teste descriptions
		descriptions = score.getScoreDescription();
		assertEquals("Bad score description", "Thirty", descriptions[0]);
		assertEquals("Bad score description", "Forty", descriptions[1]);
		
		//Player A scores; 3-3
		score.addScore(playerA);
		scores = score.getScore();
		assertEquals("Bad score", 3, scores[0]);
		assertEquals("Bad score", 3, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		//teste descriptions
		descriptions = score.getScoreDescription();
		assertEquals("Bad score description", "Deuce", descriptions[0]);
		assertEquals("Bad score description", "Deuce", descriptions[1]);
		
		//Player A scores; 4-3
		score.addScore(playerA); 
		scores = score.getScore();
		assertEquals("Bad score", 4, scores[0]);
		assertEquals("Bad score", 3, scores[1]);
		assertFalse("Bad winning detection", score.isGameOver());
		//teste descriptions
		descriptions = score.getScoreDescription();
		assertEquals("Bad score description", "Advantage", descriptions[0]);
		assertEquals("Bad score description", "", descriptions[1]);
		
		//Player A scores; 5-3
		score.addScore(playerA);
		scores = score.getScore();
		assertEquals("Bad score", 5, scores[0]);
		assertEquals("Bad score", 3, scores[1]);
		assertTrue("Bad winning detection", score.isGameOver());
		//teste descriptions
		descriptions = score.getScoreDescription();
		assertEquals("Bad score description", "You win!", descriptions[0]);
		assertEquals("Bad score description", "You lose!", descriptions[1]);
		
	}
	
	

}
