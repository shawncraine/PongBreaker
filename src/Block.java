import java.awt.Graphics;

import javax.swing.ImageIcon;

class Block extends GameObject
{

	public Block(String c, int x, int y, int h, int w, ImageIcon i)
	{
		color = c;
		posX = x;
		posY = y;
		height = h;
		width = w;
		image = i;
	}

	@Override
	public void draw(Graphics g) {
		/*
		 * Draws the block at the specified X and Y position
		 */
		g.drawImage(image.getImage(), posX, posY, width, height, null);
	}

	public boolean detectBallCollision(Ball b)
	{
		return pointInRectangle(b.posX, b.posY) ||
				pointInRectangle(b.posX + b.height - 1, b.posY + b.width - 1) ||
				pointInRectangle(b.posX + b.width - 1, b.posY + b.height - 1) ||
				pointInRectangle(b.posX, b.posY + b.width - 1);
	}

	private boolean pointInRectangle(int x, int y)
	{
		// add border of 10 to top and left
		int leftSide = posX ;
		int rightSide = posX + width - 1;
		int topSide = posY;
		int bottomSide = posY + height - 1;

		return (leftSide <= x && x <= rightSide && topSide <= y && y <= bottomSide);
	}

	@Override
	public void update() {
		
	}
}