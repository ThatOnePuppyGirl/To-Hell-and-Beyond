package MainGameFiles;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MainMenu newGame = new MainMenu();
		String nextAction = newGame.GetAction();
		switch (nextAction) {
			case "start game":
				GameManager gm1 = new GameManager(true);
				break;
			case "load game":
				GameManager gm2 = new GameManager(false);
				break;
			case "settings":
				System.out.println("wip dont use");
				break;
		}
	}
}
