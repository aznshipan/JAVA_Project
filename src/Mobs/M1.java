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

	public int move(int dx, int dy) {
		int stock_x, stock_y;
		stock_x = this.getX();
		stock_y = this.getY();
		int cpt_vois=0;
		for(int i = this.getX() - 1; i <= this.getX() + 1; i++) {
			for(int j = this.getY() - 1; j <= this.getY() + 1; j++) {
				for(int m=0; m < Monde.getCarte().size();m++) {
					if(Monde.getCarte().get(m).getClass() == Mobs.Pomme.class && ((Pomme) Monde.getCarte().get(m)).getX() == i && ((Pomme) Monde.getCarte().get(m)).getY() == j) {
						cpt_vois++;
						this.x = ((Pomme) Monde.getCarte().get(m)).getX();
						this.y = ((Pomme) Monde.getCarte().get(m)).getY();
						manger_pomme((Pomme) Monde.getCarte().get(m), Monde.getCarte());
						this.evoluer();
						if(this.x < stock_x && this.y == stock_y) {
							return 1; //deplacement vers la gauche
						}
						if(this.x > stock_x && this.y == stock_y) {
							return 2; //deplacement vers la droite
						}
						if(this.x == stock_x && this.y > stock_y) {
							return 3; //deplacement vers le bas
						}
						if(this.x == stock_x && this.y < stock_y) {
							return 4; //deplacement vers le haut
						}
						if(this.x < stock_x && this.y < stock_y) {
							return 5; //deplacement vers la gauche et le haut
						}
						if(this.x < stock_x && this.y > stock_y) {
							return 6; //deplacement vers la gauche et le bas
						}
						if(this.x > stock_x && this.y < stock_y) {
							return 7; //deplacement vers la droite et le haut
						}
						if(this.x > stock_x && this.y > stock_y) {
							return 8; //deplacement vers la droite et le bas
						}
						return 9;// Reste sur place
							
					}
				}
			}
		}
		int x1,x2;
		do {
			x1= (int) (Math.random()*3) -1;
			x2= (int) (Math.random()*3) -1;
		}while(Monde.testC(((x+x1+dx)%dx),((y+x2+dy)%dy)) instanceof Arbre);
		this.x=(x+x1+dx)%dx;
		this.y=(y+x2+dy)%dy;
		if(this.x < stock_x && this.y == stock_y) {
			return 1; //deplacement vers la gauche
		}
		if(this.x > stock_x && this.y == stock_y) {
			return 2; //deplacement vers la droite
		}
		if(this.x == stock_x && this.y > stock_y) {
			return 3; //deplacement vers le bas
		}
		if(this.x == stock_x && this.y < stock_y) {
			return 4; //deplacement vers le haut
		}
		if(this.x < stock_x && this.y < stock_y) {
			return 5; //deplacement vers la gauche et le haut
		}
		if(this.x < stock_x && this.y > stock_y) {
			return 6; //deplacement vers la gauche et le bas
		}
		if(this.x > stock_x && this.y < stock_y) {
			return 7; //deplacement vers la droite et le haut
		}
		if(this.x > stock_x && this.y > stock_y) {
			return 8; //deplacement vers la droite et le bas
		}
		return 9; //Reste sur place
	}
	
	public void evoluer() {
		if(nb_pomme_manger >= 30 && nb_evolution == 0) {
			nb_evolution ++;
		}
	}
	
}