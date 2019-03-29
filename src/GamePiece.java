
public enum GamePiece
{
	RED_RACER(new GamePieceAppearance(Color.RED, Shape.RACECAR), 0),
	BLUE_RACER(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2),
	MAGENTA_RACER(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 1),
	RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 10),
	BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5),
	GREEN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 8),
	YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7);
	
	private GamePieceAppearance appearance ;
	private int priority;
	
	private GamePiece(GamePieceAppearance appearance, int priority)
	{
		this.appearance = appearance;
		this.priority = priority;
	}
	
	public Color getColor()
	{
		return appearance.getColor();
	}
	
	public Shape getShape()
	{
		return appearance.getShape();
	}
	
	public static GamePiece movesFirst(GamePiece a, GamePiece b)
	{
		// Compares the priority of two game pieces and returns the game piece that has the lowest priority and will move first
		GamePiece temp = null;
		if(a.getPriority() < b.getPriority())
		{
			temp = a;
		}
		else if(a.getPriority() > b.getPriority())
		{
			temp = b;
		}
		return temp;
	}
	
	public int getPriority()
	{
		return priority;
	}


	public String toString()
	{
		return String.format("%s: a %s %s with priority %d", name(), getColor(), getShape(), getPriority());
		
	}
}
