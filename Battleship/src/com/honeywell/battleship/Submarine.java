package com.honeywell.battleship;

public class Submarine extends Ship {
	static int size = 3;
	private int health = 3;
	
	@Override
	int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	int getHealth() {
		// TODO Auto-generated method stub
		return health ;
	}
	@Override
	void setHealth(int health) {
		// TODO Auto-generated method stub
		this.health = health;
	}
}
