/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 *This Program alows karel to put a beeper
 *in the middle of a world regarless of it's size
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	
	public void run(){
		
		fillRow();
		turnAround();
		collectBeepers();
		turnAround();
		moveUpToWall();
		distributeBeepers();
		putBeeper();
		turnAround();
		removeTrash();
	}
	
	//puts one beeper every two steps until it finds a wall
	private void fillRow(){
		
		while (frontIsClear()){
			move();
			putBeeper();
			
			if (frontIsClear()){
				move();
			}
		}
	}

	//Take all the beepers groups them on the south-east corner
	//number of collected beepers equals half the number of colums
	private void collectBeepers(){
		
		while (frontIsClear()){
			move();
			
			if (beepersPresent()){
				pickBeeper();
				turnAround();
				moveUpToWall();
				putBeeper();
				turnAround();
			}
		}
	}
		
	private void moveUpToWall(){

		while (frontIsClear()){
			move();
		}
	}

	//Distrubutes beepers collected one after another
	//Last beeper put represents the midpoint
	private void distributeBeepers(){
		
		while (beepersPresent()){
			turnAround();
			pickBeeper();
			move();
			
			while (beepersPresent()){
				move();
			}
			
			putBeeper();
			turnAround();
			moveUpToWall();
		}	
	}
	
	//Removes not needed beepers, leaving only the middle one
	private void removeTrash(){
		
		moveUpToWall();
		turnAround();
		
		while (noBeepersPresent()){	//move until middle beeper 
			move();
		}
	
		while (frontIsClear()){
			move();
			pickBeeper();
		}
	}
}//end