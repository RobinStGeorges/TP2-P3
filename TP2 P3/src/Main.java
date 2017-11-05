
public class Main {

	public static void main(String[] args) {
		
		//Nouveau jeu
	    RobotGame game = new RobotGame(new Robot(), 2); 
	    //démarage du jeu
	    game.play();
	    //vérification gagner / perdu
	    if (!game.won()) {
	    	 game.debugMap();
	    }
	}

}
