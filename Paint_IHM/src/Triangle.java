import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangle extends Figure {
	private int[] yPoints;
	private int[] xPoints;
	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		// TODO Auto-generated constructor stub
	}
	
	public Triangle(int x1, int y1, int x2, int y2, Color color, boolean plein, int size) {
		super(x1, y1, x2, y2, color, plein, size);
		// TODO Auto-generated constructor stub
	}
	
	
	public void calcCoor() {
		yPoints = new int[3];
		xPoints = new int[3];
		yPoints[0] = getY1();
		yPoints[1] = getY2();
		yPoints[2] = getY2();
		xPoints[1] = getX1();
		xPoints[2] = getX2();
		xPoints[0] = (xPoints[2]+xPoints[1])/2;
	}
	
	
	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		this.calcCoor();

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getSize()));
		if(getPlein()) {
			g2.fillPolygon(xPoints, yPoints, 3);
		}
		else {
			g2.drawPolygon(xPoints, yPoints, 3);
		}
		
		
	}

}
