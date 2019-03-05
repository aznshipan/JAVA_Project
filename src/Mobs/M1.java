package Mobs;

import Monde.Monde;

public class M1 extends M{
	public M1(int x, int y) {
		super(x, y);
		atk=(int) (Math.random()*100);
		pv=500;
		S="X";
	}

	public String getS() {
		return S;
	}

	public void move(int dx, int dy) {
		/*	for(int i = this.getX() - 1; i <= this.getX() + 1; i++) {
				for(int j = this.getY() - 1; j <= this.getY() + 1; j++) {
					for(int m=0; m < Monde.getCarte().size();m++) {
						if(Monde.getCarte().get(m).getClass() == Mobs.Pomme.class && ((Pomme) Monde.getCarte().get(m)).getX() == i && ((Pomme) Monde.getCarte().get(m)).getY() == j) {
							cpt_vois++;*/
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
	
	public void evoluer() {
		if(nb_pomme_manger >= 30 && nb_evolution == 0) {
			nb_evolution ++;
		}
	}
	public void setSens() {
		this.sens = ((int)(Math.random()*4));
	}
	public int getSens() {
		return this.sens;
	}
	
}