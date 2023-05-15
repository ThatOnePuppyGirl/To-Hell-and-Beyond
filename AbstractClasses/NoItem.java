package to_infinity_and_beyond.AbstractClasses;

public class NoItem extends Item
{
	public NoItem()
	{
		SetDetails();
	}

	protected void SetDetails()
	{
		this.name = "None";
		this.description = "";
		this.levelNeeded = 0;
		this.type = Type.NULL;
		this.rarity = Rarity.NULL;
	}
}
