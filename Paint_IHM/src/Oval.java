import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Figure {

	public Oval() {
		// TODO Auto-generated constructor stub
	}

	public Oval(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		if(getPlein()) {
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}
		else {
			g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}
	}

}
