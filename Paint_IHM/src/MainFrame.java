import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class MainFrame extends JFrame{
	private ZoneDessin zoneDessin;
	public MainFrame() throws Exception{
		// TODO Auto-generated constructor stub
		super("Paint");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout(new BorderLayout());
        add(new ZoneDessin(), BorderLayout.CENTER);
        add(this.getPanelWest(), BorderLayout.WEST);
        setSize(1080,768);
        setVisible(true);
        }
	
	public JPanel getPanelWest() {
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(5, 1, 10, 10));
		pan.add(new JButton("Cercle"));
		pan.add(new JButton("Line"));
		pan.add(new JButton("Oval"));
		pan.add(new JButton("Rectangle"));
		pan.add(new JButton("Triangle"));
		return pan;
	}
	
	public static void main(String[] args) throws Exception {
		new MainFrame();
		}

}
