package week6;

/*
 * Created App Class with 2 players (Player 1 vs Player 2), players draw 26 cards each, players flip cards to determine winner of each round, 
 * points are tallied at the end of the game, and a winner is declared. Added in 2 second delay between flips so watchers can reach 
 * what is being played by each player on each flip.
 */

public class App {

	public static void main(String[] args) {
		App w = new App();
		w.playGame();
	}
	
	private void playGame() {
		Deck d = new Deck();
		Player p = new Player();
		p.setName("Player 1");
		Player p2 = new Player();
		p2.setName("Player 2");
		drawCards(d, p, p2);
		flipCards(p, p2);
		findWinner(p, p2);
	}

	private void drawCards(Deck d, Player p, Player p2) {
		for(int i = 1; i <= 26; i++) {
			p.draw(d);
			p2.draw(d);
		}
	}
	
	private void flipCards(Player p, Player p2) {
		for(int i = 1; i <= 26; i++) {
			Card toHp = p.flip();
			Card toHp2 = p2.flip();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e){
				e.getSuppressed();
			}
			if(toHp.getValue() > toHp2.getValue()) {
				p.incrementScore();
				System.out.println(p.getName() + " : " + toHp.getName() + " vs " + p2.getName() + " : " + toHp2.getName());
				System.out.println("Player 1 gets 1 point for this hand.");
				System.out.println(   );
			} else if(toHp.getValue() < toHp2.getValue()) {
				p2.incrementScore();
				System.out.println(p.getName() + " : " + toHp.getName() + " vs " + p2.getName() + " : " + toHp2.getName());
				System.out.println("Player 2 gets 1 point for this hand.");
				System.out.println(   );
			} else { 
				System.out.println(p.getName() + " : " + toHp.getName() + " vs " + p2.getName() + " : " + toHp2.getName());
				System.out.println("Draw. This hand ends in a tie.");
				System.out.println(   );
			}
		}
	}
	
	private void findWinner(Player p, Player p2) {
		if(p.getScore() > p2.getScore()) {
			System.out.println("Final score is " + p.getScore() + " to " + p2.getScore());
			System.out.println("Player 1 is the winner!");
		} else if (p.getScore() < p2.getScore()) {
			System.out.println("Final score is " + p.getScore() + " to " + p2.getScore());
			System.out.println("Player 2 is the winner!");
		} else {
			System.out.println("Final score is " + p.getScore() + " to " + p2.getScore());
			System.out.println("Draw. Game ends in a tie.");
			
		}
	}
}    
