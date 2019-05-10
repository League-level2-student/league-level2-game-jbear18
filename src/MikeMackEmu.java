import java.awt.Dimension;

import javax.swing.JFrame;

public class MikeMackEmu{
	GamePanel gamepanel;
	final static int WIDTH = 500;
	final static int HEIGHT = 800;
	JFrame frame;
	public static void main(String[] args) {
MikeMackEmu emu= new MikeMackEmu();
emu.setup();
	}
	public MikeMackEmu() {
		frame = new JFrame("MikeMackEmu");
		gamepanel= new GamePanel();
	}
	public void setup() {
		frame.add(gamepanel);
		frame.addKeyListener(gamepanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.setPreferredSize(new Dimension(500, 800));
		frame.pack();
		gamepanel.startGame();

	}
}
