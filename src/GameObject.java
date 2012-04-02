import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

abstract class GameObject
{
	protected ImageIcon image; // Image of the object
	protected ImageIcon backGroundImage; // Background image
	protected String color; // Color of the object
	protected int posX, posY; // X and Y location of the object
	protected int height, width; // Height and Width of the object
	
	abstract void draw(Graphics g);
	abstract void update();

	protected BufferedImage loadImage(String i) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource(i));
		} catch (IOException e) {
			System.out.println(i + " was not found.");
		}
		return image;
	}

	public void setColor(String c)
	{
		color = c;
	}

	public String getColor()
	{
		return color;
	}

	public void setPositionX(int x)
	{
		posX = x;
	}

	public int getPositionX()
	{
		return posX;
	}

	public void setPositionY(int y)
	{
		posY = y;
	}

	public int getPositionY()
	{
		return posY;
	}

	public void setHeight(int h)
	{
		height = h;
	}

	public int getHeight()
	{
		return height;
	}

	public void setWidth(int w)
	{
		width = w;
	}

	public int getWidth()
	{
		return width;
	}

	public void setImage(ImageIcon i)
	{
		image = i;
	}

	public ImageIcon getImage()
	{
		return image;
	}

	public void setBackground(ImageIcon i)
	{
		backGroundImage = i;
	}

	public ImageIcon getBackground()
	{
		return backGroundImage;
	}
}