package com.honeywell.battleship;

public class ShipFactory {
	public static Ship getShip(String shipType) {
		if(shipType.equalsIgnoreCase("carrier"))
			return new Carrier();
		else if(shipType.equalsIgnoreCase("battleship"))
			return new Battleship();
		else if(shipType.equalsIgnoreCase("cruiser"))
			return new Cruiser();
		else if(shipType.equalsIgnoreCase("submarine"))
			return new Submarine();
		else if(shipType.equalsIgnoreCase("destroyer"))
			return new Destroyer();
		return null;
	}
}
