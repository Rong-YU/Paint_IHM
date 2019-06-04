import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Figure {
	private int x3,y3;
	private int[] yPoints;
	private int[] xPoints;
	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		this.calcCoor();
		System.out.println("triangle");
		// TODO Auto-generated constructor stub
	}
	
	public void calcCoor() {
		x3 = getX2();
		y3= getY2();
		int x2 = getX1();
		int y2 = y3;
		this.setX2(x2);
		this.setY2(y2);
		int x1 = (x3+x2)/2;
		this.setX1(x1);
		yPoints = {y1,y2,y3};
	}
	
	public int[] getXs() {
		int[] xPoints = {getX1(),getX2(),x3};
		return xPoints;
	}
	public int[] getYs() {
		int[] yPoints = {getY1(),getY2(),y3};
		return yPoints;
	}
	
	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		System.out.println("x1"+getX1()+" x2"+getX2()+" x3"+this.x3+" y1"+getY1()+" y2"+getY2()+" y3"+y3);
		for(int i =0;i< getYs().length; i++) {
			System.out.println(getYs()[i]);
		}
		if(getPlein()) {
			g.fillPolygon(getXs(), getYs(), 3);
		}
		else {
			g.drawPolygon(getXs(), getYs(), 3);
		}
	}

}
