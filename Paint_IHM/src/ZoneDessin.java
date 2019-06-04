import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ZoneDessin extends JPanel{
	private ArrayList<Figure> figures;
	private Color currentColor;
	private int currentFigure;
	private Figure figure;
	//0Line 1Rectangle 2Oval 3Cercle 4Triangle
	private boolean currentPlein;
	
	public ZoneDessin() {
		// TODO Auto-generated constructor stub
		figures = new ArrayList<Figure>();
		currentColor = Color.BLACK;
		currentPlein = false;
		currentFigure = 0;
		figure = null;
		setBackground(Color.WHITE);
		MouseHandler handler = new MouseHandler();                                    
        addMouseListener( handler );
        addMouseMotionListener( handler ); 
	}

	
	public void paintComponent( Graphics g )
    {
        super.paintComponent(g);
        for(int i =0; i<figures.size();i++) {
        	figures.get(i).dessiner(g);
        }
    }
	
	private class MouseHandler extends MouseAdapter 
    {
        public void mousePressed( MouseEvent event )
        {
            switch (currentFigure) //0Line 1Rectangle 2Oval 3Cercle 4Triangle
            {
                case 0:
                    figure= new Line( event.getX(), event.getY(), 
                                                   event.getX(), event.getY(), currentColor, currentPlein);
                    break;
                case 1:
                    figure = new Rectangle( event.getX(), event.getY(), 
                                                        event.getX(), event.getY(), currentColor, currentPlein);
                    break;
                case 2:
                    figure= new Oval( event.getX(), event.getY(), 
                                                   event.getX(), event.getY(), currentColor, currentPlein);
                    break;
                case 3:
                    figure= new Cercle( event.getX(), event.getY(), 
                                                   event.getX(), event.getY(), currentColor, currentPlein);
                    break;
                case 4:
                    figure= new Triangle( event.getX(), event.getY(), 
                                                   event.getX(), event.getY(), currentColor, currentPlein);
                    break;    
                    
            }
        }
        
        public void mouseReleased( MouseEvent event )
        {
            figure.setX2(event.getX());
            figure.setY2(event.getY());
            figures.add(figure); 
            figure=null; 
            repaint();
        }
        public void mouseDragged( MouseEvent event )
        {
            //sets currentShapeObject x2 & Y2
            figure.setX2(event.getX());
            figure.setY2(event.getY());
            figures.add(figure); 
            repaint();
            
        }
    }
}
