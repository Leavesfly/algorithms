package io.leavesfly.algori.challenge.chapter03;


import java.util.LinkedList;


public class LinkedQueue {
	//ʹ������ʵ�ֶ���
	private LinkedList<StringNode> queue= new LinkedList<StringNode>();
	

	public void inQuene(StringNode strNode){
		queue.addLast(strNode);
	}

	public StringNode outQueue(){
		return queue.removeFirst();
	}
	

	public boolean isQueueEmpty(){
		return queue.isEmpty();
	}

	public boolean contians(StringNode strNode){
		return queue.contains(strNode);
	}
	
}
