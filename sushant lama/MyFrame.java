package draw;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {

	MyCanvas canvas = new MyCanvas();
	
	public MyFrame() {
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	private void initComponents() {
		JPanel topPanel = new JPanel();
		JButton lineBtn1 = new JButton("Draw Line Using Parametric form");
		lineBtn1.addActionListener(this);
		JButton lineBtn2 = new JButton("Draw Line Using DDA form");
		lineBtn2.addActionListener(this);
		topPanel.add(lineBtn1);
		topPanel.add(lineBtn2);
		add(topPanel,BorderLayout.NORTH);	
		add(canvas);	
	}

	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equalsIgnoreCase("Draw Line Using Parametric form")) {
			String temp = JOptionPane.showInputDialog("Enter x1,y1");
			int x1 = Integer.parseInt(temp.split(",")[0]);
			int y1 = Integer.parseInt(temp.split(",")[1]);
			temp = JOptionPane.showInputDialog("Enter x2,y2");
			int x2 = Integer.parseInt(temp.split(",")[0]);
			int y2 = Integer.parseInt(temp.split(",")[1]); 
			canvas.drawLine(1,x1, y1, x2, y2);
		}else if(cmd.equalsIgnoreCase("Draw Line Using DDA form")) {
			String temp = JOptionPane.showInputDialog("Enter x1,y1");
			int x1 = Integer.parseInt(temp.split(",")[0]);
			int y1 = Integer.parseInt(temp.split(",")[1]);
			temp = JOptionPane.showInputDialog("Enter x2,y2");
			int x2 = Integer.parseInt(temp.split(",")[0]);
			int y2 = Integer.parseInt(temp.split(",")[1]); 
			canvas.drawLine(2,x1, y1, x2, y2);
		}

		
	}

}
