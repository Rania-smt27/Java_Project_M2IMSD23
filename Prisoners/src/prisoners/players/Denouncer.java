package prisoners.players;

import prisoners.Game;

public class Denouncer extends Player {
	public String getName() {
		return "denouncer";
	}
	public int play(String opponentName) {
		return Game.DENOUNCE;
	}

}
