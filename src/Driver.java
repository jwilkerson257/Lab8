
public class Driver {
	public static void main(String[] args)
	{
		BoardGame temp = new BoardGame();
		temp.addPlayer("A", GamePiece.BLUE_BOOT, Location.BALLROOM);
		temp.addPlayer("B", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
		temp.addPlayer("C", GamePiece.GREEN_BOOT, Location.CONSERVATORY);
		temp.addPlayer("D", GamePiece.MAGENTA_RACER, Location.DINING_ROOM);
		temp.addPlayer("E", GamePiece.RED_RACER, Location.HALL);
		temp.addPlayer("F", GamePiece.RED_THIMBLE, Location.KITCHEN);
		temp.addPlayer("G", GamePiece.YELLOW_BOOT, Location.LIBRARY);
		temp.addPlayer("H", GamePiece.BLUE_BOOT, Location.LOUNGE);
		temp.addPlayer("I", GamePiece.BLUE_RACER, Location.STUDY);
		
		temp.movePlayer("G", Location.BALLROOM);
		
		String[] players = {"A","C"};
		Location[] locations = {Location.KITCHEN, Location.STUDY};
		temp.moveTwoPlayers(players, locations);
		
		String[] players2 = {"F","I"};
		Location[] locations2 = {Location.HALL, Location.LIBRARY};
		temp.moveTwoPlayers(players2, locations2);
		
		System.out.println("Player C's GamePiece" + temp.getPlayerGamePiece("C"));
		System.out.println("The player with the GamePiece RED_RACER: " + temp.getPlayerWithGamePiece(GamePiece.RED_RACER));
		System.out.println("Player A's locations: " + temp.getPlayersLocation("A"));
		System.out.println("Players in the Kitchen are: " + temp.getPlayersAtLocation(Location.KITCHEN));
		System.out.println("GamePieces in the Kitchen are: " + temp.getGamePiecesAtLocation(Location.KITCHEN));
		
		System.out.println("Players: " + temp.getPlayers());
		System.out.println("Player's GamePieces: " + temp.getPlayerPieces());
		System.out.println("Player's locations:" + temp.getPlayerLocations());
	}
}
