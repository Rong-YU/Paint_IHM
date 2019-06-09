import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Pencil extends Figure {
	private ArrayList<Integer> xPoints = new ArrayList<Integer>();
	private ArrayList<Integer> yPoints = new ArrayList<Integer>();

	public Pencil() {
		// TODO Auto-generated constructor stub
	}

	public Pencil(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		// TODO Auto-generated constructor stub
	}
	public void addPoint(int x,int y) {
		xPoints.add(x);
		yPoints.add(y);
	}
	
	
	
	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		
		for(int i=0; i<xPoints.size()-1;i++) {
			g.drawLine(xPoints.get(i), yPoints.get(i), xPoints.get(i+1), yPoints.get(i+1));
		}
	}

}
