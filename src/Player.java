import java.awt.Graphics;

import javax.swing.ImageIcon;

class Player extends GameObject
{
	private int health; // Health of the player
	int speed; // Speed (in pixels) that the player will move
	private boolean movingUp, movingDown;

	public Player(String c, int x, int y, int h, int w, int l, int s, ImageIcon i, ImageIcon b)
	{
		color = c;
		posX = x;
		posY = y;
		height = h;
		width = w;
		health = l;
		speed = s;
		image = i;
		backGroundImage = b;		
	}

	@Override
	public void draw(Graphics g)
	{
		/*
		 * Paints the correct background image for the players (left and right images)
		 */
		if (color == "RED")
			g.drawImage(backGroundImage.getImage(), 3, 72, 100, 400, null);
		if (color == "BLUE")
			g.drawImage(backGroundImage.getImage(), 802, 72, 100, 400, null);

		/*
		 * Draws the player at the specified X and Y position
		 */
		g.drawImage(image.getImage(), posX, posY, 10, 100, null);
	}

	@Override
	public void update()
	{			
		/*
		 * Checks the players current health and applies the correct left or right image
		 */
		final int[] HEALTH_ONE = {76, 51, 26, 1, 0};
		final int[] HEALTH_TWO = {100, 75, 50, 25, 0};
		final String[] RED_IMAGE = { "/left100.jpg", "left75.jpg", "left50.jpg", "left25.jpg", "left0.jpg" };
		final String[] BLUE_IMAGE = { "/right100.jpg", "right75.jpg", "right50.jpg", "right25.jpg", "right0.jpg" };
		
		for(int i = 0; i < HEALTH_ONE.length; i++)
		{
			if (health >= HEALTH_ONE[i] && health <= HEALTH_TWO[i])
			{
				if (color.equals("RED"))
					setBackground(new ImageIcon(loadImage(RED_IMAGE[i])));
				if (color.equals("BLUE"))
					setBackground(new ImageIcon(loadImage(BLUE_IMAGE[i])));
			}
		}

		/*
		 * Deals with the bounds that the player is able to move within (75, 365)
		 * and the speed of the player (17pix)
		 */
		if (movingUp)
			posY = posY >= 75 ? posY - speed : posY - 0;
		else if (movingDown)
			posY = posY <= 365 ? posY + speed : posY - 0;
	}

	public void setHealth(int l)
	{
		health = l;
	}

	public int getHealth()
	{
		return health;
	}

	public void addHealth(int h)
	{
		health = health + h;
	}
	
	public void addDamage(int h)
	{
		health = health - h;
	}

	public void setMovingUp(boolean m)
	{
		movingUp = m;
	}

	public void setMovingDown(boolean m)
	{
		movingDown = m;
	}

}