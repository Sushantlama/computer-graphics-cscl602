package draw;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyCanvas extends JPanel{
	
	public MyCanvas() {
		setBackground(Color.WHITE);
	}
	void drawPixel(Graphics g,double x_,double y_) {
		int x = (int) Math.round(x_);
		int y = (int) Math.round(y_);
		g.fillOval(x, y, 1, 1);
	}
	//top corner = 0,0
	//center = 400,400
	//end corner = 800,800
	void drawLine(int val,int x1, int y1, int x2, int y2) {
		Graphics g = getGraphics();
		
//		g.drawLine(x1, y1, x2, y2);
		if (val == 1) {
			para(g,x1,y1,x2,y2);
			System.out.println("parametric form");
		}
		else if(val == 2) {
			dda(g,x1,y1,x2,y2);
			System.out.println("dda form");
		}
		
		
	}
	void para(Graphics g,int x1,int y1,int x2,int y2) {
		for(double t = 0;t<=1;t+=0.001) {
			int x = (int)Math.round((1-t)*x1+t*x2);
			int y = (int)Math.round((1-t)*y1+t*y2);
			drawPixel(g,400+x,400-y);
		}
	}
	void dda(Graphics g,int x1,int y1,int x2,int y2) {
		int dx = x1-x2;
		int dy = y1-y2;
		int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);
		double x_lnc = ((double)dx)/((double)steps);
		double y_lnc = ((double)dy)/((double)steps);	
		for(int i = 0;i<=steps;i++) {
			drawPixel(g,400+(x1+i*x_lnc),400-(y1+i*y_lnc));
		}
	}
}
