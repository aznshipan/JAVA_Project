package Mobs;

import java.util.ArrayList;

public abstract class M {
	private static int id=0;
	protected int x;
	protected int y;
	protected String S;


	protected int step;
	protected  int atk;
	protected  int pv;
	
	public M(int x, int y) {
		this.x=x;
		this.y=y;
		id++;
		step =0;
		
	}
	public void move(int dx, int dy) {
		int x1= (int) (Math.random()*3) -1;
		int x2= (int) (Math.random()*3) -1;
		x=(x+x1+dx)%dx;
		y=(y+x2+dy)%dy;
	}
	public void manger_pomme(Pomme apple, ArrayList<Object> monde) { // A Continuer
		for(int i = 0; i < monde.size(); i++) {
			if(monde.get(i).equals(apple)) {
				monde.remove(i);
				return ;
			}
		}
	}
	public abstract String getS();
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
	
}