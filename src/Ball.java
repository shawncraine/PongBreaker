import java.awt.Graphics;

import javax.swing.ImageIcon;

class Ball extends GameObject
{
	private int speedX, speedY; // Speed (in pixels) that the ball will move

	public Ball(String c, int x, int y, int h, int w, int sX, int sY, ImageIcon i)
	{
		color = c;
		posX = x;
		posY = y;
		height = h;
		width = w;
		speedX = sX;
		speedY = sY;
		image = i;
	}

	@Override
	public void draw(Graphics g) {
		/*
		 * Draws the ball at the specified X and Y position
		 */
		g.drawImage(image.getImage(), posX, posY, height, width, null);
	}

	@Override
	public void update() {
		if (posY < 80 || posY > 455)
			speedY *= -1;
		
		posX += speedX;
		posY += speedY;
	}

	public void blockCollision(Block b)
	{
		// find center of block
		int midPointX = b.posX + b.width/2 - 1;
		int midPointY = b.posY + b.height/2 - 1;
		
		// find center of ball
		int ballMidPointX = posX + width/2 - 1;
		int ballMidPointY = posY + width/2 - 1;
		
		// convert to vector
		int vectorX = ballMidPointX - midPointX;
		int vectorY = ballMidPointY - midPointY;
		
		// find angle of ball relative to block
		double angle = Math.atan(vectorY/(vectorX + 0.001));
		double angleDegrees = angle * 180.0 / (2 * Math.PI);
		
		if(angleDegrees > -45 && angleDegrees < 45)
			speedX *= -1;
		else
			speedY *= -1;
	}

	public void redirect()
	{
		speedX *= -1;

		if (speedY > 10)
			speedY = (int) (speedY - ((Math.random() * 2.5) * (Math.random() * 2.5)));
		else
			speedY = (int) (speedY + ((Math.random() * 2.5) * (Math.random() * 2.5)));
	}

	public void detectWallCollision(Player p)
	{
		if (posY >= p.posY && posY <= p.posY + p.height - 1)
		{
			redirect();
			return;
		} else {
			redirect();
			p.addDamage(25);
		}
	}

	public void setSpeed(int sX, int sY)
	{
		speedX = sX;
		speedY = sY;
	}

	public int getSpeedX()
	{
		return speedX;
	}

	public int getSpeedY()
	{
		return speedY;
	}
}