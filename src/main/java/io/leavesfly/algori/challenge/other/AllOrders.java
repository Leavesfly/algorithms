package io.leavesfly.algori.challenge.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllOrders {

	private int[] solutionVec;
	private int vecLen;
	private int[] inputData;

	public AllOrders(int vecLen, int[] input) {
		this.vecLen = vecLen;
		solutionVec = new int[vecLen];
		inputData = input;
		Arrays.sort(input);
	}

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4, 5 };
		AllOrders allOrders = new AllOrders(input.length, input);
		allOrders.backTrack(-1);
	}

	// �����Ƿ���һ���������
	private boolean isSolution(int currPointer) {

		return currPointer == vecLen - 1;
	}

	/**
	 * �Խ���������в���
	 */
	private void processSolution() {
		System.out.print("{");
		for (int i = 0; i < vecLen; i++) {

			System.out.print(solutionVec[i] + " ");

		}
		System.out.println("}");
	}

	/**
	 * ��ݵ�ǰ��vec״̬�����ѡ�� Sk={1,2,...n}-a
	 * 
	 * @param currPointer
	 * @return
	 */
	private int[] constructCandidates(int currPointer) {
		int[] tmp = inputData.clone();
		if (currPointer < vecLen - 1) {
			for (int i = 0; i <= currPointer; i++) {
				tmp[find(solutionVec[i])] = -1;
			}
			List<Integer> intList = new ArrayList<Integer>();
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i] != -1) {
					intList.add(tmp[i]);
				}
			}
			int[] result = new int[intList.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = intList.get(i);
			}
			return result;
		}
		return null;
	}

	private int find(int a) {
		int low = 0;
		int high = inputData.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (inputData[mid] > a) {
				high = mid - 1;
			} else if (inputData[mid] < a) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;

	}

	/**
	 * �������еĿռ䣬û�м�֦ ��֦Ӧ��ͨ���ж� ������һ�������� ֱ�ӷ��� �����Բ��÷ǵݹ��ʵ�ַ�ʽ Sk={1,2,...n}-a;
	 * 
	 * @param currPointer
	 *            currPointer= -1;
	 */
	public void backTrack(int currPointer) {

		if (isSolution(currPointer)) {
			processSolution();
		} else {

			int[] candidates = null;
			candidates = constructCandidates(currPointer);

			if (candidates != null) {
				currPointer = currPointer + 1;
				for (int i = 0; i < candidates.length; i++) {
					solutionVec[currPointer] = candidates[i];
					backTrack(currPointer);
				}
			}

		}

	}

}
