package prisoners;

import prisoners.players.Player;

public class Game {
	public static final int COLLABORATE = 1;
	public static final int DENOUNCE = 2;
	public static double[] play(Player player1, Player player2) {
		switch (player1.play(player2.getName())) {
			case Game.COLLABORATE://Si player1 choisit de collaborer, on examine le choix de player2
				switch (player2.play(player1.getName())) { //Examiner le choix de player 2
					case Game.COLLABORATE://
						return new double[]{0.9, 0.9};
					case Game.DENOUNCE://Si player1 choisit de dénoncer, on examine également le choix de player2
						return new double[]{0.2, 1};
					default:
						return new double[]{0, 1};
				}						
			case Game.DENOUNCE:
				switch (player2.play(player1.getName())) {
					case Game.COLLABORATE:
						return new double[]{1, 0.2};
					case Game.DENOUNCE:
						return new double[]{0.5, 0.5};
					default:
						return new double[]{0, 1};
				}
			default:
				return new double[]{1, 0};
		}
	}
	
	/*
	 * LastOutcomes:  pour enregistrer le résultat de chaque tour, et Game.
	 * getLastOutcome(player1Name, player2Name) pour obtenir le résultat du dernier tour joué entre les deux joueurs.
	 *  Cela permettra à la classe Grudge (ou toute autre stratégie) d'accéder aux résultats précédents.*/
	
	private static int[][] lastOutcomes = new int[2][2];

    public static void setLastOutcome(String player1Name, String player2Name, int player1Choice, int player2Choice) {
        int player1Index = player1Name.equals("player1") ? 0 : 1;
        int player2Index = player2Name.equals("player1") ? 0 : 1;

        lastOutcomes[player1Index][player2Index] = player1Choice;
        lastOutcomes[player2Index][player1Index] = player2Choice;
    }

    public static int[] getLastOutcome(String player1Name, String player2Name) {
        int player1Index = player1Name.equals("player1") ? 0 : 1;
        int player2Index = player2Name.equals("player1") ? 0 : 1;

        int[] outcome = new int[2];
        outcome[0] = lastOutcomes[player1Index][player2Index];
        outcome[1] = lastOutcomes[player2Index][player1Index];

        return outcome;
    }

}

