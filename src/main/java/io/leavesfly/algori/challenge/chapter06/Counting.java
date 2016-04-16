package io.leavesfly.algori.challenge.chapter06;

/**
 * ������οռ乹����ƹ�ʽ��F(n)=2*F(n-1)+F(n-2)+F(n-3); F(1)=2; F(2)=5; F(3)=9;
 * 
 * @author leavesfly
 * 
 */
public class Counting {
	private static final int circleQueueNum = 4;

	public static int getCountNum(int num) {
		int[] circleQueue = new int[circleQueueNum];
		circleQueue[0] = 2;
		circleQueue[1] = 5;
		circleQueue[2] = 9;
		if (num == 1) {
			return circleQueue[0];
		}
		if (num == 2) {
			return circleQueue[1];
		}
		if (num == 3) {
			return circleQueue[2];
		}
		int point = 4;
		while (point <= num) {
			circleQueue[(point - 1) % circleQueueNum] = 2
					* circleQueue[(point - 2) % circleQueueNum]
					+ circleQueue[(point - 3) % circleQueueNum]
					+ circleQueue[(point - 4) % circleQueueNum];
			point++;
		}
		point--;

		return circleQueue[(point - 1) % circleQueueNum];
	}
	
	
	public static void main(String[] args){
		for(int i=1;i<=10;i++){
			System.out.println(Counting.getCountNum(i));
		}
		
	}

}
