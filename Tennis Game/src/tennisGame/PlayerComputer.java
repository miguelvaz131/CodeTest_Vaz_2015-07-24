/**
 * 
 */
package tennisGame;



/**
 * @author Miguel
 * 
 * Class representing a computer player. It extends the abstract class of a the generic Player implementation  
 */
class PlayerComputer extends Player{
	
	// difficulty of the game  
	private float difficulty;

	/**
	 * Initiate a player with the initial position and speed. 
	 * 
	 * @param name_ name of the player
	 * @param speed_ speed of the player. 
	 * @param difficulty level of intelligence of the AI player reflecting the difficulty of the game  
	 */
	public PlayerComputer(String playerName, float maxSpeed, float difficulty_) {
		super(playerName, maxSpeed);
		
		difficulty = difficulty_;
	}
	
	/**
	 * It set the best move commands according with the AI player 
	 */
	private void moveComands() {
		//TODO set an AI alg. based on difficulty
		
		//use move() super method here
	}
	


}
