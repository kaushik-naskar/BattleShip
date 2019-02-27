package com.honeywell.battleship;

import java.util.Scanner;

public class Me extends Players {
	
	Ship[][] myGrid = new Ship[8][8];
	boolean[][] referenceGrid = new boolean[8][8];
	int totalHits = 17;
	
	Scanner scanner = new Scanner(System.in);
	public void setUp() throws CustomException {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++) {
			System.out.println("____MY GRID____");
			Main.showGrid(myGrid);
			System.out.print("Enter ship type : ");
			String type = scanner.next();
			Ship ship = ShipFactory.getShip(type);
			System.out.print("Enter alignment 'v'/'H' for vertical and horizontal respectively : ");
			String align = scanner.next();
			System.out.print("Enter starting x y cordinates : ");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			if(isValidCordinates(x,y,ship,align)) {
				if(checkForOverlappingShips(x,y,ship,align)) {
					for(int j=0;j<ship.getSize();j++) {
						if(align.equalsIgnoreCase("V")) {
							myGrid[x+j][y] = ship;
						}else {
							myGrid[x][y+j] = ship;
						}
					}
				}
				else {
					throw new CustomException("A ship already exist in the path");
				}
			}else {
				throw new CustomException("Invalid Coordinates provided");
			}
		}
	}
	private boolean checkForOverlappingShips(int x, int y,Ship ship, String align) {
		// TODO Auto-generated method stub
		if(align.equalsIgnoreCase("V")) {
			int i=0;
			while(i<ship.getSize()) {
				if(myGrid[x+i][y]!=null) {
					return false;
				}
				i++;
				
			}
			return true;
		}else if(align.equalsIgnoreCase("H")) {
			int i=0;
			while(i<ship.getSize()) {
				if(myGrid[x][y+i]!=null) {
					return false;
				}
				i++;
			}
			return true;
		}
		return false;
	}
	private boolean isValidCordinates(int x, int y, Ship ship, String align) {
		// TODO Auto-generated method stub
		int shipSize = ship.getSize();
		if(align.equalsIgnoreCase("V")) {
			if((x>=0&&(x+shipSize-1)<8)&&(y>=0&&y<8)) return true;
			return false;
		}else if(align.equalsIgnoreCase("H")) {
			if((x>=0&&x<8)&&(y>=0&&(y+shipSize-1)<8)) return true;
			return false;
		}
		return false;
	}
	public void play(Ship[][] opponentGrid) throws CustomException {
		// TODO Auto-generated method stub
		System.out.println("___Your Turn___");
		System.out.print("Enter the x y coordinates :");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		System.out.println();
		if(x>=0&&x<8&&y>=0&&y<8) {
			if(opponentGrid[x][y]!=null) {
				String name = opponentGrid[x][y].getClass().getName();
				int newHealth = opponentGrid[x][y].getHealth()-1;
				opponentGrid[x][y].setHealth(newHealth);
				opponentGrid[x][y] = null;
				referenceGrid[x][y] = true;
				totalHits = totalHits - 1;
				if(newHealth == 0) {
					System.out.println(name.substring(name.lastIndexOf(".")+1)+" is Sunk ");
				}else {
					System.out.println(name.substring(name.lastIndexOf(".")+1)+" is hit and remaining health "+newHealth+" hits remainig :"+totalHits);
				}
				if(totalHits == 0) {
					Main.sumBodyWins = true;
					System.out.print("You WON!!");
				}				
			}
			
		}else {
			throw new CustomException("Invalid Coordinates provided");
		}
		
	}
	

	
}

