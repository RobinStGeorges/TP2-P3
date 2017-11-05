
public class Robot extends Point {
	
	/////////////////////////////////////////////////////////////////ATTRIBUTS
	
	Point cadeau;
	
	//random
	int lower = 0;
	int higher = 9;
	int random1=(int)(Math.random() * (higher-lower)) + lower;
	int random2=(int)(Math.random() * (higher-lower)) + lower;
	
	
	/////////////////////////////////////////////////////////////////CONSTRUCTEURS
	public Robot(int x, int y) {
		super(x, y);
		cadeau=new Point(random1,random2);
	}
	
	public Robot() {
		super();
		cadeau=new Point(random1,random2);
	}

	/////////////////////////////////////////////////////////////////METHODES
	
	//pour tourner a gauche
	public void turnLeft(){
		
	}
	
	//pour avancer
	public void moveForward(){
		
	}
	
	
	
	//retourne la position actuelle du robot en x 
	/**
	 * 
	 * @return
	 */
	public Point getCurrentPosition(){
		return new Point(this.getX(),this.getY());
		
	}
	
	
	
	//retourne la position qu'obtiendra le robot s'il avance et que si chemin est libre
	public void getFacingPosition(){
		
	}
	
	//retourne la position du cadeau
	/**
	 * 
	 * @return
	 */
	public Point getPresentPosition(){
		return cadeau;
	}
	
	//indique s'il est possible d'avancer ou non (s'il n'y a pas d'obstacle devant le robot
	public void canMoveForward(){
		
	}
	

}
