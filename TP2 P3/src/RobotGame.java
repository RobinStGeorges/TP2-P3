import java.util.ArrayList;

public class RobotGame {

	////////////////////////////////////////////////////ATTRIBUTS

	Robot r;
	int n;

	//nb de lignes
	int nbL=10;

	//nb de colones
	int nbC=10;

	//matrice
	int[][] map;

	//liste des murs
	ArrayList<Point> murs=new ArrayList<Point>();
	Boolean gagne=false;
	Boolean obstacle=false;

	//////////////////////////////////////////////////CONTRUCTEUR

	public RobotGame(Robot r,int n){
		this.r=r;
		this.n=n;
		//création de la map
		map = new int[nbL][nbC];

		//Création des obstacles selon le niveau de jeu
		//niveau 2 = 1 mur
		if (n==2){
			Point mur1=new Point();
			murs.add(mur1);
		}
		//niveau 3 = 3 murs
		else if(n==3){
			Point mur1=new Point();
			murs.add(mur1);
			Point mur3=new Point();
			murs.add(mur3);
			Point mur2=new Point();
			murs.add(mur2);

		}
	}



	//////////////////////////////////////////////////////////METHODES

	//permet d'afficher toutes les données telles que les dimensions de la pièce, la position initiale du robot, la position du cadeau
	//lance le jeu
	public void play(){
		System.out.println("la position du robot au départ est : "+r.toString()+" , celle du cadeau est "+r.cadeau.toString());
		if (n>1){
			System.out.println("Il y a des mur en " + mursToString(murs));
		}
		else{
			System.out.println(" , et il n'y a pas de mur ");
		}

		//creer la map
		rempliMap();

		//ajoute les murs
		mursMap();

		//ajoute le robot
		robotMap();

		//ajoute le cadeau
		cadeauMap();

		//affiche la map
		affMap();

		//algorythme pour trouver le cadeau niveau UN
		if(n==1){
			if (r.getY()<=r.cadeau.getY() && r.getX()>=r.cadeau.getX() ){

				while(gagne==false ){
					//si le robot et le cadeau sont sur la meme case : gagné !
					if (r.equals(r.cadeau)){
						gagne=true;
					}
					//Le robot est bien placé et il n'y a pas de mur, donc le jeu est gagné !
					System.out.println("c'est gagné !");
					gagne=true;
					r.VaEn(r.cadeau.getX(),r.cadeau.getY());

				}

			}
		}
		if (n==2){
			if (r.getY()<=r.cadeau.getY() && r.getX()>=r.cadeau.getX() ){

				while(gagne==false ){
					//si le robot et le cadeau sont sur la meme case : gagné !
					if (r.getX()==r.cadeau.getX() && r.getY()==r.cadeau.getY()){
						gagne=true;
					}
					while (r.getX()>=r.cadeau.getX()+1){
						while (r.getY()<=r.cadeau.getY()-1){
							//Detection du mur sur l'axe y
							for (Point mur : murs){
								if (mur.getX()==r.getX() && mur.getY()==(r.getY()+1)){
									obstacle=true;
								}
								else{obstacle = false;}
							}
							if(obstacle==true){
								r.setX(r.getX()-1);	
								robotMap();
								affMap();
							}
							else{r.setY(r.getY()+1);}
							robotMap();
							affMap();
						}
						//detection du mur squr l'axe x
						for (Point mur : murs){
							if (mur.getY()==r.getY() && mur.getX()==(r.getX()-1)){
								obstacle=true;
							}
							else{obstacle = false;}
						}
						if(obstacle==true){
							r.setY(r.getY()+1);	
							robotMap();
							affMap();
						}
						else{r.setX(r.getX()-1);}
						robotMap();
						affMap();

					}

					if (r.getX()==r.cadeau.getX() && r.getY()==r.cadeau.getY()){
						gagne=true;
					}
				}

			}

		}

	}


	//affiche la position du robot et du cadeau si le jeu est perdu
	/**
	 * 
	 */
	public void debugMap() {
		// TODO Auto-generated method stub
		System.out.println("Perdu ! ");
		System.out.println("Le robot est à la position "+r.toString());
		System.out.println("Le cadeau est à la position "+r.cadeau.toString());
	}


	//Renvoit true si le jeu est gagné
	/**
	 * 
	 * @return
	 */
	public boolean won() {
		if (r.getX()==r.cadeau.getX() && r.getY()==r.cadeau.getY()){
			System.out.println("Vous avez gagnez ! Bravo !");
			return true;
		}
		else {return false;}
	}


	//affiche les murs du arrayList sur la map
	/**
	 * 
	 * @param a
	 * @return
	 */
	public String mursToString(ArrayList<Point> a){
		String b="";
		for(Point p : murs){
			b=b+" "+p.toString()+" ";
		}
		return b;
	}


	//remplir la matrice 
	/**
	 * 
	 */
	public void rempliMap() {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				map[i][j]=3;


			}
		}
	}

	//affiche matrice
	/**
	 * 
	 */
	public void affMap(){
		// Affichage de la matrice
		System.out.println("|||||||||||");
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				int a=map[i][j];

				if (a==1) {
					System.out.print(" R ");
				}
				else if(a==2){
					System.out.print(" C ");
				}
				else if(a==4){
					System.out.print("|||");
				}
				else {
					System.out.print(" . ");
				}

			}
			System.out.println();
		}
	}

	//ajoute les murs
	/**
	 * 
	 */
	public void mursMap(){
		for(Point p : murs){
			int x=p.getX();
			int y=p.getY();
			map[x][y]=4;
		}
	}

	//positionne le robot
	/**
	 * 
	 */
	public void robotMap(){
		int x=r.getX();
		int y=r.getY();
		map[x][y]=1;
	}
	//positionne le cadeau
	/**
	 * 
	 */
	public void cadeauMap(){
		int x=r.cadeau.getX();
		int y=r.cadeau.getY();
		map[x][y]=2;
	}



	//GETTERS

	public int getNbL() {
		return nbL;
	}

	public int getNbC() {
		return nbC;
	}

}
