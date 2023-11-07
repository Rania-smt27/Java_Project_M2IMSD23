package prisoners.players;

import prisoners.Game;

/*
 * La stratégie Sondeur:
 * 
 * commence par un comportement prévisible et distinctif pour les trois premiers tours.Ensuite,
 *  elle utilise une variation de la stratégie "Donnant-donnant" en fonction du comportement de l'adversaire lors des premiers tours
 *  
 * */

public class Prober extends Player  {
	 private int turn = 0;

	    public String getName() {
	        return "prober";
	    }

	    public int play(String opponentName) {
	        if (turn < 3) {
	            turn++;
	            if (turn == 1) {
	                return Game.DENOUNCE;
	            } else {
	                return Game.COLLABORATE;
	            }
	        } else {
	            int[] lastOutcome = Game.getLastOutcome(opponentName, this.getName());
	            if (lastOutcome[1] == Game.COLLABORATE && lastOutcome[0] == Game.COLLABORATE) {
	                return Game.DENOUNCE;
	            } else {
	                return Game.getLastOutcome(opponentName, this.getName())[1];
	            }
	        }
	    }

}
