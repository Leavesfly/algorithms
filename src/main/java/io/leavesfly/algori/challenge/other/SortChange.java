package io.leavesfly.algori.challenge.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortChange {

	private static Element[] neededArray;
	public static final int PAGE_NUM = 5;
	public static final int TOTAL_NUM = 100;

	public static Element[] getNeededArray() {
		return neededArray;
	}

	public static void setNeededArray(Element[] neededArray) {
		Element.setCompareType(CompareType.BY_ID_ORDER);
		Arrays.sort(neededArray);
		SortChange.neededArray = neededArray;
	}

	private static List<Pair> getGroupList() {
		List<Pair> groupList = new ArrayList<Pair>();
		Element.setCompareType(CompareType.BY_SELLER_NICKNAME);
		Arrays.sort(neededArray);
		int point = 0;
		Pair pair = null;
		for (int i = 0; i < neededArray.length; i++) {
			if (i == neededArray.length - 1) {
				pair = new Pair(point, i);
				groupList.add(pair);

				return groupList;
			}
			if (neededArray[i].compareTo(neededArray[point]) != 0) {
				pair = new Pair(point, i - 1);
				groupList.add(pair);
				point = i;
			}

		}
		return groupList;
	}

	private static void sortPairListInner(List<Pair> groupList) {

		Element.setCompareType(CompareType.BY_ID_ORDER);
		Pair tmp = null;
		for (int i = 0; i < groupList.size(); i++) {
			tmp = groupList.get(i);
			if (tmp.getPairStart() < tmp.getPairEnd()) {
				Arrays.sort(neededArray, tmp.getPairStart(), tmp.getPairEnd());
			}
		}
	}

	private static void sortPairList(List<Pair> groupList) {

		Collections.sort(groupList);
	}

	private static Element[] pickFromGroupList(List<Pair> groupList, int num) {
		Element[] res = new Element[num];
		int start = 0;
		int tmp = 0;
		int size = groupList.size();
		// TODO
		for (int i = 0; i < num; i++) {

			tmp = i % size % groupList.size();

			start = groupList.get(tmp).getPairStart();
			res[i] = neededArray[start];
			if (start == groupList.get(tmp).getPairEnd()) {
				groupList.remove(tmp);
				continue;
			}
			groupList.get(tmp).setPairStart(++start);
		}
		return res;
	}

	public static Element[][] sortChange() {
		Element[][] result = new Element[PAGE_NUM][];
		Element[] tmp = null;
		List<Pair> pairList = getGroupList();
		sortPairListInner(pairList);
		sortPairList(pairList);
		int num = TOTAL_NUM / PAGE_NUM;
		for (int i = 0; i < PAGE_NUM; i++) {
			tmp = pickFromGroupList(pairList, num);
			result[i] = tmp;
			sortPairList(pairList);
		}
		return result;
	}

	public static void printRes(Element[][] res) {
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.println(res[i][j]);
			}
			System.out.println("------------------------------------------");
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Element[] neededArray = new Element[SortChange.TOTAL_NUM];
		Element ele = null;
		Random rand = new Random();
		for (int i = 0; i < SortChange.TOTAL_NUM; i++) {
			ele = new Element(i, new Integer(rand.nextInt(10)).toString());
			neededArray[i] = ele;
		}
		SortChange.setNeededArray(neededArray);
		Element[][] res = SortChange.sortChange();
		SortChange.printRes(res);

	}
}

class Pair implements Comparable<Pair> {

	private int[] pair = new int[2];

	public Pair(int start, int end) {
		pair[0] = start;
		pair[1] = end;
	}

	public int getPairStart() {
		return pair[0];
	}

	public int getPairEnd() {
		return pair[1];
	}

	public void setPairStart(int start) {
		pair[0] = start;
	}

	public void setPairEnd(int end) {
		pair[1] = end;
	}

	public int compareTo(Pair o) {

		Element.setCompareType(CompareType.BY_ID_ORDER);
		return SortChange.getNeededArray()[pair[0]].compareTo(SortChange.getNeededArray()[o
				.getPairStart()]);
	}

}

enum CompareType {
	BY_ID_ORDER, BY_SELLER_NICKNAME
}

class Element implements Comparable<Element> {

	private static CompareType compareType = CompareType.BY_ID_ORDER;

	private int idOrder;
	private String sellerNickname;

	public Element(int idOrder, String sellerNickname) {
		this.idOrder = idOrder;
		this.sellerNickname = sellerNickname;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getSellerNickname() {
		return sellerNickname;
	}

	public void setSellerNickname(String sellerNickname) {
		this.sellerNickname = sellerNickname;
	}

	public static CompareType getCompareType() {
		return compareType;
	}

	public static void setCompareType(CompareType compareType) {
		Element.compareType = compareType;
	}

	public int compareTo(Element o) {
		if (compareType == CompareType.BY_ID_ORDER) {
			return idOrder - o.getIdOrder();
		} else {
			return sellerNickname.hashCode() - o.getSellerNickname().hashCode();
		}
	}

	@Override
	public String toString() {
		return "{" + idOrder + "," + sellerNickname + "}";
	}

}
