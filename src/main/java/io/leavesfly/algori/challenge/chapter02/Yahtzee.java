package io.leavesfly.algori.challenge.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author leavesfly �����ά�?ÿ��������ֵ��ͨ����
 * 
 */

public class Yahtzee {

	private final int GAMENUM = 13;
	private int[][] gameData;
	private int[][] desData;

	public Yahtzee() {
		gameData = new int[GAMENUM][];
		int[] temp = null;
		for (int i = 0; i < gameData.length; i++) {
			temp = getRandomArray();
			gameData[i] = temp;
		}

		desData = new int[GAMENUM][];
		for (int i = 0; i < desData.length; i++) {
			temp = new int[GAMENUM];
			desData[i] = temp;
		}
	}

	private int[] getRandomArray() {
		int[] randomArry = new int[5];
		for (int i = 0; i < randomArry.length; i++) {
			randomArry[i] = (int)(Math.round(Math.random() * 5)) + 1;
			// randomArry[i] = i + 1;
		}
		return randomArry;
	}

	// ���Գ���
	public static void main(String[] args) {
		Yahtzee yahtzee = new Yahtzee();
		yahtzee.pirntGameData();
		System.out
				.println("======================================================");
		yahtzee.printDesData();
		yahtzee.initDesData();
		System.out
				.println("======================================================");
		yahtzee.printDesData();
		System.out
				.println("======================================================");
		System.out.println(yahtzee.maxSum());

	}

	// *�����㷨 ���ÿ�λ�ȡ���ֵ,�������ͬ�����ֵ�����ж���ѡ�������ϵڶ��������С���Ǹ����ֵɾ��

	public int maxSum() {
		int sum = 0;
		MaxObject maxObject = null;
		//List<MaxObject> maxObjectList = null;
		for (int i = 0; i < GAMENUM; i++) {
			//maxObjectList = getMaxObjectList();
			// System.out.println("@" + maxObjectList.size());
			//maxObject = getChoosenObjectt(maxObjectList);
			maxObject=getMaxObject();
			sum += maxObject.getMax();
			// System.out.printf("%4d", maxObject.getMax());
			setZeroByMaxObject(maxObject);
		}
		return sum;
	}

	private void setZeroByMaxObject(MaxObject maxObject) {
		int num_x = maxObject.getX();
		int num_y = maxObject.getY();
		for (int i = 0; i < desData[num_x].length; i++) {
			desData[num_x][i] = 0;
		}
		for (int i = 0; i < desData.length; i++) {
			desData[i][num_y] = 0;
		}
	}

	public MaxObject getChoosenObjectt(List<MaxObject> maxObjectList) {
		if (maxObjectList.size() == 1) {
			return maxObjectList.get(0);
		} else {
			List<MaxObject> maxObjArray = new ArrayList<MaxObject>();
			MaxObject minObject = null;
			Direction direction = null;
			for (int i = 0; i < maxObjectList.size() - 1; i++) {
				for (int j = i + 1; j < maxObjectList.size(); j++) {
					direction = maxObjectList.get(i).relativePosition(
							maxObjectList.get(j));
					minObject = getTwoSecondLessObject(maxObjectList.get(i),
							maxObjectList.get(j), direction);
					maxObjArray.add(minObject);
				}
			}
			int x = 0;
			int y = 0;
			int max = Integer.MAX_VALUE;
			for (int i = 0; i < maxObjArray.size(); i++) {
				if (max > maxObjArray.get(i).getMax()) {
					max = maxObjArray.get(i).getMax();
					x = maxObjArray.get(i).getX();
					y = maxObjArray.get(i).getY();
				}
			}
			minObject = new MaxObject(max, x, y);
			// System.out.println(minObject.getMax());
			// --------------------------------------

			List<MaxObject> listMaxObj = new ArrayList<MaxObject>();
			for (int i = 0; i < maxObjectList.size(); i++) {
				if (maxObjectList.get(i).getX() == minObject.getX()) {
					listMaxObj.add(maxObjectList.get(i));
				}
			}
			if (listMaxObj.size() == 0) {
				//listMaxObj.clear();
				for (int i = 0; i < maxObjectList.size(); i++) {
					if (maxObjectList.get(i).getY() == minObject.getY()) {
						listMaxObj.add(maxObjectList.get(i));
					}
				}
			}
			if (listMaxObj.size() == 1) {
				return listMaxObj.get(0);
			} else {
				if(listMaxObj.size()==0){
					System.out.println("������?��");
				}

				MaxObject minObjectTemp_1 = null;
				MaxObject minObject_1 = new MaxObject(Integer.MAX_VALUE,
						Integer.MAX_VALUE, Integer.MAX_VALUE);
				if (listMaxObj.get(0).getY() == listMaxObj.get(1).getY()) {

					for (MaxObject maxObject : listMaxObj) {

						minObjectTemp_1 = getSecondMaxObject(maxObject,
								Direction.down);

						if (minObject_1.getMax() > minObjectTemp_1.getMax()) {

							minObject_1.setMax(minObjectTemp_1.getMax());
							minObject_1.setX(minObjectTemp_1.getX());
							minObject_1.setY(minObjectTemp_1.getY());
						}
					}
					for (MaxObject maxObject : listMaxObj) {
						if (maxObject.getX() == minObject_1.getX()) {
							return maxObject;
						}
					}
				} else {

					for (MaxObject maxObject : listMaxObj) {

						minObjectTemp_1 = getSecondMaxObject(maxObject,
								Direction.level);

						if (minObject_1.getMax() > minObjectTemp_1.getMax()) {

							minObject_1.setMax(minObjectTemp_1.getMax());
							minObject_1.setX(minObjectTemp_1.getX());
							minObject_1.setY(minObjectTemp_1.getY());
						}
					}
					for (MaxObject maxObject : listMaxObj) {
						if (maxObject.getY() == minObject_1.getY()) {
							return maxObject;
						}
					}

				}
			}

		}

		return null;

	}

	// ---------------------------

	public MaxObject getTwoSecondLessObject(MaxObject maxObject_1,
			MaxObject maxObject_2, Direction direction) {
		MaxObject result = null;
		result = getSecondMaxObject(maxObject_1, direction);
		if (result.getMax() > getSecondMaxObject(maxObject_2, direction)
				.getMax()) {
			result = maxObject_2;
		}
		return result;
	}

	public MaxObject getSecondMaxObject(MaxObject maxObject, Direction direction) {
		int num_x = maxObject.getX();
		int num_y = maxObject.getY();
		int max = 0;
		int x = 0;
		int y = 0;
		if (direction == Direction.down) {
			for (int i = 0; i < desData[num_x].length; i++) {
				if (max < desData[num_x][i] && i != num_y) {
					max = desData[num_x][i];
					x = num_x;
					y = i;
				}
			}
			return new MaxObject(max, x, y);

		} else if (direction == Direction.level) {
			for (int i = 0; i < desData.length; i++) {
				if (max < desData[i][num_y] && i != num_x) {
					max = desData[i][num_y];
					x = i;
					y = num_y;
				}
			}
			return new MaxObject(max, x, y);
		} else {

			for (int i = 0; i < desData[num_x].length; i++) {
				if (max < desData[num_x][i] && i != num_y) {
					max = desData[num_x][i];
					x = num_x;
					y = i;
				}
			}
			int maxSecond = 0;
			int xSecond = 0;
			int ySecond = 0;
			for (int i = 0; i < desData.length; i++) {
				if (maxSecond < desData[i][num_y] && i != num_x) {
					maxSecond = desData[i][num_y];
					xSecond = i;
					ySecond = num_y;
				}
			}

			if (maxSecond > max) {
				return new MaxObject(maxSecond, xSecond, ySecond);
			} else {
				return new MaxObject(max, x, y);
			}
		}
	}

	public MaxObject getMaxObject() {
		int max = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < desData.length; i++) {
			for (int j = 0; j < desData[i].length; j++) {
				if (max < desData[i][j]) {
					max = desData[i][j];
					x = i;
					y = j;
				}
			}
		}
		return new MaxObject(max, x, y);
	}

	public List<MaxObject> getMaxObjectList() {
		int max = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < desData.length; i++) {
			for (int j = 0; j < desData[i].length; j++) {
				if (max < desData[i][j]) {
					max = desData[i][j];
					x = i;
					y = j;
				}
			}
		}
		List<MaxObject> maxObjectList = new ArrayList<MaxObject>();
		maxObjectList.add(new MaxObject(max, x, y));
		if (max == 0) {
			return maxObjectList;
		}
		MaxObject maxObject = maxObjectList.get(0);
		for (int i = 0; i < desData.length; i++) {
			for (int j = 0; j < desData[i].length; j++) {
				if (maxObject.getMax() == desData[i][j]
						&& (maxObject.getX() != i || maxObject.getY() != j)) {
					max = desData[i][j];
					x = i;
					y = j;

					maxObjectList.add(new MaxObject(max, x, y));

				}
			}
		}
		return maxObjectList;
	}

	public void initDesData() {
		for (int i = 0; i < desData.length; i++) {
			int j = 0;
			for (FunType funType : FunType.values()) {
				desData[i][j] = callFunByFunType(funType, gameData[i]);
				j++;
			}
		}
	}

	public void pirntGameData() {
		for (int i = 0; i < gameData.length; i++) {
			for (int j = 0; j < gameData[i].length; j++) {
				// System.out.print(gameData[i][j]+"  ");
				System.out.printf("%4d", gameData[i][j]);

			}
			System.out.println();
		}
	}

	public void printDesData() {
		for (int i = 0; i < desData.length; i++) {
			for (int j = 0; j < desData[i].length; j++) {
				System.out.printf("%4d", desData[i][j]);
			}
			System.out.println();
		}
	}

	private int scoreFirst(int[] data) {
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 1) {
				result++;
			}
		}
		return result;
	}

	private int scoreSecond(int[] data) {
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 2) {
				result++;
			}
		}
		return result * 2;
	}

	private int scoreThird(int[] data) {
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 3) {
				result++;
			}
		}
		return result * 3;
	}

	private int scoreFour(int[] data) {
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 4) {
				result++;
			}
		}
		return result * 4;
	}

	private int scoreFive(int[] data) {
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 5) {
				result++;
			}
		}
		return result * 5;
	}

	private int scoreSix(int[] data) {
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 6) {
				result++;
			}
		}
		return result * 6;
	}

	private int chance(int[] data) {
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			result += data[i];
		}
		return result;
	}

	public int sameMaxNum(int[] data) {
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			int count = 0;
			for (int j = 0; j < data.length; j++) {
				if (data[i] == data[j]) {
					count++;
				}
			}
			if (count > result) {
				result = count;
			}
		}
		return result;
	}

	private int threeSame(int[] data) {
		if (sameMaxNum(data) >= 3) {
			return chance(data);
		}
		return 0;
	}

	private int fourSame(int[] data) {
		if (sameMaxNum(data) >= 4) {
			return chance(data);
		}
		return 0;
	}

	private int fiveSame(int[] data) {
		if (sameMaxNum(data) >= 5) {
			return 50;
		}
		return 0;
	}

	private static boolean isAlongAtNum(int alongNum, int[] data) {
		// ����sampleArray
		int[] dataSample = new int[] { 1, 2, 3, 4, 5, 6 };
		int sampleNum = dataSample.length - alongNum + 1;
		int[][] sampleArray = new int[sampleNum][];
		int[] sample = null;
		for (int i = 0; i < sampleArray.length; i++) {
			sample = new int[alongNum];
			for (int j = 0; j < sample.length; j++) {
				sample[j] = dataSample[j + i];
			}
			sampleArray[i] = sample;
		}
		//
		for (int i = 0; i < sampleArray.length; i++) {
			int count = 0;
			for (int j = 0; j < sampleArray[i].length; j++) {
				for (int m = 0; m < data.length; m++) {
					if (sampleArray[i][j] == data[m]) {
						count++;
						break;
					}
				}
				if (count == sampleArray[i].length) {
					return true;
				}
			}

		}

		return false;

	}

	private int smallAlong(int[] data) {
		if (isAlongAtNum(4, data)) {
			return 25;
		}
		return 0;
	}

	private int bigAlong(int[] data) {
		if (isAlongAtNum(5, data)) {
			return 35;
		}
		return 0;
	}

	private boolean isContain(int[] compare, int num) {
		for (int i = 0; i < compare.length; i++) {
			if (compare[i] == num) {
				return true;
			}
		}
		return false;
	}

	public boolean isTwoNum(int[] data) {
		int[] compare = new int[3];
		int point = 0;
		for (int i = 0; i < data.length; i++) {
			if (!isContain(compare, data[i])) {
				compare[point] = data[i];
				point++;
			}
		}
		if (point > 2) {
			return false;
		}
		return true;
	}

	public int calabash(int[] data) {
		if (sameMaxNum(data) == 3) {
			if (isTwoNum(data)) {
				return 40;
			}
		}
		if (sameMaxNum(data) == 5) {
			return 40;
		}
		return 0;
	}

	public int callFunByFunType(FunType funType, int[] data) {

		switch (funType) {

		case scoreFirst:
			return scoreFirst(data);

		case scoreSecond:
			return scoreSecond(data);

		case scoreThird:
			return scoreThird(data);

		case scoreFour:
			return scoreFour(data);

		case scoreFive:
			return scoreFive(data);

		case scoreSix:
			return scoreSix(data);

		case chance:
			return chance(data);

		case threeSame:
			return threeSame(data);

		case fourSame:
			return fourSame(data);

		case fiveSame:
			return fiveSame(data);

		case smallAlong:
			return smallAlong(data);

		case bigAlong:
			return bigAlong(data);

		case calabash:
			return calabash(data);

		}

		return 0;
	}

}

class MaxObject {
	private int max;
	private int x;
	private int y;

	public MaxObject(int max, int x, int y) {
		this.max = max;
		this.x = x;
		this.y = y;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction relativePosition(MaxObject maxObject) {
		if (this.x == maxObject.getX()) {
			return Direction.level;
		} else if (this.y == maxObject.getY()) {
			return Direction.down;
		} else {
			return Direction.opposite;
		}

	}

}

enum FunType {
	scoreFirst, scoreSecond, scoreThird, scoreFour, scoreFive, scoreSix, chance, threeSame, fourSame, fiveSame, smallAlong, bigAlong, calabash,

}

enum Direction {
	down, level, opposite
}