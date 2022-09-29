import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;

public class Game extends JFrame implements KeyListener{
	
	Random random = new Random();
	
	int boulders[][];
	int playerX, playerY, playerV, score;
	boolean left, right, jump, onSurface, flag = true;
	
	Game() throws InterruptedException{
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.addKeyListener(this);
		this.setVisible(true);
		
		playerX = this.getWidth() / 2 - 100;
		playerY = this.getHeight() - 220;
		boulders = new int[][] {{random.nextInt(100, Math.max(100, this.getWidth() - 200)), 0, random.nextInt(100, 200)},
								{random.nextInt(100, Math.max(100, this.getWidth() - 200)), 0, random.nextInt(100, 200)},
								{random.nextInt(100, Math.max(100, this.getWidth() - 200)), 0, random.nextInt(100, 200)},
								{random.nextInt(100, Math.max(100, this.getWidth() - 200)), 0, random.nextInt(100, 200)},
								{random.nextInt(100, Math.max(100, this.getWidth() - 200)), 0, random.nextInt(100, 200)},
								{random.nextInt(100, Math.max(100, this.getWidth() - 200)), 0, random.nextInt(100, 200)},
								{random.nextInt(100, Math.max(100, this.getWidth() - 200)), 0, random.nextInt(100, 200)}};
		
		while(flag) {
			
			if(right == true && playerX < this.getWidth() - 100) {
				
				playerX += 2;
				
			}
			
			if(left == true && playerX > 0)
				playerX -= 2;
			
			if(playerX > this.getWidth() - 100)
				playerX = this.getWidth() - 100;
			if(playerY > this.getHeight() - 220)
				playerY = this.getHeight() - 220;			
			
				if(playerY < this.getHeight() - 220)
					playerV -= 1;
				else
					playerV = 0;
				
				if(playerY >= this.getHeight() - 220)
					onSurface = true;
				else
					onSurface = false;
				
				if(jump == true && onSurface == true)
					playerV = 200;
				
				playerY -= playerV / 50;
				
				if(boulders[0][1] < this.getHeight())
					boulders[0][1] += 1;
				else {
					
				boulders[0][2] = random.nextInt(100, 200);
				boulders[0][0] = random.nextInt(0, this.getWidth() - boulders[0][2]);
				boulders[0][1] = -boulders[0][2];
					
				}
				
				if(boulders[1][1] < this.getHeight())
					boulders[1][1] += 1;
				else {
					
				boulders[1][2] = random.nextInt(100, 200);
				boulders[1][0] = random.nextInt(0, this.getWidth() - boulders[1][2]);
				boulders[1][1] = -boulders[1][2];
					
				}
				
				if(boulders[2][1] < this.getHeight())
					boulders[2][1] += 1;
				else {
					
				boulders[2][2] = random.nextInt(100, 200);
				boulders[2][0] = random.nextInt(0, this.getWidth() - boulders[2][2]);
				boulders[2][1] = -boulders[2][2];
					
				}
				
				if(boulders[3][1] < this.getHeight())
					boulders[3][1] += 1;
				else {
					
				boulders[3][2] = random.nextInt(100, 200);
				boulders[3][0] = random.nextInt(0, this.getWidth() - boulders[3][2]);
				boulders[3][1] = -boulders[3][2];
					
				}
				
				if(boulders[4][1] < this.getHeight())
					boulders[4][1] += 1;
				else {
					
				boulders[4][2] = random.nextInt(100, 200);
				boulders[4][0] = random.nextInt(0, this.getWidth() - boulders[4][2]);
				boulders[4][1] = -boulders[4][2];
					
				}
				
				if(boulders[5][1] < this.getHeight())
					boulders[5][1] += 1;
				else {
					
				boulders[5][2] = random.nextInt(100, 200);
				boulders[5][0] = random.nextInt(0, this.getWidth() - boulders[0][2]);
				boulders[5][1] = -boulders[0][2];
					
				}
				
				if(boulders[6][1] < this.getHeight())
					boulders[6][1] += 1;
				else {
					
				boulders[6][2] = random.nextInt(100, 200);
				boulders[6][0] = random.nextInt(0, this.getWidth() - boulders[6][2]);
				boulders[6][1] = -boulders[6][2];
					
				}
				
				if(playerY >= boulders[0][1] && playerY <= boulders[0][1] + boulders[0][2] && playerX >= boulders[0][0] && playerX <= boulders[0][0] + boulders[0][2] || playerY >= boulders[0][1] && playerY <= boulders[0][1] + boulders[0][2] && playerX + 100 >= boulders[0][0] && playerX + 100 <= boulders[0][0] + boulders[0][2] ||
				   playerY >= boulders[1][1] && playerY <= boulders[1][1] + boulders[1][2] && playerX >= boulders[1][0] && playerX <= boulders[1][0] + boulders[1][2] || playerY >= boulders[1][1] && playerY <= boulders[1][1] + boulders[1][2] && playerX + 100 >= boulders[1][0] && playerX + 100 <= boulders[1][0] + boulders[1][2] ||
				   playerY >= boulders[2][1] && playerY <= boulders[2][1] + boulders[2][2] && playerX >= boulders[2][0] && playerX <= boulders[2][0] + boulders[2][2] || playerY >= boulders[2][1] && playerY <= boulders[2][1] + boulders[2][2] && playerX + 100 >= boulders[2][0] && playerX + 100 <= boulders[2][0] + boulders[2][2] ||
				   playerY >= boulders[3][1] && playerY <= boulders[3][1] + boulders[3][2] && playerX >= boulders[3][0] && playerX <= boulders[3][0] + boulders[3][2] || playerY >= boulders[3][1] && playerY <= boulders[3][1] + boulders[3][2] && playerX + 100 >= boulders[3][0] && playerX + 100 <= boulders[3][0] + boulders[3][2] ||
				   playerY >= boulders[4][1] && playerY <= boulders[4][1] + boulders[4][2] && playerX >= boulders[4][0] && playerX <= boulders[4][0] + boulders[4][2] || playerY >= boulders[4][1] && playerY <= boulders[4][1] + boulders[4][2] && playerX + 100 >= boulders[4][0] && playerX + 100 <= boulders[4][0] + boulders[4][2] ||
				   playerY >= boulders[5][1] && playerY <= boulders[5][1] + boulders[5][2] && playerX >= boulders[5][0] && playerX <= boulders[5][0] + boulders[5][2] || playerY >= boulders[5][1] && playerY <= boulders[5][1] + boulders[5][2] && playerX + 100 >= boulders[5][0] && playerX + 100 <= boulders[5][0] + boulders[5][2] ||
				   playerY >= boulders[6][1] && playerY <= boulders[6][1] + boulders[6][2] && playerX >= boulders[6][0] && playerX <= boulders[6][0] + boulders[6][2] || playerY >= boulders[6][1] && playerY <= boulders[6][1] + boulders[6][2] && playerX + 100 >= boulders[6][0] && playerX + 100 <= boulders[6][0] + boulders[6][2])
					flag = false;
					
					repaint();
				
					score += 1;
					
			Thread.sleep(2);
			
		}
		
	}	
	
public void paint(Graphics g) {
	
		Graphics2D paint = (Graphics2D) g;
		
		super.paint(g);
		paint.fillRect(playerX, playerY, 100, 220);
		
		paint.fillOval(boulders[0][0], boulders[0][1], boulders[0][2], boulders[0][2]);
		paint.fillOval(boulders[1][0], boulders[1][1], boulders[1][2], boulders[1][2]);
		paint.fillOval(boulders[2][0], boulders[2][1], boulders[2][2], boulders[2][2]);
		paint.fillOval(boulders[3][0], boulders[3][1], boulders[3][2], boulders[3][2]);
		paint.fillOval(boulders[4][0], boulders[4][1], boulders[4][2], boulders[4][2]);
		paint.fillOval(boulders[5][0], boulders[5][1], boulders[5][2], boulders[5][2]);
		paint.fillOval(boulders[6][0], boulders[6][1], boulders[6][2], boulders[6][2]);
		
		if(flag == false) {
			
			paint.setColor(Color.red);
			paint.setFont(new Font("Serif", Font.BOLD, 200));
			paint.drawString("Game Over", this.getWidth() / 2 - 600, this.getHeight() / 2);
			paint.setColor(Color.blue);
			paint.drawString("Score: " + Integer.toString(score / 100), this.getWidth() / 2 - 600, this.getHeight() / 2 + 150);
		
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
		case 65: left = true;
		break;
		case 68: right = true;
		break;
		case 37: left = true;
		break;
		case 39: right = true;
		break;
		case 100: left = true;
		break;
		case 102: right = true;
		break;
		case 32: jump = true;
		break;
		case 87: jump = true;
		break;
		case 104: jump = true;
		break;
		case 101: jump = true;
		break;
		case 38: jump = true;
		break;
		
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
		case 65: left = false;
		break;
		case 68: right = false;
		break;
		case 37: left = false;
		break;
		case 39: right = false;
		break;
		case 100: left = false;
		break;
		case 102: right = false;
		break;
		case 32: jump = false;
		break;
		case 87: jump = false;
		break;
		case 104: jump = false;
		break;
		case 101: jump = false;
		break;
		case 38: jump = false;
		break;
		
		}
		
	}

}
