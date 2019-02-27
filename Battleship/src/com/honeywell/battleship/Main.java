package com.honeywell.battleship;

import java.util.Scanner;

public class Main {
	static boolean sumBodyWins;
	static Scanner sc = new Scanner(System.in);
	 
    public static void main(String[] args) throws CustomException {
    	System.out.println("____OPPONENT GRID____");
    	Computer computer = new Computer();
    	showGrid(Computer.myGrid);
    	Me me = new Me();
    	me.setUp();
    	showGrid(me.myGrid);
		while(!sumBodyWins) {
			me.play(Computer.myGrid);
			computer.play(me.myGrid);
		}
    }

	static void showGrid(Ship[][] opponentGrid) {
		// TODO Auto-generated method stub
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(opponentGrid[i][j]!=null) {
					String name = opponentGrid[i][j].getClass().getName();
					System.out.print(name.substring(name.lastIndexOf(".")+1,name.lastIndexOf(".")+3)+"	");
				}else {
					System.out.print("~	");
				}
			}
			System.out.println();
		}
	}
}
