package Monde;

import java.util.ArrayList;

import Mobs.Arbre;
import Mobs.M;
import Mobs.M1;
import Mobs.M2;
import Mobs.Pomme;

public class Monde {
	private int dx;
	private int dy;
	private static ArrayList<Object> carte = new ArrayList<>();
	
	
	public static ArrayList<Object> getCarte() {
		return carte;
	}

	public Monde(int x, int y, int nb_A) {//Initialisation de la liste des agents à mettre dans le monde
		dx=x;
		dy=y;
		for (int i=0;i<nb_A;i++) {
			double p = Math.random();
			if (p <= 0.4) {
				int x1= (int) (Math.random()*dx);
				int y1 =(int) (Math.random()*dy);
				Arbre arbres = new Arbre(x1, y1);
				carte.add(arbres);
			}else {
				double p1 =  Math.random();
				if (p1 <= 0.4) {
					int x1= (int) (Math.random()*dx);
					int y1 =(int) (Math.random()*dy);
					M1 monstre = new M1(x1, y1);
					carte.add(monstre);
				}else {
					int x1= (int) (Math.random()*dx);
					int y1 =(int) (Math.random()*dy);
					M2 monstre = new M2(x1, y1);
					carte.add(monstre);
				}
			}
		}
	}
	
	public void pomme_pop(int cpt) {
		if (cpt % 3 == 0) {
			int x1;
			int y1;
			do {
				x1= (int) (Math.random()*dx);
				y1 =(int) (Math.random()*dy);
			}while (testC(x1, y1)!=null);
			Pomme apple = new Pomme(x1, y1);
			carte.add(apple);
		}
	}
	public void detail() {
		System.out.println("Taille :"+carte.size());
		for (int i=0;i<carte.size();i++) {
			System.out.println(carte.get(i).getClass() == Mobs.Arbre.class);//pour debuger lors des erreurs
		}
	}
	public static Object testC(int x,int y) {//retourne la classe de l'agent présent sur la case [x,y]
		for (int i=0;i<carte.size();i++) {
			if (carte.get(i).getClass() == Mobs.M1.class && ((M1) carte.get(i)).getX() == x && ((M1) carte.get(i)).getY() == y) //verification de la position et de la classe
				return ((M1) carte.get(i));
			if (carte.get(i).getClass() == Mobs.M2.class && ((M2) carte.get(i)).getX() == x && ((M2) carte.get(i)).getY() == y)
				return ((M2) carte.get(i));
			if (carte.get(i).getClass() == Mobs.Arbre.class&& ((Arbre) carte.get(i)).getX() == x && ((Arbre) carte.get(i)).getY() == y)
				return ((Arbre) carte.get(i));
			if (carte.get(i).getClass() == Mobs.Pomme.class&& ((Pomme) carte.get(i)).getX() == x && ((Pomme) carte.get(i)).getY() == y)
				return ((Pomme) carte.get(i));
		}
		return null;//S'il n'y a pas d'agent sur la case présent
	}
	
	public void Refresh() {
		for (int i=0;i<carte.size();i++) {
			if (carte.get(i).getClass() == Mobs.M1.class || carte.get(i).getClass() == Mobs.M2.class)
				((M) carte.get(i)).move(dx, dy);
		}
	}
	
	public void Afficher() {
		for (int j=0;j<dx;j++) {
			for (int i=0;i<dy;i++) {
				
				if (testC(i, j) != null) {
					if (carte.get(i).getClass() == Mobs.M1.class)
						System.out.print(((M) carte.get(i)).getS()+" ");
					if (carte.get(i).getClass() == Mobs.M2.class)
						System.out.print(((M) carte.get(i)).getS()+" ");
					if (carte.get(i).getClass() == Mobs.Arbre.class)
						System.out.print(((Arbre) carte.get(i)).getS()+" ");
					
				}else {
					System.out.print("- ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
}