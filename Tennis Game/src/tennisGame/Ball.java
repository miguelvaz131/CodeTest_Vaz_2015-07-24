/**
 * 
 */
package tennisGame;

/**
 * @author Miguel
 * 
 * Class representing a ball in a game
 *
 */
class Ball {


	//Current position and speed of the ball
	private float positionX;
	private float positionY;
	
	private float speedX;
	private float speedY;




	/**
	 * Set the ball position to the initial position and set the velocity to zero
	 */
	public Ball() {

		//Stop the ball (Sets the speed to 0)
		speedX = 0;
		speedY = 0;

		//Set the ball to the initial position
		positionX = 0;
		positionY = 0;	
	}


	/**
	 * Get the current position of the ball.
	 * @return position of the ball
	 */
	public float[] getPosition(){
		float[] position = new float[2];

		position[0] = positionX;
		position[1] = positionY;

		return position;
	}

	/**
	 * Set a new speed and direction for the movement of the ball 
	 * @param speedX_ speed of the ball along x
	 * @param speedY_ speed of the ball along y
	 */
	public void updateSpeed(float speedX_, float speedY_) {
		speedX = speedX_;
		speedY = speedY_;
	}

	/**
	 * Moves the ball according with its speed and position
	 */
	public void move(){

		//Moves one step
		positionX = positionX + speedX;
		positionY = positionY + speedY;

	}


}
