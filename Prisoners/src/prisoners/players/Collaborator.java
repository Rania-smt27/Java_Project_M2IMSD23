package prisoners.players;

import prisoners.Game;

public class Collaborator extends Player {
	public String getName() {
		return "collaborator";
	}
	public int play(String opponentName) {
		return Game.COLLABORATE;
	}

}
