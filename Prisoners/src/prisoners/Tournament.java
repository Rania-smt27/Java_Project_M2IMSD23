package prisoners;

import prisoners.players.Player;

/*
 * cette interface permet de :
 * 
 * définit deux méthodes statiques pour afficher les classements M0 et M1, respectivement.
 * Ces méthodes prennent un tableau de joueurs et un tableau de classement en paramètres
 * et les utilisent pour afficher les classements
 * 
 * */
public interface Tournament {
	public abstract void play();
    public abstract void  printRanking(Player[] players, int[] ranking); 
    public abstract void printRanking(Player[] players, double[] ranking);
    
    public abstract double[] competeEvolutionary(Player[] players, int numGenerations);
}
