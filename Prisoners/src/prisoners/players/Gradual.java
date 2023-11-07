package prisoners.players;

import prisoners.Game;

/*
 * La stratégie Graduelle:
 * 
 * qui commence par la coopération et continue de coopérer tant que l'adversaire fait de même. Cependant, si l'adversaire trahit,
 * "Graduelle" répond avec une série de trahisons proportionnelles au nombre de trahisons passées de l'adversaire,
 * suivie de deux tours de coopération
 * */


public class Gradual extends Player{
	private int consecutiveBetrayals = 0;

    public String getName() {
        return "gradual";
    }

    public int play(String opponentName) {
        if (consecutiveBetrayals > 0) {
            consecutiveBetrayals--;
            return Game.DENOUNCE;
        }

        int[] lastOutcome = Game.getLastOutcome(opponentName, this.getName());
        if (lastOutcome[1] == Game.DENOUNCE) {
            consecutiveBetrayals = lastOutcome[0];
            return Game.DENOUNCE;
        } else {
            return Game.COLLABORATE;
        }
    }
	
}
