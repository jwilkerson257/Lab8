
public class GamePieceAppearance
{
	private Color color;
	private Shape shape;
	
	public GamePieceAppearance(Color color, Shape shape)
	{
		this.color = color;
		this.shape = shape;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public Shape getShape()
	{
		return shape;
	}
}
