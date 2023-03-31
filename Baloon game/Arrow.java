package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Arrow extends Thread implements VisibleObjects{
	
	Point location;
	int x,y = 0;
	int release = 0;
	Point Main;
	int delete = 0;
	
	public Arrow(int x,int y){
		this.x = x;
		this.y = y;
		this.location = new Point(x,y);
		this.Main = new Point(x-25,y);
		start();
	}

	@Override
	public void run() {
		while(location.x>-100) {
			System.out.print("");
			if(release == 1) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				location.x-=1;
				Main.x-=1;
			}
			
		}
		if(location.x>-100) {
			delete = 1;
		}
	}

	public Point getMain() {
		return Main;
	}

	public void setMain(Point main) {
		Main = main;
	}

	@Override
	public void display(Graphics g) {
		// TODO Auto-generated method stub
		int x[] = {location.x,location.x,location.x-25};
		int y[] = {location.y-25,location.y+25,location.y};
		g.setColor(new Color(0,0,0));
		g.fillRect(location.x, location.y-5, 50, 10);
		g.fillPolygon(new Polygon(x,y,3));
//		g.drawString("("+Main.x+","+Main.y+")",location.x-75,location.y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.location.x = x;
		this.x=x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.location.y = y;
		this.Main.y = y;
		this.y = y;
	}
	public void setR(int r) {
		this.release = r;
	}
	

}
