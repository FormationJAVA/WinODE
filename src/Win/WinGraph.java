package Win;

import java.awt.Color;

import javax.swing.JFrame;

public class WinGraph extends JFrame {
	private Pan panel;
	public WinGraph()
	{
		panel =new Pan();
		this.add(panel);
		this.setTitle("Euler");
		this.setSize(800, 800);
		this.setBackground(Color.GREEN);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		WinGraph wg = new WinGraph();
	}

}
