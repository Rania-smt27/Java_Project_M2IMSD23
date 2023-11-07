package prisoners;
/* author: RANIA SAMEUT */

import prisoners.players.Player;
import prisoners.players.*;

public class Arena implements Tournament {
	
	//c'est constante pour Calculer des résultats:
    private static final int NUM_GENERATIONS = 1000;
    private static final int TOURNAMENT_ROUNDS = 10;

    public static void main(String[] args) {
        Arena arena = new Arena();
        arena.play();
    }

    @Override
    public void play() {
        Player[] players = {
            new Gradual(),
            new TitForTat(),
            new Prober(),
            new Suspicious(),
        };

        int[] victoriesM0 = calculateVictories(players, TOURNAMENT_ROUNDS);
        double[] pointsM1 = calculatePoints(players, TOURNAMENT_ROUNDS);

        // Affichage des résultats M0
        System.out.println("\nM0 : nombre de victoires");
        printRanking(players, victoriesM0);

        // Affichage des résultats M1
        System.out.println("\nM1 : nombre de points");
        printRanking(players, pointsM1);

    }

    @Override
    public double[] competeEvolutionary(Player[] players, int numGenerations) {
        // Implémentation pour M2
        return null;
    }

    // Implémentations pour M0 et M1
    /* * M0 (Nombre de Victoires) :
	Cette méthode mesure le nombre de fois qu'un joueur remporte une partie contre un adversaire.
	Pour chaque paire de joueurs, on joue un certain nombre de parties et on compte combien de fois chaque joueur remporte la partie.
	Le joueur avec le plus grand nombre de victoires est classé en premier.
     *  */
    
    /* M1 (Nombre de Points) :
	Cette méthode attribue des points à chaque joueur en fonction du résultat de chaque partie.
	Par exemple, on peut attribuer 3 points pour une victoire, 1 point pour un match nul et 0 point pour une défaite.
	*/
    
    static int[] calculateVictories(Player[] players, int numRounds) {
        int numPlayers = players.length;
        int[] victories = new int[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            for (int j = i + 1; j < numPlayers; j++) {
                double[] results = Game.play(players[i], players[j]);

                if (results[0] > results[1]) {
                    victories[i]++;
                } else if (results[1] > results[0]) {
                    victories[j]++;
                }
            }
        }

        return victories;
    }

    static double[] calculatePoints(Player[] players, int numRounds) {
        int numPlayers = players.length;
        double[] points = new double[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            for (int j = i + 1; j < numPlayers; j++) {
            	//appel direct de Game pour supprimer Game Exemple 
                double[] results = Game.play(players[i], players[j]);

                points[i] += results[0];
                points[j] += results[1];
            }
        }

        return points;
    }

    @Override
    public void printRanking(Player[] players, int[] ranking) {
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName() + " : " + ranking[i]);
        }
    }

    @Override
    public void printRanking(Player[] players, double[] ranking) {
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName() + " : " + ranking[i]);
        }
    }
    
    /* Arena: simule des tournois entre différentes stratégies de ce jeu.
     *  Elle organise des confrontations entre les joueurs,
     *  calcule les résultats basés sur les règles du jeu,
     *  puis classe les joueurs en fonction de leurs performances*/
}