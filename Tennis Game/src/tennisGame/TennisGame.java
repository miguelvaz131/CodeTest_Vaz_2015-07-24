/**
 * 
 */
package tennisGame;

import tennisGame.Player.Direction;

/**
 * @author Miguel
 * 
 * Class representing a the tennis game  
 */
class TennisGame {

	
	//Main objects  of the tennis game
	//Players
	private final Player playerA;
	private final Player playerB;
	
	//Ball
	private final Ball ball;
	
	//Score board
	private final Score score; 
	

	/**
	 * Initiates all the necessary objects and configurations for the tennis game
	 * @param playersNameA First players name
	 * @param playersNameB Second players name
	 * @param playerSpeed maximum speed of the players
	 */
	public TennisGame(String playerNameA, String playerNameB, float playerSpeed){
		
		//Setting the ball
		ball = new Ball();
		
		//Setting the players
		playerA = new PlayerHuman(playerNameA, playerSpeed);
	    playerB = new PlayerComputer(playerNameB, playerSpeed, 100)	;		
		
		//Initiates the score board
		score = new Score(playerA, playerB);
	}

	/**
	 * Main logic of the game loop 
	 */
	public void startGame() {
		
		String[] scoreDescriptions;
		int[] scores;
		
		// TODO complete game logic loop here
		
		//Get players names
		System.out.println("<" + playerA.getName() + " vs " + playerB.getName() + ">");
		
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );
		
		//The ball moves
		ball.updateSpeed(10, 10);
		ball.move();
		
		//The player moves
		playerA.move(Direction.UP);
		playerB.move(Direction.DOWN);

		
		//Add point to A
		System.out.println(playerA.getName() + " scores!");
		score.addScore(playerA);	
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );
		
		
		//Add point to A
		System.out.println(playerA.getName() + " scores!");
		score.addScore(playerA);	
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );
		
		
		//Add point to A
		System.out.println(playerA.getName() + " scores!");
		score.addScore(playerA);	
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );
		
		
		//Add point to B
		System.out.println(playerB.getName() + " scores!");
		score.addScore(playerB);	
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );
		
		
		//Add point to B
		System.out.println(playerB.getName() + " scores!");
		score.addScore(playerB);	
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );
		
		
		//Add point to B
		System.out.println(playerB.getName() + " scores!");
		score.addScore(playerB);	
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );
		
		
		//Add point to B
		System.out.println(playerB.getName() + " scores!");
		score.addScore(playerB);	
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );
		
		//Add point to A
		System.out.println(playerA.getName() + " scores!");
		score.addScore(playerA);	
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );

		//Add point to A
		System.out.println(playerA.getName() + " scores!");
		score.addScore(playerA);	
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );

		//Add point to A
		System.out.println(playerA.getName() + " scores!");
		score.addScore(playerA);	
		scores = score.getScore();
		scoreDescriptions = score.getScoreDescription();
		System.out.println(playerA.getName() + ": " + scores[0] + " (" + scoreDescriptions[0] +")" );
		System.out.println(playerB.getName() + ": " + scores[1] + " (" + scoreDescriptions[1] +")" );

		if(score.isGameOver())
			System.out.println("The game is over.");


	}
	

	
	/**
	 * @param args Main 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		
		//Load configuration
		//Playes name
		String playersNameA = "Federer";
		String playersNameB = "Murray";
		//players maximum speed
		float playersMaxSpeed = 1;											
		
		//Setting up game
		TennisGame tennisGame = new TennisGame(playersNameA, playersNameB, playersMaxSpeed);
		
		//Start game. That the best one wins!!!
		tennisGame.startGame();
		  
		
		return;
	}
	


}
