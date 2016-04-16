package io.leavesfly.algori.leetcode.detail;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author yefei.yf
 * 
 */
public class InsertInterval {

	public static void main(String[] args) {
		List<Interval> intervalList = new LinkedList<Interval>();
		intervalList.add(new Interval(1, 3));
		intervalList.add(new Interval(6, 9));
		System.out.println(insertInterval(intervalList, new Interval(2, 5)));

		// intervalList.add(new Interval(1, 2));
		// intervalList.add(new Interval(3, 5));
		// intervalList.add(new Interval(6, 7));
		// intervalList.add(new Interval(8, 10));
		// intervalList.add(new Interval(12, 16));
		// System.out.println(insertInterval(intervalList, new Interval(4, 9)));
		// System.out.println(new Interval(4, 9).compareTo(new Interval(6, 7)));
	}

	public static List<Interval> insertInterval(List<Interval> intervalList, Interval insertInterval) {
		if (intervalList == null || intervalList.size() == 0 || insertInterval == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < intervalList.size(); i++) {
			if (insertInterval.compareTo(intervalList.get(i)) > 0) {
				if (insertInterval.compareTo(intervalList.get(i)) == 2) {
					intervalList.get(i).setEnd(insertInterval.getStart());
				} else if (insertInterval.compareTo(intervalList.get(i)) == 1) {
					intervalList.remove(i);
					i--;
				}
				continue;
			}

			if (insertInterval.compareTo(intervalList.get(i)) < 0) {
				if (insertInterval.compareTo(intervalList.get(i)) == -2) {
					intervalList.get(i).setStart(insertInterval.getEnd());
				}
			}
		}

		return intervalList;
	}

	public static class Interval implements Comparable<Interval> {
		private int start;
		private int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int compareTo(Interval o) {
			if (o.getStart() == this.start && o.getEnd() == this.end) {
				return 0;
			}

			if (this.start >= o.getEnd()) {
				return 3;
			}

			if (this.start >= o.getStart() && this.start <= o.getEnd() && this.end >= o.getEnd()) {
				return 2;
			}

			if (this.start <= o.getStart() && this.end >= o.getEnd()) {
				return 1;
			}

			if (this.start >= o.getStart() && this.end <= o.getEnd()) {
				return -1;
			}

			if (this.start <= o.getStart() && this.end >= o.getStart() && this.end <= o.getEnd()) {
				return -2;
			}

			if (this.end <= o.getStart()) {
				return -3;
			}

			return 0;
		}

		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}

	}

}
