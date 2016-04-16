package io.leavesfly.algori.challenge.other;

import java.util.HashMap;
import java.util.Map;

public class Freckles {

	private Point[] inputData;
	private int splitPointer;
	private Map<Point, Point> resultMap;

	public Freckles(Point[] inputData) {
		this.inputData = inputData;
		splitPointer = 0;
		resultMap = new HashMap<Point, Point>();
	}

	public float getMinDistance() throws Exception {
		this.genMap();
		float result = 0f;
		for (Map.Entry<Point, Point> entry : resultMap.entrySet()) {
			result += entry.getKey().getDistanceToPoint(entry.getValue());
		}
		return result;
	}

	private void genMap() throws Exception {
		int[] pair = null;
		do {
			pair = genPointPair();
			this.putResultMap(pair);
			splitPointer++;
			this.swap(splitPointer, pair[1]);
		} while (splitPointer < inputData.length - 1);
	}

	private void putResultMap(int[] pair) throws Exception {
		if (pair.length != 2) {
			throw new Exception("putResultMap--error");
		} else {
			resultMap.put(inputData[pair[0]], inputData[pair[1]]);
		}
	}

	private int[] genPointPair() {
		int[] pair = new int[2];
		float minDistance = Float.MAX_VALUE;
		float tmp = 0f;
		for (int i = 0; i <= splitPointer; i++) {
			for (int j = splitPointer + 1; j < inputData.length; j++) {
				tmp = inputData[i].getDistanceToPoint(inputData[j]);
				if (minDistance > tmp) {
					minDistance = tmp;
					pair[0] = i;
					pair[1] = j;
				}
			}
		}

		return pair;
	}

	private void swap(int pointerA, int pointerB) {
		Point pointer = inputData[pointerA];
		inputData[pointerA] = inputData[pointerB];
		inputData[pointerB] = pointer;
	}

	public static void main(String[] args) throws Exception {
		Point[] inputData = new Point[5];
		inputData[0] = new Point(1, 1);
		inputData[1] = new Point(5, 5);
		inputData[2] = new Point(2, 2);
		inputData[3] = new Point(4, 4);
		inputData[4] = new Point(3, 3);

		Freckles freckles = new Freckles(inputData);
		System.out.println(freckles.getMinDistance());

	}

}

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
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

	public float getDistanceToPoint(Point point) {
		int xDistance = Math.abs(this.x - point.getX());
		int yDistance = Math.abs(this.y - point.getY());
		float result = (float) Math.pow(
				Math.pow(xDistance, 2) + Math.pow(yDistance, 2), 0.5);
		return result;
	}

}
