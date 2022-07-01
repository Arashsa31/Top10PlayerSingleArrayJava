import java.util.Scanner;

/**
 * @author Arash
 *
 */
public class PlayerHighScoreDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * PlayerHighScore game = new PlayerHighScore(); for(int i=0;i<5;i++) {
		 * game.setPlayerAndScore("Jason" , (int) (Math.random() * 100)); }
		 * game.sortPlayer(); System.out.print(game.toString()); System.out.println();
		 * 
		 * game.setPlayerAndScore("Kaiju", 30); game.sortPlayer();
		 * System.out.print(game.toString()); System.out.println();
		 * 
		 * System.out.println(game.getPlayerScore("Kaiju"));
		 * 
		 * System.out.println(game.getPlayerScore("Joana"));
		 * 
		 * game.removePlayer("Jason"); game.sortPlayer();
		 * System.out.println(game.toString());
		 */

		/*
		 * Create a menu system that allows the user to select which option to invoke.
		 * a. add player name and score b. print top 10 names c. enter a player name to
		 * return their score d. remove a player
		 */
		Scanner keyboard = new Scanner(System.in);
		PlayerHighScore game = new PlayerHighScore();
		while (true) {
			System.out.println("\nPlease select from one of the following menu options:");
			System.out.println("1. Add a Player name and Score");
			System.out.println("2. Display the top 10 scores");
			System.out.println("3. Display the top score for the player");
			System.out.println("4. Remove a Player name and Score");
			System.out.println("5. Quit.");
			System.out.println("Enter the numberical option: ");
			int options = keyboard.nextInt();
			if (options == 1) {
				System.out.print("Enter the player name: ");
				String name = keyboard.next();
				System.out.print("Enter the player score: ");
				int score = keyboard.nextInt();
				game.setPlayerAndScore(name, score);
				game.sortPlayer();
			} else if (options == 2) {
				System.out.println(game);
			} else if (options == 3) {
				System.out.print("Enter the player name to retrieve their highest score: ");
				String name = keyboard.next();
				System.out.println(game.getPlayerScore(name));
			} else if (options == 4) {
				System.out.print("Enter the player name to remove their highest score from the top 10: ");
				String name = keyboard.next();
				game.removePlayer(name);
				game.sortPlayer();
			} else if (options == 5) {
				System.out.println("Goodbye.");
				System.exit(0);
			} else
				System.out.println("Enter a valid number. (1, 2, 3, 4, 5)");
		}

	}
}
