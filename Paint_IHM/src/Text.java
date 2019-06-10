import java.awt.Color;
import java.awt.Graphics;

public class Text extends Figure {
	String text;
	public Text(int x, int y, Color color) {
		// TODO Auto-generated constructor stub
		this.setX1(x);
		this.setY1(y);
		this.setColor(color);
		text = "";
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}

	public Text(int x1, int y1, int x2, int y2, Color color, boolean plein) {
		super(x1, y1, x2, y2, color, plein);
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub

		g.drawString(text, getX1(), getY1());
	}

}
