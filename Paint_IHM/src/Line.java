import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Figure {

	public Line() {
		// TODO Auto-generated constructor stub
	}

	public Line(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		// TODO Auto-generated constructor stub
	}
	
	public Line(int x1, int y1, int x2, int y2, Color color, boolean plein, int size) {
		super(x1, y1, x2, y2, color, plein,size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getSize()));
		g2.setColor(getColor());
		g2.drawLine(getX1(), getY1(), getX2(), getY2());
	}

}
