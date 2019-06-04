import java.awt.Color;
import java.awt.Graphics;

public class Cercle extends Figure {

	public Cercle() {
		// TODO Auto-generated constructor stub
	}

	public Cercle(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		if(getPlein()) {
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getWidth());
		}
		else {
			g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getWidth());
		}
	}

}
