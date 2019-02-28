package Mobs;

import java.util.ArrayList;

import Monde.Monde;

public class Braconnier {
	private int x;
	private int y;
	public Braconnier(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void move(int dx, int dy) {
		int x1,x2;
		do {
			x1= (int) (Math.random()*3) -1;
			x2= (int) (Math.random()*3) -1;
		}while(Monde.testC(((x+x1+dx)%dx),((y+x2+dy)%dy)) instanceof Arbre);
		x=(x+x1+dx)%dx;
		y=(y+x2+dy)%dy;
	}
	public static void chasser() {
		for (int c=0;c<Monde.getCarte().size();c++) {

			if (Monde.getCarte().get(c) instanceof Braconnier) {
				for(int i = ((Braconnier)Monde.getCarte().get(c)).getX() - 1; i <= ((Braconnier)Monde.getCarte().get(c)).getX() + 1; i++) {
					for(int j = ((Braconnier)Monde.getCarte().get(c)).getY() - 1; j <= ((Braconnier)Monde.getCarte().get(c)).getY() + 1; j++) {
						for(int m=0; m < Monde.getCarte().size();m++) {
							if (Monde.getCarte().get(m) instanceof M1 && ((M1) Monde.getCarte().get(m)).getX() == i && ((M1) Monde.getCarte().get(m)).getY() == j) {
								if (Math.random() <0.6)
									Monde.getCarte().remove(Monde.getCarte().get(m));
									System.out.println("OK"+Monde.getCarte().size());
									return ;
							}
							if (Monde.getCarte().get(m) instanceof M2 && ((M2) Monde.getCarte().get(m)).getX() == i && ((M2) Monde.getCarte().get(m)).getY() == j) {
								if (Math.random() <0.6)
									Monde.getCarte().remove(Monde.getCarte().get(m));
									System.out.println("OK"+Monde.getCarte().size());
									return ;
							}
						}
					}
				}
			}
		}
	}
}
