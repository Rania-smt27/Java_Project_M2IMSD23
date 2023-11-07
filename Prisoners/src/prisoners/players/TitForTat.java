package prisoners.players;

import prisoners.Game;

/*la stratégie Donnant-donnant:
 * 
 * est une stratégie de coopération réciproque. Elle commence par la coopération et ensuite,
 * elle réplique simplement les choix de l'adversaire. Si l'adversaire coopère, elle coopère aussi. Si l'adversaire trahit,
 * elle trahit en retour.
 * Cette stratégie a l'avantage d'encourager la coopération entre les joueurs tant que les deux parties continuent à collabore
 * */

public class TitForTat extends Player  {
	private int lastMove = Game.COLLABORATE;

    public String getName() {
        return "tit_for_tat";
    }

    public int play(String opponentName) {
        int currentMove = lastMove;
        lastMove = Game.getLastOutcome(opponentName, this.getName())[1];
        return currentMove;
    }

}
