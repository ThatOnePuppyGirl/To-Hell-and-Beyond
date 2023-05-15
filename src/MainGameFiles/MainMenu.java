package MainGameFiles;

import java.util.Scanner;

public class MainMenu {
	private Scanner input = new Scanner(System.in);
	private String mainMenu = "-------- MAIN MENU --------"
			+ "\nWhat would you like to do?"
			+ "\n---------------------------"
			+ "\nStart Game"
			+ "\nLoad Game (Coming soon! (Hopefully))"
			+ "\nSettings"
			+ "\nExit";

	/**
	 * @return the mainMenu
	 */
	public String GetMainMenu() {
		return mainMenu;
	}

	public MainMenu() {
	}

	public String GetAction() {
		String nextAction = GetUserInput(mainMenu);
		switch (nextAction) {
			case "start game":
				return nextAction;
			case "load game":
				return nextAction;
			case "settings":
				return nextAction;
			case "exit":
				System.exit(0);
			default:
				System.out.println("Whoops! That's not a valid choice. Please try again!");
				return GetAction();

		}
	}

	private String GetUserInput(String prompt) {
		System.out.println(prompt);
		String returned = input.nextLine().toLowerCase();
		return returned;
	}

}
