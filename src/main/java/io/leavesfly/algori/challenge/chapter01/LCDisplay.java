package io.leavesfly.algori.challenge.chapter01;

import java.util.ArrayList;
import java.util.List;

public class LCDisplay {
	private int[] numArray;
	private final int numCount = 4;

	public int[] getNumArray() {
		return numArray;
	}

	public void setNumArray(int[] numArray) {
		this.numArray = numArray;
	}

	public int getNumCount() {
		return numCount;
	}

	public LCDisplay() {
		numArray = new int[10];
		for (int i = 0; i < numArray.length; i++) {
			// numArray[i] = (int) (Math.random() * 10);
			numArray[i] = i;
		}
	}

	public int getNumberOfLinles() {
		return numCount * 2 + 3;
	}

	public static void main(String[] args) {
		LCDisplay lcDisplay = new LCDisplay();
		List<NumberDisplay> numDisplayList = new ArrayList<NumberDisplay>();
		NumberDisplay numDisplay = null;
		for (int i = 0; i < lcDisplay.getNumArray().length; i++) {
			numDisplay = new NumberDisplay(lcDisplay.getNumArray()[i],
					lcDisplay.getNumCount());
			numDisplayList.add(numDisplay);
		}
		for (int i = 1; i <= lcDisplay.getNumberOfLinles(); i++) {
			for (int j = 0; j < numDisplayList.size(); j++) {
				numDisplayList.get(j).printLineByLineNum(i);
			}
			System.out.print('\n');
		}

	}

}

/**
 * 
 * @author leavesfly 1.*** 2.*__ 3.__* 4.*_* 5.___
 * 
 */
class NumberDisplay {
	private int number;
	private final int numCount;
	private int[] message = new int[5];

	public NumberDisplay(int number, int numCount) {
		this.number = number;
		this.numCount = numCount;
		switch (this.number) {
		case 0:
			message[0] = 1;
			message[1] = 4;
			message[2] = 5;
			message[3] = 4;
			message[4] = 1;
			break;
		case 1:
			message[0] = 3;
			message[1] = 3;
			message[2] = 5;
			message[3] = 3;
			message[4] = 3;
			break;
		case 2:
			message[0] = 1;
			message[1] = 3;
			message[2] = 1;
			message[3] = 2;
			message[4] = 1;
			break;
		case 3:
			message[0] = 1;
			message[1] = 3;
			message[2] = 1;
			message[3] = 3;
			message[4] = 1;
			break;
		case 4:
			message[0] = 4;
			message[1] = 4;
			message[2] = 1;
			message[3] = 3;
			message[4] = 3;
			break;
		case 5:
			message[0] = 1;
			message[1] = 2;
			message[2] = 1;
			message[3] = 3;
			message[4] = 1;
			break;
		case 6:
			message[0] = 1;
			message[1] = 2;
			message[2] = 1;
			message[3] = 4;
			message[4] = 1;
			break;
		case 7:
			message[0] = 1;
			message[1] = 3;
			message[2] = 5;
			message[3] = 3;
			message[4] = 3;
			break;
		case 8:
			message[0] = 1;
			message[1] = 4;
			message[2] = 1;
			message[3] = 4;
			message[4] = 1;
			break;
		case 9:
			message[0] = 1;
			message[1] = 4;
			message[2] = 1;
			message[3] = 3;
			message[4] = 1;
			break;

		}

	}

	private void callFunctionByNum(int num) {
		switch (num) {
		case 1:
			firstTypePrint();
			break;
		case 2:
			secondTypePrint();
			break;
		case 3:
			thirdTypePrint();
			break;
		case 4:
			fourTypePrint();
			break;
		case 5:
			fiveTypePrint();
			break;
		}
	}

	private int getNumberOfLinles() {
		return numCount * 2 + 3;
	}

	private void firstTypePrint() {
		for (int i = 0; i < numCount; i++) {
			System.out.print('*');
		}
		System.out.print(' ');
		System.out.print(' ');
	}

	private void secondTypePrint() {
		for (int i = 0; i < numCount; i++) {
			if (i == 0) {
				System.out.print('*');
			} else {
				System.out.print(' ');
			}
		}
		System.out.print(' ');
		System.out.print(' ');
	}

	private void thirdTypePrint() {
		for (int i = 0; i < numCount; i++) {
			if (i == numCount - 1) {
				System.out.print('*');
			} else {
				System.out.print(' ');
			}
		}
		System.out.print(' ');
		System.out.print(' ');
	}

	private void fourTypePrint() {
		for (int i = 0; i < numCount; i++) {
			if (i == 0 || i == numCount - 1) {
				System.out.print('*');
			} else {
				System.out.print(' ');
			}
		}
		System.out.print(' ');
		System.out.print(' ');
	}

	private void fiveTypePrint() {
		for (int i = 0; i < numCount; i++) {
			System.out.print(' ');
		}
		System.out.print(' ');
		System.out.print(' ');
	}

	public void printLineByLineNum(int n) {
		if (n <= getNumberOfLinles() && n > 0) {
			int temp = getNumberOfLinles() / 2 + 1;
			if (n == 1) {
				callFunctionByNum(message[0]);
			} else if (n < temp) {
				callFunctionByNum(message[1]);
			} else if (n == temp) {
				callFunctionByNum(message[2]);
			} else if (n < getNumberOfLinles()) {
				callFunctionByNum(message[3]);
			} else {
				callFunctionByNum(message[4]);
			}
		}
	}
}