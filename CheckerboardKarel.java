/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

		public void run (){
			
			//if there is only one colum, fill it horizontally only
			if (frontIsBlocked()){
				turnNorth();
				moveUpToWall();
			}
			
			//for the rest of the scenarios
			else{
				moveUpToWall();
				turnNorth();
			
				while (frontIsClear()){	//make sure is facing north before this
					moveUpAndChangeDirection();
					moveUpToWall();
					turnNorth();
				}
			}
		}
		
		private void turnNorth (){
			while (notFacingNorth ()) turnLeft();
		}
	
		//moves forward puttin a beeper every 2 steps until faces wall
		private void moveUpToWall(){
			
			while (frontIsClear()){
				putBeeper();
				move();
				if (frontIsClear()) move();
			}
			
			moveBack();
			
			if (noBeepersPresent()){	
				moveIfPosible();
				putBeeper();
			}
			
			else moveIfPosible();
		}

		//turns one step back and turn into the previous direction
		private void moveBack(){	
			turnAround();
			moveIfPosible();
			turnAround();
		}		
		
		//moves one step if there is no wall
		private void moveIfPosible(){
			if (frontIsClear()) move();
		}
		
		private void moveUpAndChangeDirection(){	
			
			if (noBeepersPresent()){	//there is no beeper present before moving up
				moveIfPosible();
				putBeeper();
				
				
				if (rightIsBlocked()){	//right bloqued turn west
					turnLeft();
				}
				
				else {	//left is blocked turn east
					turnRight();
				}
				
				moveIfPosible();
				moveIfPosible();
			}
		
			else {						//beeper is present before go up
				moveIfPosible();
				if (rightIsBlocked()){	//right bloqued turn west
					turnLeft();
					moveIfPosible();
				}
				
				else {	//left is blocked turn east
					turnRight();
					moveIfPosible();
				}
			}
		}
			
}


		
		

		
		



