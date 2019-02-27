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
		int cpt_vois=0;
		for(int i = this.getX() - 1; i <= this.getX() + 1; i++) {
			for(int j = this.getY() - 1; j <= this.getY() + 1; j++) {
				for(int m=0; m < Monde.getCarte().size();m++) {
					if(Monde.getCarte().get(m).getClass() == Mobs.Pomme.class && ((Pomme) Monde.getCarte().get(m)).getX() == i && ((Pomme) Monde.getCarte().get(m)).getY() == j) {
						cpt_vois++;
						this.x = ((Pomme) Monde.getCarte().get(m)).getX();
						this.y = ((Pomme) Monde.getCarte().get(m)).getY();
						return;
					}
				}
			}
		}
		int x1= (int) (Math.random()*3) -1;
		int x2= (int) (Math.random()*3) -1;
		this.x=(x+x1+dx)%dx;
		this.y=(y+x2+dy)%dy;
	}
}