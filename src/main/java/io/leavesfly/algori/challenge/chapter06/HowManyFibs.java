package io.leavesfly.algori.challenge.chapter06;

public class HowManyFibs {
	
	private static final int circleQueueNum=3;
	/**
	 * ʹ����һ�����ζ��н�Լ�ռ�
	 * @param lower
	 * @param upper
	 * @return
	 */
	public static int getNumOfFibs(int lower ,int upper){
		int[] circleQueue=new int[circleQueueNum];
		circleQueue[0]=1;
		circleQueue[1]=2;
		int point=3;
		int fib=0;
		int lowerNum=0;
		while(fib<lower){
			fib=circleQueue[(point-2)%circleQueueNum]+circleQueue[(point-3)%circleQueueNum];
			circleQueue[(point-1)%circleQueueNum]=fib;
			point++;
		}
		lowerNum=point;
		while(fib<upper){
			fib=circleQueue[(point-2)%circleQueueNum]+circleQueue[(point-3)%circleQueueNum];
			circleQueue[(point-1)%circleQueueNum]=fib;
			point++;
		}	
		return point-lowerNum;
	}
	
	public static void main(String[] args){
		System.out.println(HowManyFibs.getNumOfFibs(10, 100));
		System.out.println(HowManyFibs.getNumOfFibs(123456789, 987654321));
	}
}
