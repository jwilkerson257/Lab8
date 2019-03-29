import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class BoardGame
{
	protected LinkedHashMap<String, GamePiece> playerPieces;
	protected LinkedHashMap<String, Location> playerLocations;

	public BoardGame()
	{
		// Initializes the LinkedHashMaps playerPieces and playerLocations
		playerPieces = new LinkedHashMap<String, GamePiece>();
		playerLocations = new LinkedHashMap<String, Location>();
	}
	
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation)
	{
		/*
		 *  Checks if the playerName is already a key in either one of the LinkedHashMaps and if it does not
		 *  then it puts the Player with a GamePiece and a Location into the respective Linked HashMaps
		 */
		if(playerPieces.containsKey(playerName) || playerLocations.containsKey(playerName))
		{
			return false;
		}
		else
		{
			playerLocations.put(playerName, initialLocation);
			playerPieces.put(playerName, gamePiece);
			return true;
		}
	}
	
	public GamePiece getPlayerGamePiece(String playerName)
	{
		// Returns a GamePiece that is linked to the PlayerName
		return playerPieces.get(playerName);
	}
	
	public String getPlayerWithGamePiece(GamePiece gamePiece)
	{
		// Returns a player name that is linked to the GamePiece
		if(playerPieces.containsValue(gamePiece))
		{
			for(String s: playerPieces.keySet())
			{
				if(playerPieces.get(s).equals(gamePiece))
				{
					return s;
				}
				
			}
		}

		return null;
		
	}
	
	public void movePlayer(String playerName, Location newLocation)
	{
		// Changes the Location that is linked to the playerName in the LinkedHashMap
		playerLocations.replace(playerName, playerLocations.get(playerName), newLocation);
	}
	
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations)
	{
		
		String[] temp = new String[2];
		String p1 = playerNames[0];
		String p2 = playerNames[1];
		GamePiece g1 = getPlayerGamePiece(p1);
		GamePiece g2 = getPlayerGamePiece(p2);
		Location l1 = newLocations[0];
		Location l2 = newLocations[1];
		
		// Checks the priority of the two GamePieces and checks to see which one moves first
		GamePiece first = GamePiece.movesFirst(g1, g2);
		
		// Checks to see what GamePiece is the one that moves first and moves that player to the new location first
		if(first.equals(g1))
		{
			movePlayer(p1,l1);
			movePlayer(p2,l2);
			temp[0] = p1;
			temp[1] = p2;
		}
		else if(first.equals(g2))
		{
			movePlayer(p2,l2);
			movePlayer(p1,l1);
			temp[0] = p2;
			temp[1] = p1;
		}
		return temp;
	}
	
	public Location getPlayersLocation(String player)
	{
		// Returns the location of a specified player
		return playerLocations.get(player);
	}
	
	public ArrayList<String> getPlayersAtLocation(Location loc)
	{
		ArrayList<String> players = new ArrayList<String>();
		for(String s: playerLocations.keySet())
		{
			if(playerLocations.get(s).equals(loc))
			{
				players.add(s);
			}
			
		}
		return players;
		
	}
	
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc)
	{
		// Returns an ArrayList of all of the game pieces at a specified location
		ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
		for(String s: playerLocations.keySet())
		{
			if(playerLocations.get(s).equals(loc))
			{
				pieces.add(playerPieces.get(s));
			}
			
		}
		return pieces;
	}
	
	public Set<String> getPlayers()
	{
		// Returns a set of strings of all the players inside the Linked Hash Map
		return playerPieces.keySet();
	}
	
	public Set<Location> getPlayerLocations()
	{
		// Returns a set of all of the players locations
		Set<Location> loc = new HashSet<Location>();
		for(String s: playerLocations.keySet())
		{
			loc.add(playerLocations.get(s));
		}
		return loc;
		
	}
	public Set<GamePiece> getPlayerPieces()
	{
		// Returns a set off all the players game pieces
		Set<GamePiece> pieces = new HashSet<GamePiece>();
		for(String s: playerPieces.keySet())
		{
			pieces.add(playerPieces.get(s));
		}
		return pieces;
		
	}
}
