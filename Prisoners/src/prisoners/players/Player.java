package prisoners.players;

public  abstract class  Player {
	public abstract String getName();
	public abstract  int  play(String opponentName);
	
	/*
	 *  la méthode play: prend le nom de l'adversaire en argument et retourne un entier. 
	 *  Cependant, la façon précise dont cette méthode fonctionne dépendra de l'implémentation dans les sous-classes spécifiques
	 *
	 *  */
}
