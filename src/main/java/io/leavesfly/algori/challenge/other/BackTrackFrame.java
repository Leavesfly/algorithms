package io.leavesfly.algori.challenge.other;



public class BackTrackFrame {

	private boolean isFinished = false;

	private int[] solutionVec;
	private int vecLen;

	public BackTrackFrame(int vecLen) {
		this.vecLen = vecLen;
		solutionVec = new int[vecLen];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// �����Ƿ���һ���������
	private boolean isSolution(int currPointer) {
		return false;
	}

	/**
	 * �Խ���������в���
	 */
	private void processSolution() {
		// TODO something
	}

	/**
	 * ��ݵ�ǰ��vec״̬�����ѡ��
	 * 
	 * @param currPointer
	 * @return
	 */
	private int[] constructCandidates(int currPointer) {
		return null;
	}

	/**
	 * �������еĿռ䣬û�м�֦ ��֦Ӧ��ͨ���ж� ������һ�������� ֱ�ӷ��� �����Բ��÷ǵݹ��ʵ�ַ�ʽ
	 * 
	 * @param currPointer
	 *            currPointer= -1;
	 */
	public void backTrack(int currPointer) {

		if (isSolution(currPointer)) {
			processSolution();
		}

		currPointer = currPointer + 1;

		int[] candidates = null;
		candidates = constructCandidates(currPointer);

		if (candidates != null) {
			for (int i = 0; i < candidates.length; i++) {
				solutionVec[currPointer] = candidates[i];
				backTrack(currPointer);
			}
		}
		return;

	}

}
