package Mobs;

import java.util.ArrayList;

import Monde.Monde;

public abstract class M {
	private static int id=0;
	protected int x;
	protected int y;
	protected int sens;
	protected String S;
	protected int nb_pomme_manger;
	protected int nb_evolution;


	protected int step;
	protected  int atk;
	protected  int pv;
	
	public M(int x, int y) {
		this.x=x;
		this.y=y;
		id++;
		step =0;
		nb_pomme_manger = 0;
		nb_evolution = 0;
		
	}
	public void move(int dx, int dy) {
	/*	for(int i = this.getX() - 1; i <= this.getX() + 1; i++) {
			for(int j = this.getY() - 1; j <= this.getY() + 1; j++) {
				for(int m=0; m < Monde.getCarte().size();m++) {
					if(Monde.getCarte().get(m).getClass() == Mobs.Pomme.class && ((Pomme) Monde.getCarte().get(m)).getX() == i && ((Pomme) Monde.getCarte().get(m)).getY() == j) {
						cpt_vois++;*/
		if(this.sens == 0) {
			this.x=(this.x-1+dx)%dx;
		}
		if(this.sens == 1) {
			this.x=(this.x+1+dx)%dx;
		}
		if(this.sens == 2) {
			this.y=(this.y+1+dx)%dx;
		}
		if(this.sens == 3) {
			this.y=(this.y-1+dx)%dx;
		}
	
	}

	public void manger_pomme(Pomme apple , ArrayList<Object> monde) { // A Continuer
		for(int i = 0; i < monde.size(); i++) {
				if(monde.get(i).equals(apple)){
					if (apple.isEstPourrie()) 
						nb_pomme_manger += 1 ;
					else 
						nb_pomme_manger += 2 ;
					monde.remove(i);
					return ;
			}
		}
	}
	public abstract String getS();
	public abstract void evoluer();
	public static int getId() {
		return id;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getStep() {
		return step;
	}

	public int getAtk() {
		return atk;
	}

	public int getPv() {
		return pv;
	}
	public int getNb_pomme_manger() {
		return nb_pomme_manger;
	}
	public int getNb_evolution() {
		return nb_evolution;
	}
	public int getSens() {
		this.sens = ((int)(Math.random()*4));
		return this.sens;
	}
	public void setSens() {
		this.sens = (int)(Math.random()*4);
	}
	
	
}