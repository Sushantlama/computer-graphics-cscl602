package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.concurrent.ThreadLocalRandom;

public class Baloon extends Thread implements VisibleObjects{

	Point location;
	Point top ;
	Point bottom;
	Point left;
	Point right;
	int x,y = 0;
	Color color ;
	
	public Baloon(Point l) {
		location = l;
		top = new Point(location.x , location.y - 75);
		bottom = new Point(location.x , location.y);
		left = new Point(location.x - 75 , location.y - 50);
		right = new Point(location.x + 25 , location.y - 50);
		
		x = l.x;
		y = l.y;
		color = getMyColor();
		start();
		
	}
	
	public Point getTop() {
		return top;
	}

	public void setTop(Point top) {
		this.top = top;
	}

	public Point getBottom() {
		return bottom;
	}

	public void setBottom(Point bottom) {
		this.bottom = bottom;
	}

	public Point getLeft() {
		return left;
	}

	public void setLeft(Point left) {
		this.left = left;
	}

	public Point getRight() {
		return right;
	}

	public void setRight(Point right) {
		this.right = right;
	}

	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}

	@Override
	public void run() {
		while(location.y>0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			location.y-=1;
			top.y-=1;
			bottom.y-=1;
			right.y-=1;
			left.y-=1;
		}
	}
	
	@Override
	public void display(Graphics g) {
		int x[] = {location.x,location.x-25,location.x+25};
		int y[] = {location.y,location.y-50,location.y-50};
		g.setColor(color);
		g.fillPolygon(new Polygon(x,y,3));
		g.fillArc(location.x-25, location.y-75, 50, 50, 0, 180);
		
//		g.drawString("("+top.x+","+top.y+")", top.x, top.y);
//		g.drawString("("+bottom.x+","+bottom.y+")",bottom.x,bottom.y);
//		g.drawString("("+left.x+","+left.y+")",left.x,left.y);
//		g.drawString("("+right.x+","+right.y+")",right.x,right.y);
		
	}
	
	public Color getMyColor(){
		int r = ThreadLocalRandom.current().nextInt(0,255);
		int g = ThreadLocalRandom.current().nextInt(0,255);
		int b = ThreadLocalRandom.current().nextInt(0,255);
		return new Color(r,g,b);
	}


}
