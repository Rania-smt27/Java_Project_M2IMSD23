package prisoners.players;

import prisoners.Game;

public class Alternate extends Player {
	private boolean cooperate = true;

    public String getName() {
        return "alternate";
    }

    public int play(String opponentName) {
        if (cooperate) {
            cooperate = false;
            return Game.COLLABORATE;
        } else {
            cooperate = true;
            return Game.DENOUNCE;
        }
    }

}
