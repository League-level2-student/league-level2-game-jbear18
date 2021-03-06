import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Emu extends GameObject {
	int speed;
	boolean left;
	boolean right;
	int velocity = 0;
	boolean isJumping = false;
	Rectangle head;
	Rectangle body;
	Rectangle neck;
	Rectangle legs;

	public Emu(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		head = new Rectangle();
		neck = new Rectangle();
		body = new Rectangle();
		legs = new Rectangle();
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		if (left == true && x > 0) {
			x -= speed;

		}
		if (right == true && x < MikeMackEmu.WIDTH - width) {
			x += speed;

		}
		if (isJumping) {
			velocity--;
			y = y - velocity;
			if (y < 0) {
				y += 5;
				velocity = 0;
			}
			if (y > 400) {
				y = 400;
				isJumping = false;
			}
		}
		head.setBounds((int) (x + (8.0 / 11.0 * width)), y, width / 7, height / 10);
		body.setBounds((int) (x + 1.5 / 11.0 * width), (int) (y + 2.499 / 11.0 * height), (int) (width * 0.64),
				(int) (height * 0.39));
		legs.setBounds((int) (x + 7.5 / 20.0 * width), (int) (y + 6.0 / 10.0 * height), (int) (width * 0.3),
				(int) (height * 0.4));
		neck.setBounds((int) (x + 8.2 / 11.0 * width), (int) (y + height / 10.0), (int) (width / 14),
				(int) (height * 0.39));

	}

	public void jump() {
		isJumping = true;
		velocity = 25;

	}

	public boolean collidesWith(Rectangle r) {
		if (r.intersects(head) || r.intersects(body) || r.intersects(neck) || r.intersects(legs)) {
			return true;
		}
		return false;
	}

	void draw(Graphics g) {
		
		if(left==true) {
			g.drawImage(GamePanel.emuLeftImg, x, y, width, height, null);
		}else {
			g.drawImage(GamePanel.emuImg, x, y, width, height, null);
			
		}
		
		super.draw(g);

	}
}
