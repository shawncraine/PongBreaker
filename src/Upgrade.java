import java.awt.Graphics;

/**
 * Upgrade.java
 * @author Adam Childs
 *
 * The Upgrade class handles all upgrades that are attainable by
 * breaking a green block.
 */
class Upgrade extends GameObject
{
	private String upgradeName;
	private int upgradeValue;

	public Upgrade(String n, int v, int x, int y)
	{
		upgradeName = n;
		upgradeValue = v;
		posX = x;
		posY = y;
	}

	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public void update() {
		
	}

	public void enableUpgrade(int value)
	{
		switch(value)
		{
			case 0:
				// Do this
				break;
			case 1:
				// Do this
				break;
			case 2:
				// Do this
				break;

			default:
				break;
		}
	}

	public void setUpgradeName(String n) {
		upgradeName = n;
	}

	public String getUpgradeName() {
		return upgradeName;
	}

	public void setUpgradeValue(int v) {
		upgradeValue = v;
	}

	public int getUpgradeValue() {
		return upgradeValue;
	}

}