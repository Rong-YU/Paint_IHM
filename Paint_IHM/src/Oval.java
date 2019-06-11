import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Oval extends Figure {

	public Oval() {
		// TODO Auto-generated constructor stub
	}

	public Oval(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		// TODO Auto-generated constructor stub
	}
	public Oval(int x1, int y1, int x2, int y2, Color color, boolean plein, int size) {
		super(x1, y1, x2, y2, color, plein, size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getSize()));
		if(getPlein()) {
			g2.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}
		else {
			g2.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}
	}

}
