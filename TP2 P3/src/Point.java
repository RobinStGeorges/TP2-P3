
public class Point {
	
	
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	
	public Point(){
		int lower = 0;
		int higher = 9;
		int random1=(int)(Math.random() * (higher-lower)) + lower;
		int random2=(int)(Math.random() * (higher-lower)) + lower;
		this.x=random1;
		this.y=random2;
	}
	
	
	public Point add (int dx, int dy){
		return new Point(x+dx, y+dy);
	}
	
	
	public Point add (Point p)
	{
		return add(p.x, p.y);
	}
	
	
	public Point sub(int dx, int dy)
	{
		return new Point(x-dx, y-dy);
	}
	
	
	public Point  sub (Point p)
	{
		return sub(p.x, p.y);
	}
	
	
	public int getX ()
	{ 
		return x;
	}
	
	
	public int getY ()
	{ 
		return y;
	}
	
	//deplace le Robot
		public void VaEn(int x,int y){
			this.x=x;
			this.y=y;
		}
	
	@Override
	public boolean equals (Object o)
	{
		if (o ==  null || o.getClass() != this .getClass())
			return false ;
		Point p = (Point) o;
		return x == p.x && y == p.y;
	}
	
	@Override
	public String  toString ()
	{
		return "(" +x+", "+y+")";
	}
}
