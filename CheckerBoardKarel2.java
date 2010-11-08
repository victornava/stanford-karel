/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class CheckerBoardKarel2 extends SuperKarel {

	public void run() {
		// while (frontIsClear()) {
		putBeeper();
		while (frontIsClear()) {
			moveIfClear();
			moveIfClear();
			putBeeper();
		}

		if (frontIsBlocked()) {
			if (beepersPresent()) {
				turnLeft();
				move();
				turnLeft();
				moveIfClear();
				putBeeper();
			}
			else{
				turnLeft();
				move();
				turnLeft();
				moveIfClear();
				putBeeper();
			}
		}

		while (frontIsClear()) {
			moveIfClear();
			putBeeper();
			moveIfClear();
		}
		if (frontIsBlocked()) {
			turnRight();
			move();
			turnRight();
			move();
		}
	}

	void moveIfClear() {
		if (frontIsClear()) {
			move();
		}
	}
	// }
}