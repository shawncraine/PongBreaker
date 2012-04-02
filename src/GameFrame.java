import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

class GameFrame extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;
	private Image image;
	private Graphics graphics;
	private ImageIcon topImage, botImage, backGroundImage;
	private LinkedList list = new LinkedList();
	private Player playerOne, playerTwo;
	
	@SuppressWarnings("unused")
	private Block G_Block, G_Block1, G_Block2, G_Block3, B_Block, B_Block1, B_Block2, B_Block3,
					B_Block4, B_Block5, B_Block6, R_Block, R_Block1, R_Block2, R_Block3, R_Block4,
					R_Block5, R_Block6;
	
	private Ball playerOneBall, playerTwoBall;

	public GameFrame()
	{
		mainFrame();
	}
	
	private void mainFrame()
	{
		JProgressBar playerOneBar, playerTwoBar;

		// Add an icon to the frame
		setIconImage(loadImage("/icon.png"));

		// Set a title on the frame
		setTitle( "Pong Breaker" );

		// Set the size of the JFrame
		setSize(905, 525);

		// Set the location of the program on the screen
		setLocation(200, 100);

		// Set frame layout
		setLayout(new BorderLayout());

		// Set Resizing option
		setResizable(false);

		// Set default closing operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set a KeyListener to the JFrame
		addKeyListener(this);

		topImage = new ImageIcon(loadImage("/top.jpg"));
		botImage = new ImageIcon(loadImage("/bottom.jpg"));
		backGroundImage = new ImageIcon(loadImage("/center.jpg"));
		
		playerOne = new Player("RED" , 92, 300, 100, 10, 100, 10, new ImageIcon(loadImage("/redplayer.png")), new ImageIcon(loadImage("/left100.jpg")));
		playerTwo = new Player("BLUE", 802, 150, 100, 10, 100, 10, new ImageIcon(loadImage("/blueplayer.png")), new ImageIcon(loadImage("/right100.jpg")));

		list.insertLast(G_Block = new Block("GREEN", 443, 100, 40, 20, new ImageIcon(loadImage("/greenbrick.png"))));
		list.insertLast(G_Block1 = new Block("GREEN", 443, 200, 40, 20, new ImageIcon(loadImage("/greenbrick.png"))));
		list.insertLast(G_Block2 = new Block("GREEN", 443, 300, 40, 20, new ImageIcon(loadImage("/greenbrick.png"))));
		list.insertLast(G_Block3 = new Block("GREEN", 443, 400, 40, 20, new ImageIcon(loadImage("/greenbrick.png"))));

		list.insertLast(B_Block = new Block("BLUE", 523, 150, 40, 20, new ImageIcon(loadImage("/bluebrick.png"))));
		list.insertLast(B_Block1 = new Block("BLUE", 523, 250, 40, 20, new ImageIcon(loadImage("/bluebrick.png"))));
		list.insertLast(B_Block2 = new Block("BLUE", 523, 350, 40, 20, new ImageIcon(loadImage("/bluebrick.png"))));
		list.insertLast(B_Block3 = new Block("BLUE", 573, 100, 40, 20, new ImageIcon(loadImage("/bluebrick.png"))));
		list.insertLast(B_Block4 = new Block("BLUE", 573, 200, 40, 20, new ImageIcon(loadImage("/bluebrick.png"))));
		list.insertLast(B_Block5 = new Block("BLUE", 573, 300, 40, 20, new ImageIcon(loadImage("/bluebrick.png"))));
		list.insertLast(B_Block6 = new Block("BLUE", 573, 400, 40, 20, new ImageIcon(loadImage("/bluebrick.png"))));

		list.insertLast(R_Block = new Block("RED", 363, 150, 40, 20, new ImageIcon(loadImage("/redbrick.png"))));
		list.insertLast(R_Block1 = new Block("RED", 363, 250, 40, 20, new ImageIcon(loadImage("/redbrick.png"))));
		list.insertLast(R_Block2 = new Block("RED", 363, 350, 40, 20, new ImageIcon(loadImage("/redbrick.png"))));
		list.insertLast(R_Block3 = new Block("RED", 313, 100, 40, 20, new ImageIcon(loadImage("/redbrick.png"))));
		list.insertLast(R_Block4 = new Block("RED", 313, 200, 40, 20, new ImageIcon(loadImage("/redbrick.png"))));
		list.insertLast(R_Block5 = new Block("RED", 313, 300, 40, 20, new ImageIcon(loadImage("/redbrick.png"))));
		list.insertLast(R_Block6 = new Block("RED", 313, 400, 40, 20, new ImageIcon(loadImage("/redbrick.png"))));

		playerOneBall = new Ball("RED", 250, 265, 10, 10, -8, 4, new ImageIcon(loadImage("/redball.png")));
		playerTwoBall = new Ball("BLUE", 650, 265, 10, 10, 8, -4, new ImageIcon(loadImage("/blueball.png")));

        playerOneBar = new JProgressBar();
		playerTwoBar = new JProgressBar();
		
		playerOneBar.setBorderPainted(false);
		playerTwoBar.setBorderPainted(false);

		playerOneBar.setBounds(150, 500, 25, 100);
		playerTwoBar.setBounds(707, 500, 25, 100);

		add(playerOneBar);
		add(playerTwoBar);
	}

	public void paint(Graphics g)
	{
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();

		paintComponent(graphics);
		g.drawImage(image, 0, 0, null);

		repaint();
	}

	public void paintComponent(Graphics g)
	{
		g.drawImage(backGroundImage.getImage(), 102, 73, 700, 400, null);
		g.drawImage(topImage.getImage(), 3, 24, 900, 50, null);
		g.drawImage(botImage.getImage(), 3, 472, 900, 50, null);

		playerOneBall.draw(g);
		playerOneBall.update();

		playerTwoBall.draw(g);
		playerTwoBall.update();

		if (playerOneBall.posX > 792)
			playerOneBall.detectWallCollision(playerTwo);
		else if (playerTwoBall.posX > 792)
			playerTwoBall.detectWallCollision(playerTwo);
		else if (playerOneBall.posX < 102)
			playerOneBall.detectWallCollision(playerOne);
		else if (playerTwoBall.posX < 102)
			playerTwoBall.detectWallCollision(playerOne);

		/*
		 * Draw and update all blocks in the linked list
		 */
		LinkedList list2 = new LinkedList();
		while(!list.isEmpty())
		{
			Block b = list.peekLast();
			list.deleteLast();
			// player one is red
			if(b.detectBallCollision(playerOneBall) && !b.getColor().equals("RED"))
			{
				playerOneBall.blockCollision(b);
				continue;
			}
			// player two is blue
			else if(b.detectBallCollision(playerTwoBall) && !b.getColor().equals("BLUE"))
			{
				playerTwoBall.blockCollision(b);
				continue;
			}
			b.draw(g);
			b.update();
			list2.insertFirst(b);	
		}
		list = list2;
		
		playerOne.draw(g);
		playerOne.update();

		playerTwo.draw(g);
		playerTwo.update();

		if (playerOne.getHealth() <= 0)
			endGame(playerOne);
		if (playerTwo.getHealth() <= 0)
			endGame(playerTwo);
	}

	public void endGame(Player winner)
	{
		while (!list.isEmpty())
			list.deleteLast();
		
		playerOneBall.setSpeed(0, 0);
		playerTwoBall.setSpeed(0, 0);

		playerOne.speed = 0;
		playerTwo.speed = 0;
	}

	public BufferedImage loadImage(String i) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource(i));
		} catch (IOException e) {
			System.out.println(i + " was not found.");
		}
		return image;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			playerOne.setMovingDown(false);
			playerOne.setMovingUp(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			playerOne.setMovingUp(false);
			playerOne.setMovingDown(true);
		}

		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			playerTwo.setMovingDown(false);
			playerTwo.setMovingUp(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			playerTwo.setMovingUp(false);
			playerTwo.setMovingDown(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			restartGame();
		}
		
	}

	private void restartGame() {
		endGame(playerOne);
		mainFrame();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W)
			playerOne.setMovingUp(false);
		else if(e.getKeyCode() == KeyEvent.VK_S)
			playerOne.setMovingDown(false);

		if(e.getKeyCode() == KeyEvent.VK_UP)
			playerTwo.setMovingUp(false);
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			playerTwo.setMovingDown(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Not needed for our game
	}

}