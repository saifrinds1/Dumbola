
public class Player {
	private String playerName = "";
	private boolean isEliminated = false;
	private int playerSecretNumber = 0;

	public Player() {
	}

	public String toString() {
		String tempString = "Name : " + playerName + ", Secret Number : " + playerSecretNumber + ", Eliminated : "
				+ isEliminated;
		return tempString;

	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName
	 *            the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the isEliminated
	 */
	public boolean isEliminated() {
		return isEliminated;
	}

	/**
	 * @param isEliminated
	 *            the isEliminated to set
	 */
	public void setEliminated(boolean isEliminated) {
		this.isEliminated = isEliminated;
	}

	/**
	 * @return the playerSecretNumber
	 */
	public int getPlayerSecretNumber() {
		return playerSecretNumber;
	}

	/**
	 * @param playerSecretNumber
	 *            the playerSecretNumber to set
	 */
	public void setPlayerSecretNumber(int playerSecretNumber) {
		this.playerSecretNumber = playerSecretNumber;
	}

}
