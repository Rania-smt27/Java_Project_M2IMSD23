package prisoners.players;

public class Random extends Player {
	public String getName() {
		return "random";
	}
	public int play(String opponentName) {
		return (int)(Math.random() + 1);
	}
}


/* cette stratégie "Random" prend des décisions au hasard entre la collaboration et la dénonciation à chaque tour du jeu.
 *  C'est-à-dire qu'elle ne suit aucune règle particulière et prend des décisions complètement aléatoires.
 */