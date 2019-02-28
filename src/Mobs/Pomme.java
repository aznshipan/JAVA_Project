package Mobs;

import Monde.Monde;

public class Pomme{
	private int x;
	private int y;
	private int step;
	private boolean estPourrie;
	public Pomme(int x, int y) {
		this.x = x;
		this.y = y;
		step=0;
		estPourrie = false;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void pourrir() {
		if(step >= 30 && estPourrie==false)
			estPourrie=true;
	}
	public static void duree() {
		for (int i=0;i<Monde.getCarte().size();i++) {
			if (Monde.getCarte().get(i) instanceof Pomme)
				(((Pomme) Monde.getCarte().get(i)).step)++;;
		}
	}
	public int getStep() {
		return step;
	}
	public boolean isEstPourrie() {
		return estPourrie;
	}
	public static void delete() {
		for(int i = 0; i < Monde.getCarte().size(); i++) {
			if (Monde.getCarte().get(i) instanceof Pomme && ((Pomme)Monde.getCarte().get(i)).isEstPourrie() && ((Pomme)Monde.getCarte().get(i)).getStep() >= 50)
				Monde.getCarte().remove(Monde.getCarte().get(i));
			}
		}
	
}
