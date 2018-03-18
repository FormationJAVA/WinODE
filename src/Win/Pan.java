package Win;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import ODE.Function;
import ODE.Solve;

public class Pan extends JPanel implements MouseListener, MouseWheelListener,MouseMotionListener {
	Color c;
	int x;
	int y;
	boolean isEntered;
	double [][] x1;
	int scale=200;
	JButton bt1;
	
	Pan ()
	{
		int T= 500;
		double h=0.05;
		double x0[] = {Math.toRadians(30),
						0};
		
		Function pendule = new MyFunction();
		int dim = x0.length;
		x1 = Solve.Euler(pendule, x0, h, T);
		c = Color.blue;
		isEntered = false;
		this.bt1 = new JButton ("OK");
		this.add(bt1);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addMouseWheelListener(this);
		
	}
	
	public void paintComponent (Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());/**/
		g.setColor(Color.GREEN);
		//Axe X
		g.drawLine(0, y, this.getWidth(), y);
		//Axe Y
		g.drawLine(x, 0,x, this.getHeight());
		g.setColor(c);
		/*g.drawRect(30,30,500,500);
		g.drawLine(300, 50, 600, 600);*/
		for (int i=0;i<x1.length-1;i++)
		{
			g.drawLine( x+(int)Math.round(x1[i][0]*scale),
						y-(int)Math.round(x1[i][1]*scale),
						x+(int)Math.round(x1[i+1][0]*scale),
						y-(int)Math.round( x1[i+1][1]*scale));
		}
		/*if (isEntered)
		{
			g.drawRect(40, 40, 400, 400);
			g.drawOval(300, 300, 50, 50);
		}
		else
		{
			g.drawRect(40, 40, 480, 480);
			g.fillOval(300, 300, 50, 50);
		}*/
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scale+=e.getWheelRotation()*10;
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
			c = Color.RED;
			isEntered = !isEntered;
			this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		c = Color.blue;
		isEntered = !isEntered;
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseDragged(MouseEvent ev) {
		
	}
	@Override
	public void mouseMoved(MouseEvent ev) {
	x=ev.getX();
	y=ev.getY();
	this.repaint();
	}

}
