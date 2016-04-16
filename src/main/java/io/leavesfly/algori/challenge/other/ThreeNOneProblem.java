package io.leavesfly.algori.challenge.other;

public class ThreeNOneProblem {

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		System.out.println(new ThreeNOneProblem().maxLoopNumBetween(1, 100000));
		// Thread.sleep(3000);
		System.out.println(System.currentTimeMillis() - startTime);
	}

	public int maxLoopNumBetween(int smallNum, int bigNum) throws Exception {
		if (smallNum <= 0 || bigNum <= 0) {
			throw new Exception();
		}
		int max = Integer.MIN_VALUE;
		int loopNum = 0;
		for (int i = smallNum; i <= bigNum; i++) {
			loopNum = getLoopNum(i);
			if (max < loopNum) {
				max = loopNum;
			}
		}
		return max;
	}

	private int getLoopNum(int num) {
		int len = 0;
		int tmp = num;
		while (tmp != 1) {
			if (isEvenNum(tmp)) {
				tmp = tmp / 2;
			} else {
				tmp = 3 * tmp + 1;
			}
			len++;
		}
		return len;
	}

	private boolean isEvenNum(int num) {
		if (num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
