package io.leavesfly.algori.challenge.other;

public class SubSet {

	private int[] solutionVec;
	private int vecLen;
	private int[] inputData;

	public SubSet(int vecLen, int[] input) {
		this.vecLen = vecLen;
		solutionVec = new int[vecLen];
		inputData = input;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		SubSet subSet = new SubSet(input.length, input);
		subSet.backTrack(-1);
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
			if (solutionVec[i] == 1) {
				System.out.print(inputData[i] + " ");
			}
		}
		System.out.println("}");
	}

	/**
	 * ��ݵ�ǰ��vec״̬�����ѡ��
	 * 
	 * @param currPointer
	 * @return
	 */
	private int[] constructCandidates(int currPointer) {
		if (currPointer < vecLen - 1) {
			return new int[] { 1, 0 };
		}
		return null;
	}

	/**
	 * �������еĿռ䣬û�м�֦ ��֦Ӧ��ͨ���ж� ������һ�������� ֱ�ӷ��� �����Բ��÷ǵݹ��ʵ�ַ�ʽ
	 * Sk={true,false}(1,0)
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
