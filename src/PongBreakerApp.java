import javax.swing.SwingUtilities;
/* Pong Breaker. */
class PongBreakerApp
{

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(
			new Runnable()
			{
				public void run()
				{
					new GameFrame().setVisible(true);
				}
			}
		);
	}

}