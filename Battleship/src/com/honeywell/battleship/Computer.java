package com.honeywell.battleship;

import java.util.Random;
import java.util.Scanner;

public class Computer extends Players {

	static Ship[][] myGrid;
	boolean[][] referenceGrid = new boolean[8][8];
	private int totalHits = 17;
	static Ship opponentCarrier;
	static Ship opponentBattleShip;
	static Ship opponentCruiser;
	static Ship opponentSubmarine;
	static Ship opponentDestroyer;
	//static Scanner scanner;
	static {
		opponentCarrier = ShipFactory.getShip("Carrier");
		opponentBattleShip = ShipFactory.getShip("BattleShip");
		opponentCruiser = ShipFactory.getShip("Cruiser");
		opponentSubmarine = ShipFactory.getShip("Submarine");
		opponentDestroyer = ShipFactory.getShip("Destroyer");
		myGrid = new Ship[][] {
			{null,opponentSubmarine,null,null,opponentBattleShip,opponentBattleShip,opponentBattleShip,opponentBattleShip},
			{null,opponentSubmarine,null,null,null,null,null,null},
			{null,opponentSubmarine,opponentCarrier,null,null,null,null,null},
			{null,null,opponentCarrier,null,null,null,opponentDestroyer,null},
			{null,null,opponentCarrier,null,null,null,opponentDestroyer,null},
			{null,null,opponentCarrier,null,null,opponentCruiser,opponentCruiser,opponentCruiser},
			{null,null,opponentCarrier,null,null,null,null,null},
			{null,null,null,null,null,null,null,null}
		};
		//scanner = new  Scanner(System.in);
	}
	@Override
	void play(Ship[][] opponentGrid) throws CustomException {
		// TODO Auto-generated method stub
		System.out.println("___Computer's Turn___");
		Random random = new Random();
		int x = random.nextInt(8);
		int y = random.nextInt(8);
		if(x>=0&&x<8&&y>=0&&y<8) {
			if(opponentGrid[x][y]!=null) {
				String name = opponentGrid[x][y].getClass().getName();
				int newHealth = opponentGrid[x][y].getHealth()-1;
				opponentGrid[x][y].setHealth(newHealth);
				opponentGrid[x][y] = null;
				referenceGrid[x][y] = true;
				totalHits = totalHits - 1;
				if(newHealth == 0) {
					System.out.println("Your "+name.substring(name.lastIndexOf(".")+1)+" is Sunk ");
				}else {
					System.out.println("Your "+name.substring(name.lastIndexOf(".")+1)+" is hit and health "+newHealth);
				}
				if(totalHits == 0) {
					Main.sumBodyWins = true;
					System.out.print("Computer WON");
				}				
			}
		}else {
			throw new CustomException("Invalid Coordinates provided");
		}
		
	}
}
