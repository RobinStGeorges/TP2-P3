
public class Main {

	public static void main(String[] args) {
		
		//Nouveau jeu
	    RobotGame game = new RobotGame(new Robot(), 2); 
	    //d�marage du jeu
	    game.play();
	    //v�rification gagner / perdu
	    if (!game.won()) {
	    	 game.debugMap();
	    }
	}

}
