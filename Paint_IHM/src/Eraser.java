import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Eraser extends Figure {

	private ArrayList<Integer> xPoints = new ArrayList<Integer>();
	private ArrayList<Integer> yPoints = new ArrayList<Integer>();

	public Eraser() {
		// TODO Auto-generated constructor stub
	}

	public Eraser(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		// TODO Auto-generated constructor stub
	}
	public void addPoint(int x,int y) {
		xPoints.add(x);
		yPoints.add(y);
	}
	public String getXY() {
		String s ="";
		
		for(int i = 0; i<xPoints.size();i++) {
			s+=+xPoints.get(i)+","+yPoints.get(i)+";";
		}
		
		return s;
	}
	
	
	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(32));
		g2.setColor(Color.WHITE);
		
		for(int i=0; i<xPoints.size()-3;i++) {
			g2.drawLine(xPoints.get(i), yPoints.get(i), xPoints.get(i+3), yPoints.get(i+3));
		}
		g2.setStroke(new BasicStroke(1));
	}

}
