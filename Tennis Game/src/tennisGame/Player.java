/**
 * 
 */
package tennisGame;

/**
 * @author Miguel
 * 
 * Abstract class representing a player in a game. It implements all the common methods of all types of players
 *
 */
abstract class Player {
	
	//Name of the player
	private final String name;
	
	//Speed that the play can go
	private final float speed;
		
	//Position of the player
	private float positionX;
	private float positionY; 

	//Possible direction of the player
	protected static enum Direction {
		UP, DOWN, LEFT, RIGHT; 
	}

	

	/**
	 * Iniciate a player with the initial position and speed
	 * @param name_ name of the player
	 * @param speed_ speed of the player. 
	 */
	public Player(String playerName, float maxSpeed) {
		
		//Set name
		name = playerName;
		
		//Set max speed
		speed = maxSpeed;

		//Sets the player to it initial position
		positionX = 0;
		positionY = 0; 
	}
	


	/**
	 * This method make the player move according with the direction given and it max speed.
	 * @param the direction to move the player
	 */
	public void move(Direction direction){
		
		if (direction == Direction.UP) {
			//Going up
			positionX = positionX + speed;
		} else if (direction == Direction.DOWN) {
			//Going down
			positionX = positionX - speed;
		} else if (direction == Direction.RIGHT) {
			//Going left
			positionY = positionY + speed;
		}else {
			//Going right
			positionY = positionY - speed;
		}

	}
	
	/**
	 * This method returns the present position of the player
	 * @return the position of the player
	 */
	public float[] getPosition(){
		
		float[] position = new float[2];
		
		position[0] = positionX;
		position[1] = positionY;
		
		return position;
	}
	
	
	/**
	 * Get the name of the player
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}
	

}
