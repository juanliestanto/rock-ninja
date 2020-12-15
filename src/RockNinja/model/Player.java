package RockNinja.model;

public class Player {

	private int score;
	private int lives;

	/**
	 * Sets the default values for the player, the player always starts with 3
	 * lives and a score of 0.
	 */
	public Player() {
		score = 0;
		lives = 3;
	}

	/**
	 * Returns the player's current score.
	 * 
	 * @return Player's current score.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Adds to the player's score.
	 * 
	 * @param score
	 *            The amount to be added to the player's score.
	 */
	public void addScore(int score) {
		this.score += score;
	}

	/**
	 * Subtracts a life from the player.
	 */
	public void subtractLife() {
		lives--;
	}

	/**
	 * Returns the amount of lives the player has left.
	 * 
	 * @return The amount of lives the player has left.
	 */
	public int getLives() {
		return lives;
	}

}
