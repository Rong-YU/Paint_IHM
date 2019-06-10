import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class MainFrame extends JFrame implements KeyListener{
	private static final String    CTRL_C                = "CTRL+C"; 
	private static final String    CTRL_Z                = "CTRL+Z"; 
	 
	private ZoneDessin zoneDessin = new ZoneDessin();
	private JButton cercle;
	private JButton line;
	private JButton oval;
	private JButton rectangle;
	private JButton triangle;
	private JButton text;
	private JButton color;
	private JButton fill;
	private JButton pencil;
	private JButton eraser;
	private JButton undo;
	private JButton clear;
	private JButton save;
	private JButton load;
	
	
	private BoutonListener blis = new BoutonListener();
	public MainFrame() throws Exception{
		// TODO Auto-generated constructor stub
		super("Paint");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout(new BorderLayout());
		
        add(zoneDessin, BorderLayout.CENTER);
        add(this.getPanelWest(), BorderLayout.WEST);
        add(this.getPanelNorth(), BorderLayout.NORTH);
        setSize(1080,768);
        setVisible(true);
        addKeyListener(this);
        setFocusable(true);
        }
	
	public JPanel getPanelNorth() {
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout(0));
		save = new JButton("Save");
		load = new JButton("Load");
		save.addActionListener(blis);
		load.addActionListener(blis);
		pan.add(save);
		pan.add(load);
		return pan;
	}
	
	public JPanel getPanelWest() {
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(6, 2, 7, 7));
		cercle = new JButton("Cercle");
		line = new JButton("Line");
		oval = new JButton("Oval");
		rectangle = new JButton("Rectangle");
		triangle = new JButton("Triangle");
		text = new JButton("Text");
		color = new JButton("Color");
		fill = new JButton("Fill");
		pencil = new JButton("Pencil");
		undo = new JButton("Undo");
		clear = new JButton("Clear");
		eraser = new JButton("Eraser");
		
		cercle.addActionListener(blis);
		line.addActionListener(blis);
		oval.addActionListener(blis);
		rectangle.addActionListener(blis);
		triangle.addActionListener(blis);
		text.addActionListener(blis);
		color.addActionListener(blis);
		fill.addActionListener(blis);
		pencil.addActionListener(blis);
		undo.addActionListener(blis);
		clear.addActionListener(blis);
		eraser.addActionListener(blis);
		
		pan.add(pencil);
		pan.add(line);
		pan.add(rectangle);
		pan.add(oval);
		pan.add(cercle);
		pan.add(triangle);
		pan.add(text);
		pan.add(fill);
		pan.add(color);
		pan.add(eraser);
		pan.add(undo);
		pan.add(clear);
		return pan;
	}
	
	class BoutonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==line) {
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
			else if(e.getSource()==pencil) {
				zoneDessin.setFigure(5);
			}
			else if(e.getSource()==text) {
				zoneDessin.setFigure(6);
			}
			else if(e.getSource()==eraser) {
				zoneDessin.setFigure(8);
			}
			
			else if(e.getSource()==fill) {
				zoneDessin.setPlein(!zoneDessin.getPlein());
			}
			else if(e.getSource()==color) {
				Color color = JColorChooser.showDialog(null, "Pick your color", Color.WHITE);
				zoneDessin.setColor(color);
			}
			else if(e.getSource()==undo) {
				zoneDessin.removeLast();
			}
			else if(e.getSource()==clear) {
				zoneDessin.removeAll();
			}
			else if(e.getSource()==save) {
				zoneDessin.sauve("test");
			}
			else if(e.getSource()==load) {
				zoneDessin.charge("test");
				zoneDessin.repaint();
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		new MainFrame();
		}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			zoneDessin.setFigure(0);
			zoneDessin.setPlein(true);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_S)) {
			zoneDessin.setFigure(0);
			zoneDessin.setPlein(false);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			zoneDessin.setFigure(1);
			zoneDessin.setPlein(true);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_R)) {
			zoneDessin.setFigure(1);
			zoneDessin.setPlein(false);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_E) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			zoneDessin.setFigure(2);
			zoneDessin.setPlein(true);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_E)) {
			zoneDessin.setFigure(2);
			zoneDessin.setPlein(false);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			zoneDessin.setFigure(3);
			zoneDessin.setPlein(true);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_C)) {
			zoneDessin.setFigure(3);
			zoneDessin.setPlein(false);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			zoneDessin.setFigure(4);
			zoneDessin.setPlein(true);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_T)) {
			zoneDessin.setFigure(4);
			zoneDessin.setPlein(false);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_Q) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			zoneDessin.setFigure(5);
			zoneDessin.setPlein(true);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_Q)) {
			zoneDessin.setFigure(5);
			zoneDessin.setPlein(false);
        }
		else if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			zoneDessin.removeLast();
        }
		else if ((e.getKeyCode() == KeyEvent.VK_W)) {
			Color color = JColorChooser.showDialog(null, "Pick your color", Color.WHITE);
			zoneDessin.setColor(color);
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
    
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
