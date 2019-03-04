package Sprite;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Mobs.Arbre;
import Mobs.Braconnier;
import Mobs.M1;
import Mobs.M2;
import Mobs.Pomme;
import Monde.Monde;

public class SpriteDemo extends JPanel {


	private JFrame frame;
	
	private Image waterSprite;
	private Image grassSprite;
	private Image treeSprite;
	private Image tSprite;
	private Image PokemonFeu;
	private Image[][] PokemonFeuMove;
	private Image PokemonFeuEvolue;
	private Image PokemonEau;
	private Image PokemonEauEvolue;
	private Image Apple;
	private Image ApplePourri;
	private Image Chasseur;
	public static int dx;
	public static int dy;
	private int spriteLength = 40;
	private static int pas = 0;
	private static int marcher = 0;
	private static int cpt_pas = 0;

	public SpriteDemo()
	{
		try
		{
			waterSprite = ImageIO.read(new File("water.png"));
			treeSprite = ImageIO.read(new File("arbref.png"));
			grassSprite = ImageIO.read(new File("grass.png"));
			tSprite = ImageIO.read(new File("tree.png"));
			PokemonFeu = ImageIO.read(new File("hericendre.png"));
			PokemonFeuEvolue = ImageIO.read(new File("FeurissonTrans.png")); 
			PokemonEau = ImageIO.read(new File("carapuce.png"));
			PokemonEauEvolue = ImageIO.read(new File("CarabaffeTrans.png")); 
			Apple = ImageIO.read(new File("pomme.png"));
			ApplePourri = ImageIO.read(new File("pommeP.png"));
			Chasseur = ImageIO.read(new File("chasseur.png"));
			
			PokemonFeuMove = new Image[4][8];
			PokemonFeuMove[0][0] = ImageIO.read(new File("Hericendre_walkdown1.png"));
			PokemonFeuMove[0][1] = ImageIO.read(new File("Hericendre_walkdown2.png"));  //Deplacement vers le bas
			PokemonFeuMove[0][2] = ImageIO.read(new File("Hericendre_walkdown3.png"));
			PokemonFeuMove[0][3] = ImageIO.read(new File("Hericendre_walkdown4.png"));
			
			PokemonFeuMove[1][0] = ImageIO.read(new File("Hericendre_walkup1.png"));
			PokemonFeuMove[1][1] = ImageIO.read(new File("Hericendre_walkup2.png"));  //Deplacement vers le haut
			PokemonFeuMove[1][2] = ImageIO.read(new File("Hericendre_walkup3.png"));
			PokemonFeuMove[1][3] = ImageIO.read(new File("Hericendre_walkup4.png"));
			
			PokemonFeuMove[2][0] = ImageIO.read(new File("Hericendre_walkleft1.png"));
			PokemonFeuMove[2][1] = ImageIO.read(new File("Hericendre_walkleft2.png"));  //Deplacement vers la gauche
			PokemonFeuMove[2][2] = ImageIO.read(new File("Hericendre_walkleft3.png"));
			PokemonFeuMove[2][3] = ImageIO.read(new File("Hericendre_walkleft4.png"));
			PokemonFeuMove[2][4] = ImageIO.read(new File("Hericendre_walkleft1.png"));
			PokemonFeuMove[2][5] = ImageIO.read(new File("Hericendre_walkleft2.png"));  //Deplacement vers la gauche
			PokemonFeuMove[2][6] = ImageIO.read(new File("Hericendre_walkleft3.png"));
			PokemonFeuMove[2][7] = ImageIO.read(new File("Hericendre_walkleft4.png"));
			
			PokemonFeuMove[3][0] = ImageIO.read(new File("Hericendre_walkright1.png"));
			PokemonFeuMove[3][1] = ImageIO.read(new File("Hericendre_walkright2.png"));  //Deplacement vers la droite
			PokemonFeuMove[3][2] = ImageIO.read(new File("Hericendre_walkright3.png"));
			PokemonFeuMove[3][3] = ImageIO.read(new File("Hericendre_walkright4.png"));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}

		frame = new JFrame("World of Sprite");
		frame.add(this);
		frame.setSize(700,300);
		frame.setVisible(true);
	}

	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		for ( int i = 0 ; i < dx ; i++ )
			for ( int j = 0 ; j < dy ; j++ )
			{
				try {
				
					/*if ( Monde.testC(i, j) ==null ) {
						
						g2.drawImage(grassSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						continue;
					}*/ g2.drawImage(grassSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						if (Monde.testC(i, j) instanceof M1) {
							if ( Monde.getDirection() == 1 ) {
								//marcher = 0;
								//for(pas = 0; pas < 4; pas ++) {
									//g2.drawImage(grassSprite,spriteLength*i ,spriteLength*j,spriteLength,spriteLength, frame);
									g2.drawImage(PokemonFeuMove[2][pas],spriteLength*i - this.marcher,spriteLength*j,spriteLength,spriteLength, frame);
								//}
							}
						}
					/*	if (Monde.testC(i, j) instanceof M2) {
							if (((M2) Monde.testC(i, j)).getNb_evolution() == 0)
								g2.drawImage(PokemonEau,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
							if (((M2) Monde.testC(i, j)).getNb_evolution() == 1)
								g2.drawImage(PokemonEauEvolue,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if (Monde.testC(i, j) instanceof Arbre) {
							g2.drawImage(tSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if (Monde.testC(i, j)instanceof Pomme) {
							g2.drawImage(grassSprite,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
							if ((((Pomme) Monde.testC(i, j)).isEstPourrie() == false))
								g2.drawImage(Apple,spriteLength*i,spriteLength*j,spriteLength-10,spriteLength-10, frame);
							if ((((Pomme) Monde.testC(i, j)).isEstPourrie() == true))
								g2.drawImage(ApplePourri,spriteLength*i,spriteLength*j,spriteLength-10,spriteLength-10, frame);
						}
						if (Monde.testC(i, j) instanceof Braconnier)
							g2.drawImage(Chasseur,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);*/

				}catch(Exception E) {
				}
			}
	
	}
	public static void main(String[] args) {
		
		Monde monde = new Monde(dx=14,dy=14,1);
		SpriteDemo a =new SpriteDemo();
		cpt_pas = 0;
		marcher = 0;
		//pas = 0;
		//int step=0;
		while(true) {
			//System.out.println("'''''''''"+cpt_pas);
			if(cpt_pas % 100000 == 0) {
			monde.Refresh();
			cpt_pas = 0;
			}
			cpt_pas += 1;
			System.out.println("'''''''''"+pas);
			if(pas < 7) {
				a.repaint();
	            pas += 1;
			}
			else {
				a.repaint();
				pas = 0;
			}
			marcher += 5 ;
			if(marcher >= 50 ) {
				marcher = 0;
			}
			/*monde.pomme_pop(step);
			Pomme.duree();
			Pomme.delete();*/ //enlever le commentement plus tard
			//Braconnier.chasser();
			try{
				Thread.sleep(200); // en ms
			}catch(Exception e){
				e.printStackTrace();
			}
			//step++;
		}
	}
}
