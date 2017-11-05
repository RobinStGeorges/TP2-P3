
public class Main {

	public static void main(String[] args) {
	    RobotGame game = new RobotGame(new Robot(), 3); 
	    game.play();
	    if (!game.won()) {
	    	 game.debugMap();
	    }
	}

}
