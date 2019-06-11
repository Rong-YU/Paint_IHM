import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class MainFrame extends JFrame implements KeyListener, ActionListener{
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
	private JComboBox size;
	JFileChooser chooser;
	String choosertitle;
	
	
	//private BoutonListener blis = new BoutonListener();
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
		save.addActionListener(this);
		load.addActionListener(this);
		pan.add(save);
		pan.add(load);
		JLabel text = new JLabel("Size:");
		pan.add(text);
		size = new JComboBox(); 
		size.addActionListener(this);
		for(int i =1;i<33;i++) {
			size.addItem(i);
		}
		pan.add(size);
		
		
		return pan;
	}
	
	public JPanel getPanelWest() {
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(6, 2));
		cercle = new JButton("Cercle",new ImageIcon(this.getClass().getResource("/images/cercle.png")));
		line = new JButton("Line",new ImageIcon(this.getClass().getResource("/images/segment.png")));
		oval = new JButton("Oval",new ImageIcon(this.getClass().getResource("/images/oval.png")));
		rectangle = new JButton("Rectangle",new ImageIcon(this.getClass().getResource("/images/rectangle.png")));
		triangle = new JButton("Triangle",new ImageIcon(this.getClass().getResource("/images/triangle.png")));
		text = new JButton("Text",new ImageIcon(this.getClass().getResource("/images/text.png")));
		color = new JButton("Color",new ImageIcon(this.getClass().getResource("/images/color.png")));
		fill = new JButton("Fill",new ImageIcon(this.getClass().getResource("/images/cercle.png")));
		pencil = new JButton("Pencil",new ImageIcon(this.getClass().getResource("/images/pencil.png")));
		undo = new JButton("Undo",new ImageIcon(this.getClass().getResource("/images/undo.png")));
		clear = new JButton("Clear",new ImageIcon(this.getClass().getResource("/images/clear.png")));
		eraser = new JButton("Eraser",new ImageIcon(this.getClass().getResource("/images/eraser1.png")));
		
		cercle.addActionListener(this);
		line.addActionListener(this);
		oval.addActionListener(this);
		rectangle.addActionListener(this);
		triangle.addActionListener(this);
		text.addActionListener(this);
		color.addActionListener(this);
		fill.addActionListener(this);
		pencil.addActionListener(this);
		undo.addActionListener(this);
		clear.addActionListener(this);
		eraser.addActionListener(this);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		this.requestFocus();
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
			if(zoneDessin.getPlein()) {
				this.fill.setIcon(new ImageIcon(this.getClass().getResource("/images/plein.png")));
			}
			else {
				this.fill.setIcon(new ImageIcon(this.getClass().getResource("/images/cercle.png")));
			}
			System.out.println("setPlein");
		}
		else if(e.getSource()==color) {
			Color color = JColorChooser.showDialog(null, "Pick your color", Color.WHITE);
			zoneDessin.setColor(color);
			this.color.setBackground(color);
			this.color.setOpaque(true);
		}
		else if(e.getSource()==undo) {
			zoneDessin.removeLast();
		}
		else if(e.getSource()==clear) {
			zoneDessin.removeAll();
		}
		else if(e.getSource()==save) {
			//zoneDessin.sauve("test");
			JFileChooser filechooser = new JFileChooser();
			if(filechooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File file = filechooser.getSelectedFile();
				zoneDessin.sauve(file);
			}
			

		}
		else if(e.getSource()==load) {
			//zoneDessin.charge("test");
			JFileChooser filechooser = new JFileChooser();
			if(filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				File file = filechooser.getSelectedFile();
				zoneDessin.charge(file);
			}
			zoneDessin.repaint();
		}
		else if(e.getSource()==size) {
			zoneDessin.setLineSize(size.getSelectedIndex()+1);
		}
	}


}
