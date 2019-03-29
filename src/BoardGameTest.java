import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashMap;
import org.junit.Assert;
import org.junit.Test;

public class BoardGameTest
{

	@Test
	public void addPlayerTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		temp.addPlayer("Josh", GamePiece.MAGENTA_RACER, Location.DINING_ROOM);
		
		//
		Assert.assertTrue("AddPlayer is working incorrectly", temp.playerLocations.get("Josh").equals(Location.BALLROOM));
		Assert.assertTrue("AddPlayer is working incorrectly", temp.playerPieces.get("Josh").equals(GamePiece.BLUE_BOOT));
		Assert.assertTrue("AddPlayer is working incorrectly", temp.playerLocations.get("Josh").equals(Location.BALLROOM));
		Assert.assertTrue("AddPlayer is working incorrectly", temp.playerLocations.get("Josh").equals(Location.BALLROOM));
		Assert.assertFalse("AddPlayer is working incorrectly", temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM));
	}
	
	@Test
	public void testColorValues()
	{
		// RED:
		Color col = Color.RED;
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 255, col.getR());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0, col.getG());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0, col.getB());
		// GREEN:
		col = Color.GREEN;
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0, col.getR());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 255, col.getG());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0, col.getB());
		// BLUE:
		col = Color.BLUE;
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0, col.getR());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0, col.getG());
		Assert.assertEquals("Incorrect rgb value in color" + col.name() , 255, col.getB());
		// YELLOW
		col = Color.YELLOW;
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 255, col.getR());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 255, col.getG());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0, col.getB());
		// CYAN:
		col = Color.CYAN;
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0, col.getR());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 255, col.getG());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 255, col.getB());
		// MAGENTA:
		col = Color.MAGENTA;
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 255, col.getR());
		Assert.assertEquals("Incorrect rgb value in color" + col.name(), 0, col.getG());
		Assert.assertEquals("Incorrect rgb value in color" + col.name() , 255, col.getB());
		
	}
	
	@Test
	public void testLocation()
	{
		Assert.assertEquals("Location enum values incorrect.", Location.KITCHEN, Location.valueOf("KITCHEN"));
		Assert.assertEquals("Location enum values incorrect.", Location.CONSERVATORY, Location.valueOf("CONSERVATORY"));
		Assert.assertEquals("Location enum values incorrect.", Location.DINING_ROOM, Location.valueOf("DINING_ROOM"));
		Assert.assertEquals("Location enum values incorrect.", Location.BALLROOM, Location.valueOf("BALLROOM"));
		Assert.assertEquals("Location enum values incorrect.", Location.STUDY, Location.valueOf("STUDY"));
		Assert.assertEquals("Location enum values incorrect.", Location.HALL, Location.valueOf("HALL"));
		Assert.assertEquals("Location enum values incorrect.", Location.LOUNGE, Location.valueOf("LOUNGE"));
		Assert.assertEquals("Location enum values incorrect.", Location.LIBRARY, Location.valueOf("LIBRARY"));
		Assert.assertEquals("Location enum values incorrect.", Location.BILLIARD_ROOM, Location.valueOf("BILLIARD_ROOM"));
	}
	
	@Test
	public void testShapeToString()
	{
		Assert.assertEquals("Shape toString incorrect.", "thimble", Shape.THIMBLE.toString());
		Assert.assertEquals("Shape toString incorrect.", "boot", Shape.BOOT.toString());
		Assert.assertEquals("Shape toString incorrect.", "racecar", Shape.RACECAR.toString());
	}
	
	@Test
	public void movePlayerTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		temp.movePlayer("Josh", Location.CONSERVATORY);
		
		Assert.assertEquals("MovePlayer is working incorrectly", temp.playerLocations.get("Josh"), Location.CONSERVATORY);
	}
	
	@Test
	public void moveTwoPlayersTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		temp.addPlayer("Donnie", GamePiece.GREEN_BOOT, Location.CONSERVATORY);
		String[] players = new String[2];
		Location[] locs = new Location[2];
		players[0] = "Josh";
		players[1] = "Donnie";
		locs[0] = Location.KITCHEN;
		locs[1] = Location.STUDY;
		temp.moveTwoPlayers(players,locs);
		
		temp.addPlayer("Bruce", GamePiece.RED_THIMBLE, Location.BALLROOM);
		String[] players2 = new String[2];
		Location[] locs2 = new Location[2];
		players2[0] = "Bruce";
		players2[1] = "Donnie";
		locs2[0] = Location.HALL;
		locs2[1] = Location.LOUNGE;
		temp.moveTwoPlayers(players2,locs2);
		
		// Tests that move two players is moving both players to the correct location
		Assert.assertEquals("MoveTwoPlayers is working incorrectly", temp.playerLocations.get("Bruce"), Location.HALL);
		Assert.assertEquals("MoveTwoPlayers is working incorrectly", temp.playerLocations.get("Donnie"), Location.LOUNGE);
		
	}
	
	@Test
	public void getPlayerWithGamePieceTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		
		Assert.assertEquals("getPlayerWithGamePiece is working incorrectly", "Josh", temp.getPlayerWithGamePiece(GamePiece.BLUE_BOOT));
		Assert.assertNull("getPlayerWithGamePiece is working incorrectly", temp.getPlayerWithGamePiece(GamePiece.BLUE_RACER));
	}
	
	@Test
	public void getPlayersAtLocationTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		temp.addPlayer("Donnie", GamePiece.BLUE_RACER, Location.HALL);
		temp.addPlayer("Tyler", GamePiece.GREEN_BOOT, Location.BALLROOM);
		ArrayList<String> players = new ArrayList<String>();
		players.add("Josh");
		players.add("Tyler");
		
		Assert.assertEquals("getPlayersAtLocation is working incorrectly", players, temp.getPlayersAtLocation(Location.BALLROOM));
	}
	
	@Test
	public void getGamePiecesAtLocationTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		temp.addPlayer("Donnie", GamePiece.BLUE_RACER, Location.HALL);
		temp.addPlayer("Tyler", GamePiece.GREEN_BOOT, Location.BALLROOM);
		ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
		pieces.add(GamePiece.BLUE_BOOT);
		pieces.add(GamePiece.GREEN_BOOT);
		
		Assert.assertEquals("getPlayersAtLocation is working incorrectly", pieces, temp.getGamePiecesAtLocation(Location.BALLROOM));
	}
	
	@Test
	public void getPlayersTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		temp.addPlayer("Donnie", GamePiece.BLUE_RACER, Location.HALL);
		temp.addPlayer("Tyler", GamePiece.GREEN_BOOT, Location.BALLROOM);
		Set<String> players = temp.playerPieces.keySet();
		
		Assert.assertEquals("getPlayers is working incorrectly", players, temp.getPlayers());
	}
	
	@Test
	public void getPlayerLocationsTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		temp.addPlayer("Donnie", GamePiece.BLUE_RACER, Location.HALL);
		temp.addPlayer("Tyler", GamePiece.GREEN_BOOT, Location.BALLROOM);
		Set<Location> locations = new HashSet<Location>();
		for(String s: temp.playerLocations.keySet())
		{
			locations.add(temp.playerLocations.get(s));
		}
		
		Assert.assertEquals("getPlayers is working incorrectly", locations, temp.getPlayerLocations());
	}
	
	@Test
	public void getPlayerPiecesTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		temp.addPlayer("Donnie", GamePiece.BLUE_RACER, Location.HALL);
		temp.addPlayer("Tyler", GamePiece.GREEN_BOOT, Location.BALLROOM);
		Set<GamePiece> pieces = new HashSet<GamePiece>();
		for(String s: temp.playerPieces.keySet())
		{
			pieces.add(temp.playerPieces.get(s));
		}
		
		Assert.assertEquals("getPlayers is working incorrectly", pieces, temp.getPlayerPieces());
	}
	
	@Test
	public void getPlayersLocationTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		
		Assert.assertEquals("getPlayersLocation is working incorrectly", Location.BALLROOM, temp.getPlayersLocation("Josh"));
	}
	
	@Test
	public void GamePieceTest()
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("Josh", GamePiece.BLUE_BOOT, Location.BALLROOM);
		
		Assert.assertEquals("GamePiece getColor working incorrectly", Color.BLUE, temp.getPlayerGamePiece("Josh").getColor());
		Assert.assertEquals("GamePiece getColor working incorrectly", Shape.BOOT, temp.getPlayerGamePiece("Josh").getShape());
		Assert.assertEquals("GamePiece getColor working incorrectly", String.format("%s: a %s %s with priority %d", temp.getPlayerGamePiece("Josh").name(), temp.getPlayerGamePiece("Josh").getColor(), temp.getPlayerGamePiece("Josh").getShape(), temp.getPlayerGamePiece("Josh").getPriority()), temp.getPlayerGamePiece("Josh").toString());
	}
	
	
	

}
