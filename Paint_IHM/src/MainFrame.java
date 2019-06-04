import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame{
	private ZoneDessin zoneDessin = new ZoneDessin();
	private JButton cercle;
	private JButton line;
	private JButton oval;
	private JButton rectangle;
	private JButton triangle;
	private JButton text;
	private JButton color;
	private JButton fill;
	private BoutonListener blis = new BoutonListener();
	public MainFrame() throws Exception{
		// TODO Auto-generated constructor stub
		super("Paint");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout(new BorderLayout());
		
        add(zoneDessin, BorderLayout.CENTER);
        add(this.getPanelWest(), BorderLayout.WEST);
        setSize(1080,768);
        setVisible(true);
        }
	
	public JPanel getPanelWest() {
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(4, 2, 10, 10));
		cercle = new JButton("Cercle");
		line = new JButton("Line");
		oval = new JButton("Oval");
		rectangle = new JButton("Rectangle");
		triangle = new JButton("Triangle");
		text = new JButton("Text");
		color = new JButton("Color");
		fill = new JButton("Fill");
		
		cercle.addActionListener(blis);
		line.addActionListener(blis);
		oval.addActionListener(blis);
		rectangle.addActionListener(blis);
		triangle.addActionListener(blis);
		text.addActionListener(blis);
		color.addActionListener(blis);
		fill.addActionListener(blis);
		pan.add(line);
		pan.add(rectangle);
		pan.add(oval);
		pan.add(cercle);
		pan.add(triangle);
		pan.add(text);
		pan.add(fill);
		pan.add(color);
		return pan;
	}
	
	class BoutonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==line) {
				System.out.println("yes");
				zoneDessin.setFigure(0);
			}
			else if(e.getSource()==rectangle) {
				zoneDessin.setFigure(1);
			}
			else if(e.getSource()==oval) {
				zoneDessin.setFigure(2);
			}
			else if(e.getSource()==cercle) {
				zoneDessin.setFigure(3);
			}
			else if(e.getSource()==triangle) {
				zoneDessin.setFigure(4);
			}
			else if(e.getSource()==text) {
				
			}
			else if(e.getSource()==fill) {
				zoneDessin.setPlein(!zoneDessin.getPlein());
			}
			else if(e.getSource()==color) {
				Color color = JColorChooser.showDialog(null, "Pick your color", Color.WHITE);
				zoneDessin.setColor(color);
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		new MainFrame();
		}

}
