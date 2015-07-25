/**
 * 
 */
package tennisGame;

/**
 * @author Miguel
 * 
 * Class representing the score boar of the tennis game
 *
 */
class Score {


	// Player in game to be scored
	private final Player playerA; 
	private final Player playerB;
	
	//score of the players
	private int scorePlayerA; 
	private int scorePlayerB;
	
	//Score description on a tennis game
	public static enum ScoreDescription {
		LOVE ("Love"), FIFTEEN ("Fifteen"), THIRTY("Thirty"), FORTY("Forty"), DEUCE("Deuce"), ADVANTAGE("Advantage"), WIN("You win!"), LOSE("You lose!");

		private final String description;

		private ScoreDescription(String value) {			
			description = value;
		}

		// Returns the score description
		@Override
		public String toString() { return description; }
	}


	/**
	 * @param playerA player to keep track of theirs score
	 * @param playerB player to keep track of theirs score
	 */
	public Score(Player playerA_, Player playerB_) {
		
		playerA = playerA_;
		playerB = playerB_;

		// All players start with 0 score
		scorePlayerA = 0;
		scorePlayerB = 0;
	}

	/**
	 * This method check the score of each player and returns the score description of the players
	 * @return The score description of the players
	 */
	public String[] getScoreDescription(){

		String[] scoreDescriptions = new String[2];

		//Score description rules:
		//if each player has less or equal than three points but not both [“love”, “fifteen”, “thirty”, and “forty”]
		if (scorePlayerA <= 3 && scorePlayerB <= 3 && (scorePlayerA != 3 || scorePlayerB != 3)) {
			//The score description from 0 to 3 points is equal to the 0 to 3 index of the ScoreDescription enum   
			scoreDescriptions[0] = ScoreDescription.values()[scorePlayerA].toString();
			scoreDescriptions[1] = ScoreDescription.values()[scorePlayerB].toString();
			return scoreDescriptions;	
		
		//if both players have the same score [“deuce”]
		} else if (scorePlayerA == scorePlayerB) {
			scoreDescriptions[0] = ScoreDescription.DEUCE.toString();
			scoreDescriptions[1] = ScoreDescription.DEUCE.toString();
			return scoreDescriptions;
			
		//if player A is wining by one point [A “advantage”]
		} else if (scorePlayerA - scorePlayerB == 1){
			scoreDescriptions[0] = ScoreDescription.ADVANTAGE.toString();
			scoreDescriptions[1] = "";  //no special description for the player losing
			return scoreDescriptions;			
			
		//if player B is wining by one point [B “advantage”]
		} else if (scorePlayerA - scorePlayerB == -1){
			scoreDescriptions[0] = "";  //no special description for the player losing
			scoreDescriptions[1] = ScoreDescription.ADVANTAGE.toString();
			return scoreDescriptions;	
			
		//if player A is wining by two points [A win the game]
		} else if (scorePlayerA > scorePlayerB) {
			scoreDescriptions[0] = ScoreDescription.WIN.toString();
			scoreDescriptions[1] = ScoreDescription.LOSE.toString();
			return scoreDescriptions;	
			
		//if player B is wining by two points [A win the game]
		} else {
			scoreDescriptions[0] = ScoreDescription.LOSE.toString();
			scoreDescriptions[1] = ScoreDescription.WIN.toString();
			return scoreDescriptions;
		}

	}

	/**
	 * This method increases the score for the player in the input
	 * 
	 * @param player player that made a score
	 */
	public void addScore(Player player) {
		
		if (player == playerA) {
			scorePlayerA = scorePlayerA + 1;
		}else if (player == playerB) {
			scorePlayerB = scorePlayerB + 1;
		}else {
			System.out.println("Player not found.");
		}
	}

	/**
	 * Get the numeric score of the player
	 * @param player 
	 * @return the score of the player
	 */
	public int[] getScore() {
		
		int[] scores = new int[2];
		
		scores[0] = scorePlayerA;
		scores[1] = scorePlayerB;				
		
		return scores;
	}

	/**
	 * This method checks, by the game rules, if the game is finish
	 * @return true if the game is over or false otherwise
	 */
	public boolean isGameOver() {
		
		//A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
		if ( Math.abs(scorePlayerA-scorePlayerB) >= 2  && //player with a diference of 2 points
				(scorePlayerA >= 4 || scorePlayerB >= 4)) { //player with at least 4 point more
			return true;
		}
		
		return false;
	}
	

	
}
