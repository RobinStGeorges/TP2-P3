
public class Point {


	private int x, y;

	//////////////////////////////////////////////////////CONSTRUCTEURS

	public Point(int x, int y) {
		this.x = x; 
		this.y = y;
	}

	//constructeur point random
	public Point(){


		int lower = 0;
		int higher = 9;
		int random1=(int)(Math.random() * (higher-lower)) + lower;
		int random2=(int)(Math.random() * (higher-lower)) + lower;
		this.x=random1;
		this.y=random2;
	}

	/////////////////////////////////////////////////////METHODES

	//Ajoute des coordon�es
	public Point add (int dx, int dy){
		return new Point(x+dx, y+dy);
	}

	//Ajoute un point
	public Point add (Point p)
	{
		return add(p.x, p.y);
	}


	//Soustrait des coordonn�es
	public Point sub(int dx, int dy)
	{
		return new Point(x-dx, y-dy);
	}


	public Point  sub (Point p)
	{
		return sub(p.x, p.y);
	}




	//deplace le Robot
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void VaEn(int x,int y){
		this.x=x;
		this.y=y;
	}


	@Override
	/**
	 * 
	 */
	public boolean equals (Object o)
	{
		if (o ==  null || o.getClass() != this .getClass())
			return false ;
		Point p = (Point) o;
		return x == p.x && y == p.y;
	}

	//Affiche en string les coordonn�es d'un point
	@Override
	/**
	 * 
	 */
	public String  toString ()
	{
		return "(" +x+", "+y+")";
	}

	//////////////////////////////////////////////////////////GETTERS
	public int getX ()
	{ 
		return x;
	}


	public int getY ()
	{ 
		return y;
	}
}
