import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
		currentFigure = 5;
		figure = null;
		setBackground(Color.WHITE);
		MouseHandler handler = new MouseHandler();                                    
        addMouseListener( handler );
        addMouseMotionListener( handler ); 
	}
	
	public void setColor(Color c) {
		currentColor = c;
	}
	
	public void setFigure(int n) {
		currentFigure = n;
	}
	
	public void setPlein(Boolean plein) {
		currentPlein = plein;
	}
	
	public boolean getPlein() {
		return currentPlein;
	}
	
	public void removeLast() {
		if(figures.size()>0) {
			figures.remove(figures.size()-1);
			repaint();
		}
	}
	
	public void removeAll() {
		figures.clear();
		repaint();
	}
	
	public void sauve(String nomFichier){
	    try{
	      BufferedWriter bw = new BufferedWriter(new FileWriter(new File(nomFichier)));

	      for(Figure figure : this.figures){
	    	  if(!(figure instanceof Pencil)) {
	    		  bw.write(figure.getClass() + "\t"+ figure.getColor().getRGB() + "\t"+ figure.getPlein() +"\t"+ figure.getX1() 
	        			+ "\t" + figure.getY1()+ "\t"+ figure.getX2()+ "\t"+ figure.getY2()  +"\n");
	      
	    	  }
	    	  else {
	    		  String s=((Pencil) figure).getXY();
	    		  bw.write(figure.getClass() + "\t"+ figure.getColor().getRGB() + "\t"+ figure.getPlein() +"\t"+ s+"\n");
	    	  }
	      }
	      bw.close();
	    }catch(IOException e){
	      System.out.println(e);
	    }
	  }
	
	public void charge(String nomFichier){
	    try{
	      if(this.figures.size() != 0){
	        this.figures.clear();
	      }
	      FileReader fr = new FileReader(new File(nomFichier));
	      BufferedReader br = new BufferedReader(fr);
	      String line = br.readLine();
	      while(line != null){
	        StringTokenizer st = new StringTokenizer(line, "\t");
	        String className = st.nextToken().substring(6);
	        Color color = new Color(Integer.valueOf(st.nextToken()));
	        boolean plein = Boolean.valueOf(st.nextToken());
	        if(!className.equals("Pencil")) {
	        	int x1,x2,y1,y2;
	        	x1= Integer.valueOf(st.nextToken());
	        	y1=Integer.valueOf(st.nextToken());
	        	x2=Integer.valueOf(st.nextToken());
	        	y2=Integer.valueOf(st.nextToken());
	        	switch(className) {
		        	case "Cercle": figure = new Cercle(x1, y1, x2, y2, color, plein);break;
		        	case "Line": figure = new Line(x1, y1, x2, y2, color, plein);break;
		        	case "Oval": figure = new Oval(x1, y1, x2, y2, color, plein);break;
		        	case "Rectangle": figure = new Rectangle(x1, y1, x2, y2, color, plein);break;
		        	case "Triangle": figure = new Triangle(x1, y1, x2, y2, color, plein);((Triangle) figure).calcCoor();break;
	        	}
	        }
	        else {
	        	String coordonnes = st.nextToken();
	        	figure = new Pencil(0, 0, 0, 0, color, plein);
	        	StringTokenizer coords = new StringTokenizer(coordonnes, ";");
	        	while(coords.hasMoreTokens()) {
	        		String[] s = coords.nextToken().split(",");
	        		((Pencil) figure).addPoint(Integer.valueOf(s[0]), Integer.valueOf(s[1]));
	        	}
	        	
	        }
	        figures.add(figure);
	        line = br.readLine();
	      }
	      br.close();
	      fr.close();
	    }catch(IOException e){
	      System.out.println(e);
	    }
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
                case 5:
                	figure= new Pencil( event.getX(), event.getY(), 
                            event.getX(), event.getY(), currentColor, currentPlein);
                	break;
            }
            figures.add(figure);
            
        }
        
        public void mouseReleased( MouseEvent event )
        {
        	/*
        	if(currentFigure != 5) {
            figure.setX2(event.getX());
            figure.setY2(event.getY());
            figures.add(figure); 
            figure=null; 
            repaint();
        	}
        	else {
        		figures.add(figure); 
                figure=null; 
                repaint();
        	}
        	*/
        	System.out.println(figures.size());
        	
        }
        public void mouseDragged( MouseEvent event )
        {
      
        	if(currentFigure != 5) {
	            figures.get(figures.size()-1).setX2(event.getX());
	            figures.get(figures.size()-1).setY2(event.getY());
	            repaint();
	        }
        	else {
        		
        		((Pencil) figures.get(figures.size()-1)).addPoint(event.getX(),event.getY());
        		repaint();
        	}
        }
        	
    }
}
