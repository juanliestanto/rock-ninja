package RockNinja.model;

public class SlashTrail {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private boolean slashed;

	/**
	 * Sets the default values for the SlashTrail.
	 */
	public SlashTrail() {
		setStartPosition(0, 0);
		setEndPosition(0, 0);
	}

	/**
	 * Sets the starting x and y positions for the SlashTrail object.
	 * 
	 * @param startX
	 *            The starting x position of the Slashtrail object.
	 * @param startY
	 *            The starting y position of the Slashtrail object.
	 */
	public void setStartPosition(int startX, int startY) {
		this.startX = startX;
		this.startY = startY;
	}

	/**
	 * Sets the end x and y positions for the SlashTrail object.
	 * 
	 * @param endX
	 *            The end x position of the Slashtrail object.
	 * @param endY
	 *            The end y position of the Slashtrail object.
	 */
	public void setEndPosition(int endX, int endY) {
		this.endX = endX;
		this.endY = endY;
	}

	/**
	 * Returns if the GameObject was slashed. If the starting position equals
	 * the end position (trail length of 0) the return will always be false.
	 * 
	 * @return Slashed state of the GameObject.
	 */
	public boolean isSlashed() {
		if ((startX != endX) && (startY != endY)) {
			return slashed;
		} else {
			return false;
		}
	}

	/**
	 * Sets if the GameObject was slashed. This method is used to remember
	 * whether the GameObject has been slashed.
	 * 
	 * @param slashed
	 *            Slashed state of the GameObject.
	 */
	public void setSlashed(boolean slashed) {
		this.slashed = slashed;
	}

}
