import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
	private int x1, x2, y1,y2;
	private Color color;
	private boolean plein;
	public Figure() {
		x1=0;
        y1=0;
        x2=0;
        y2=0;
        color=Color.BLACK;
        plein = false;
	}
	
	public Figure(int x1, int y1, int x2, int y2, Color color, boolean plein)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.color=color;
        this.plein=plein;
    }

	public void setX1(int x1) {
		this.x1=x1;
	}
	public void setX2(int x2) {
		this.x2=x2;
	}
	public void setY1(int y1) {
		this.y1=y1;
	}
	public void setY2(int y2) {
		this.y2=y2;
	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public void setPlein(boolean plein) {
		this.plein=plein;
	}
	
	public int getX1() {
		return x1;
	}
	public int getY1() {
		return y1;
	}
	public int getX2() {
		return x2;
	}
	public int getY2() {
		return y2;
	}
	
	public Color getColor() {
		return color;
	}
	public boolean getPlein() {
		return plein;
	}
	
	public int getUpperLeftX(){
        return Math.min(getX1(),getX2());
    }
	
	public int getUpperLeftY(){
        return Math.min(getY1(),getY2());
    }
	
	public int getWidth()
    {
        return Math.abs(getX1()-getX2());
    }
    
    public int getHeight()
    {
        return Math.abs(getY1()-getY2());
    }
	
	abstract public void dessiner(Graphics g);
}
