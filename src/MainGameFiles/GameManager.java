package MainGameFiles;

import MiscClasses.NotYetImplementedException;

public class GameManager {
	public GameManager(boolean newGame) {
		if (newGame)
			CreateNewGame();
		else
			LoadPreviousGame();
		System.out.println(newGame);
	}

	// not yet implemented, not planned yet
	private void LoadPreviousGame() {
		throw new NotYetImplementedException();
	}

	// create a new game :)
	@SuppressWarnings("unused")
	private void CreateNewGame() {

	}

}
