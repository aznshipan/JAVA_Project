
public class Brouillon {
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
