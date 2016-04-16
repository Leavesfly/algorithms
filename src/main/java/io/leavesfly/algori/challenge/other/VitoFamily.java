package io.leavesfly.algori.challenge.other;

import java.util.Arrays;

public class VitoFamily {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new VitoFamily().minDistance(new int[] { 2, 4, 6 }));
	}

	public int minDistance(int[] points) {
		int min = Integer.MAX_VALUE;
		Arrays.sort(points);

		int minPoint = points[0];
		int maxPoint = points[points.length - 1];
		int tmp = -1;
		for (int i = minPoint; i < maxPoint; i++) {
			tmp = distanceVito(points, i);
			if (min > tmp) {
				min = tmp;
			}
		}
		return min;
	}

	private int distanceVito(int[] points, int pointVito) {
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			result += Math.abs(pointVito - points[i]);
		}
		return result;
	}

}
