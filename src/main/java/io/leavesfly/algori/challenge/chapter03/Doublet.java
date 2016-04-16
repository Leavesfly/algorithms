package io.leavesfly.algori.challenge.chapter03;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author leavesfly 1.����ͼ��ģ�� 2.�þ�������n-1�� 3.��ȱ����֦ 4.����Ҷ�ӽڵ�������2������2��С��2�����ε��ж�
 */
public class Doublet {

	private List<StringNode> stringNodeList = new ArrayList<StringNode>();
	private Stack<StringNode> strNodeStack = new Stack<StringNode>();

	public List<StringNode> getStringNodeList() {
		return stringNodeList;
	}

	public void setStringNodeList(List<StringNode> stringNodeList) {
		this.stringNodeList = stringNodeList;
	}

	// ������ȱ���ͼ�ṹ������ֻ��һ����ĸ���¼���Ľڵ㵥�ʲ�ͬ�Ľڵ㣬���ؽڵ�ָ����б�
	private List<StringNode> findMatchedNodes(StringNode strNode) {
		List<StringNode> strNodeList = new ArrayList<StringNode>();
		LinkedQueue unvisitedNodes = new LinkedQueue();
		Set<StringNode> visitedNodes = new HashSet<StringNode>();

		if (stringNodeList.size() != 0) {
			if (stringNodeList.get(0).isDoublet(strNode)) {
				strNodeList.add(stringNodeList.get(0));
			}
			visitedNodes.add(stringNodeList.get(0));
			for (StringNode strNodeTemp : stringNodeList.get(0).getEdges()) {
				unvisitedNodes.inQuene(strNodeTemp);
			}
			while (!unvisitedNodes.isQueueEmpty()) {
				StringNode strNodeOutQueue = unvisitedNodes.outQueue();
				if (strNodeOutQueue.isDoublet(strNode)) {
					strNodeList.add(strNodeOutQueue);
				}
				visitedNodes.add(strNodeOutQueue);
				for (StringNode strNodeTemp : strNodeOutQueue.getEdges()) {
					if (visitedNodes.contains(strNodeOutQueue)) {
						unvisitedNodes.inQuene(strNodeTemp);
					}
				}
			}

		} else {
			stringNodeList.add(strNode);
		}

		System.out.println("��ȱ�����һ��ͼ");

		return strNodeList;
	}

	// ����ͼ�Ľṹ
	public void structureGraph() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		StringNode stringNode = null;
		if (!str.equalsIgnoreCase("end")) {
			stringNode = new StringNode(str);
		} else {
			System.out.println("����ͼ�ṹʧ�ܣ��˳�����");
			System.exit(0);
		}
		while (!(str = scanner.nextLine()).equalsIgnoreCase("end")) {
			stringNode = new StringNode(str);
			List<StringNode> strNodeList = findMatchedNodes(stringNode);
			if (strNodeList.size() != 0) {
				stringNodeList.add(stringNode);
				for (StringNode strNodeTemp : strNodeList) {
					strNodeTemp.getEdges().add(stringNode);

					stringNode.getEdges().add(strNodeTemp);

				}
			}
		}
		System.out.println("������ͼ�Ľṹ");
	}

	// ����·��
	public boolean findRoute() {
		for (StringNode strNode : stringNodeList) {
			strNodeStack.push(strNode);
			StringNode strNextNode = strNode.getEdges().get(0);
			strNode.addNextPointNum();
			// ��ջ����ݹ�
			while (!strNodeStack.empty()) {
				while (!containsObjectNotInStack(strNodeStack, strNextNode)) {
					strNodeStack.push(strNextNode);
					strNextNode.addNextPointNum();
					strNextNode = strNextNode.getEdges().get(0);
				}
				if (strNodeStack.size() == stringNodeList.size()) {
					return true;
				}
				strNodeStack.pop();
				if (!strNodeStack.empty()) {
					strNextNode = strNodeStack.peek();
					if ((strNextNode.getNextPointNum() <= strNextNode
							.getEdges().size() - 1)
							&& !containsObjectNotInStack(
									strNodeStack,
									strNextNode.getEdges().get(
											strNextNode.getNextPointNum()))) {
						strNodeStack.push(strNextNode.getEdges().get(
								strNextNode.getNextPointNum()));
						strNextNode.addNextPointNum();
						if (strNodeStack.size() == stringNodeList.size()) {
							return true;
						}
					} else {
						if (strNextNode.getNextPointNum() > strNextNode
								.getEdges().size() - 1) {
							strNodeStack.pop();
							strNextNode = strNodeStack.peek();
						} else {
							strNextNode.addNextPointNum();
						}
					}

				}

			}
		}

		return false;
	}

	protected boolean containsObjectNotInStack(Stack<StringNode> strNodeStack,
			StringNode strNode) {
		if (strNodeStack.search(strNode) == -1) {
			return false;
		}
		return true;
	}

}

class StringNode {
	private String str;
	private List<StringNode> edges;
	private int nextPointNum;

	public StringNode(String str) {
		this.str = new String(str);
		edges = new ArrayList<StringNode>();
		nextPointNum = 0;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public List<StringNode> getEdges() {
		return edges;
	}

	public void setEdges(List<StringNode> edges) {
		this.edges = edges;
	}

	public void addNextPointNum() {
		nextPointNum++;
	}

	public int getNextPointNum() {
		return nextPointNum;
	}

	public void setNextPointNum(int nextPointNum) {
		this.nextPointNum = nextPointNum;
	}

	public boolean isDoublet(StringNode strNode) {
		if (strNode.getStr().length() == this.str.length()) {
			int equalNum = 0;
			for (int i = 0; i < this.str.length(); i++) {
				if (strNode.getStr().charAt(i) == this.str.charAt(i)) {
					equalNum++;
				}
			}
			if (equalNum == this.str.length() - 1) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
