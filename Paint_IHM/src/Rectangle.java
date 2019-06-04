import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Figure {

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		if(getPlein()) {
			g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}
		else {
			g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}
	}
}
