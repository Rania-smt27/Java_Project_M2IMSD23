package prisoners.players;

import prisoners.Game;
//la stratégie Rancuniére 

public class Grudge extends Player {
	
	 private boolean betrayed = false;

	    public String getName() {
	        return "grudge";
	    }

	    public int play(String opponentName) {
	        if (betrayed) {
	            return Game.DENOUNCE;
	        } else {
	            int[] lastOutcome = Game.getLastOutcome(opponentName, this.getName());
	            if (lastOutcome[1] == Game.DENOUNCE) {
	                betrayed = true;
	            }
	            return Game.COLLABORATE;
	        }
	    }

}
