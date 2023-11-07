package prisoners.players;

import prisoners.Game;

/* stratégie Méfiant:
 * une stratégie de défiance constante. Elle commence par la trahison et continue de trahir indépendamment des actions de l'adversaire.
 * Cela signifie qu'elle ne fait jamais confiance à l'adversaire et préfère toujours trahir
 * 
 *  ------------------------------- ne coopère jamais-------------------------------
 * */
public class Suspicious extends Player {
	
	private int lastMove = Game.DENOUNCE;

    public String getName() {
        return "suspicious";
    }

    public int play(String opponentName) {
        int currentMove = lastMove;
        lastMove = Game.getLastOutcome(opponentName, this.getName())[1];
        return currentMove;
    }

}

