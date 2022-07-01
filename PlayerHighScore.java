/**
 * @author Arash
 *
 *         Write a program that manages a list of up to 10 players and their
 *         high scores in the computer’s memory. Use two arrays to manage the
 *         list. One array should store the player’s name and the other array
 *         should store the player’s high score. Use the index of the arrays to
 *         correlate the name with the score. In the next Programming Project,
 *         we ask you to do the same thing, but using an array of a class. Your
 *         program should start with zero players in the list and support the
 *         following features:
 *
 *         a. Add a new player and score. If it is one of the top 10 scores then
 *         add it to the list of scores. The same name and score can appear
 *         multiple times. For example, if Bill played 3 times and scored
 *         100,100, and 99, and Bob played once and scored 50, then the top
 *         scores would be Bill 100, Bill 100, Bill 99, Bob 50.
 *
 *         b. Print the top 10 names and scores to the screen sorted by score
 *         (highest at the top).
 *
 *         c. Allow the user to enter a player name and output that player’s
 *         highest score if it is on the top 10 list or a message if the
 *         player’s name has not been input or is not in the top 10.
 *
 *         d. Allow the user to enter a player name and remove the highest score
 *         for that player from the list.
 *
 *         Create a menu system that allows the user to select which option to
 *         invoke.
 */
public class PlayerHighScore {

	// instance variables
	private String[] players;
	private double[] scores;
	private int numberOfPlayers;

	// default constructor
	public PlayerHighScore() {
		players = new String[10];
		scores = new double[10];
		numberOfPlayers = 0;
	}

	// overloaded constructor
	public PlayerHighScore(int index) {
		players = new String[index];
		scores = new double[index];
		numberOfPlayers = 0;
	}

	/**
	 * Sorts the scores by decending order
	 */
	public void sortPlayer() {
		double tempScore;
		String tempPlayer;
		// loops through every element
		for (int loop = 0; loop < players.length - 1; loop++) {
			// sorts the lowest number to the end of the array
			for (int index = 0; index < players.length - 1; index++) {
				if (scores[index] < scores[index + 1]) {
					tempScore = scores[index + 1];
					tempPlayer = players[index + 1];

					scores[index + 1] = scores[index];
					players[index + 1] = players[index];

					scores[index] = tempScore;
					players[index] = tempPlayer;
				}
			}
		}
	}

	/**
	 * @param player
	 * @param score
	 */
	public void setPlayerAndScore(String player, int score) {
		if (numberOfPlayers < players.length) {
			players[numberOfPlayers] = player;
			scores[numberOfPlayers] = score;
			numberOfPlayers++;
		}
		// if array is full, looks at last person to see if it can be overwritten
		else if (numberOfPlayers >= players.length) {
			if (score > scores[players.length - 1]) {
				players[players.length - 1] = player;
				scores[players.length - 1] = score;
			}
		}
	}

	/**
	 * @param name
	 * @return string score
	 */
	public String getPlayerScore(String name) {
		for (int i = 0; i < getNumberOfEntries(); i++) {
			if (players[i].equalsIgnoreCase(name)) {
				return "" + scores[i];
			}
		}
		return "Player not in top 10 scores.";
	}

	/**
	 * @param name, removes player
	 */
	public void removePlayer(String name) {
		for (int i = 0; i < getNumberOfEntries(); i++) {
			if (players[i].equalsIgnoreCase(name)) {
				players[i] = null;
				scores[i] = 0.0;
				break;
			}
		}
	}

	/**
	 * @return notNull, entries in the list
	 */
	public int getNumberOfEntries() {
		int notNull = 0;
		for (int i = 0; i < players.length; i++)
			if (players[i] != null)
				notNull++;
		return notNull;
	}

	/**
	 * @return namesAndScores :overrides toString to print top 10 players and their
	 *         scores
	 */
	public String toString() {
		String namesAndScores = "";
		for (int index = 0; index < players.length; index++) {
			if (players[index] != null) {
				namesAndScores = namesAndScores + "Top#" + (index + 1) + ": " + players[index] + ", " + scores[index]
						+ "\n";
			}
		}
		return namesAndScores;
	}
}
