import java.awt.Color;
import java.awt.Graphics;

public class Line extends Figure {

	public Line() {
		// TODO Auto-generated constructor stub
	}

	public Line(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		System.out.println("Line");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}

}
