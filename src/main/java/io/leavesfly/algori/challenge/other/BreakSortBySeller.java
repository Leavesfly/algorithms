package io.leavesfly.algori.challenge.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class BreakSortBySeller {

	// private static final Logger logger = LoggerFactory
	// .getLogger(BreakSortBySeller.class);

	private static final int BREAK_PAGW_NUM = 5;

	private int pageSize;

	private List<OfferDO> offerDOList;

	private boolean isBreakSort = true;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Random rand = new Random();
		List<OfferDO> offerDOList = new ArrayList<OfferDO>();
		OfferDO offerDO = null;
		int pageSize = 20;
		int pageIndex = 5;

		for (int i = 0; i < 10; i++) {
			// offerDO = new OfferDO(i, rand.nextInt(5));
			offerDO = new OfferDO(i, 1);
			offerDOList.add(offerDO);
		}
		for (int i = 10; i < 20; i++) {
			offerDO = new OfferDO(i, rand.nextInt(10));
			// offerDO = new OfferDO(i, 2);
			offerDOList.add(offerDO);
		}
		for (int i = 20; i < 35; i++) {
			// offerDO = new OfferDO(i, rand.nextInt(20));
			offerDO = new OfferDO(i, 3);
			offerDOList.add(offerDO);
		}
		for (int i = 35; i < 91; i++) {
			offerDO = new OfferDO(i, rand.nextInt(50));
			// offerDO = new OfferDO(i, 4);
			offerDOList.add(offerDO);
		}

		BreakSortBySeller breakSortBySeller = new BreakSortBySeller(offerDOList, pageSize);
		breakSortBySeller.setBreakSort(false);
		List<OfferDO> resOfferDOList = breakSortBySeller.getResultAfterBreakSortBySeller(pageIndex);
		for (int i = 0; i < resOfferDOList.size(); i++) {

			System.out.println(resOfferDOList.get(i).toString());
		}
		System.out.println("-------------------------------");

		breakSortBySeller.setBreakSort(true);
		resOfferDOList = breakSortBySeller.getResultAfterBreakSortBySeller(pageIndex);
		for (int i = 0; i < resOfferDOList.size(); i++) {

			System.out.println(resOfferDOList.get(i).toString());
		}

	}

	/**
	 * 
	 * @param offerDOList
	 * @param pageSize
	 */
	public BreakSortBySeller(List<OfferDO> offerDOList, int pageSize) {
		if (offerDOList.size() > pageSize * BREAK_PAGW_NUM || offerDOList.size() <= 0) {
			isBreakSort = false;
			// logger.error("BreakSortBySellerUtil()����ݳ��ִ���");
		} else {
			this.pageSize = pageSize;
			this.offerDOList = offerDOList;
		}
	}

	/**
	 * 
	 * @param indexPage
	 * @return
	 */
	public List<OfferDO> getResultAfterBreakSortBySeller(int indexPage) {
		List<OfferDO> retOfferDOList = null;

		if (!isBreakSort) {
			retOfferDOList = getPageListByPageIndex(indexPage, this.offerDOList);
			return retOfferDOList;
		}

		Map<Long, Integer> sellerIdMap = new HashMap<Long, Integer>();
		List<BreakSortEntity> breakSortList = new LinkedList<BreakSortEntity>();

		Long sellerId = null;
		OfferDO offerDO = null;
		BreakSortEntity breakSortEntity = null;
		Set<Integer> seted = new HashSet<Integer>();
		int nowIndex = 0;

		for (int i = 0; i < offerDOList.size(); i++) {
			offerDO = offerDOList.get(i);
			sellerId = offerDO.getUserId();

			if (!sellerIdMap.containsKey(sellerId)) {
				sellerIdMap.put(sellerId, 1);
				breakSortEntity = new BreakSortEntity(nowIndex, offerDO);
				seted.add(nowIndex);
				nowIndex = getNextIndex(seted, i + 1);
				breakSortList.add(0, breakSortEntity);// �ŵ��б���ǰ��

			} else {
				int num = sellerIdMap.get(sellerId);

				int backMoveToPosition = pageSize / 2 * num + nowIndex;// �ƶ����λ��
				seted.add(backMoveToPosition);
				nowIndex = getNextIndex(seted, i + 1);
				breakSortEntity = new BreakSortEntity(backMoveToPosition, offerDO);
				breakSortList.add(breakSortEntity);
				sellerIdMap.put(sellerId, ++num);
			}
		}

		Collections.sort(breakSortList);

		List<OfferDO> tmp = new ArrayList<OfferDO>(breakSortList.size());
		for (int i = 0; i < breakSortList.size(); i++) {
			tmp.add(breakSortList.get(i).getOfferDO());
		}

		// ��ȡ��ɢ֮����ض�ҳ������
		retOfferDOList = getPageListByPageIndex(indexPage, tmp);
		isBreakSort = false;
		return retOfferDOList;
	}

	int getNextIndex(Set<Integer> s, int max) {
		for (int i = 0; i < max; i++) {
			if (!s.contains(i))
				return i;
		}
		return max;
	}

	/**
	 * 
	 * @param indexPage
	 * @param offerDOList
	 * @return
	 */
	private List<OfferDO> getPageListByPageIndex(int indexPage, List<OfferDO> offerDOList) {
		List<OfferDO> retOfferDOList = new ArrayList<OfferDO>(pageSize);

		int startIndex = (indexPage - 1) * pageSize;
		int endIndex = indexPage * pageSize <= offerDOList.size() ? indexPage * pageSize
				: offerDOList.size();
		for (int i = startIndex; i < endIndex; i++) {
			retOfferDOList.add(offerDOList.get(i));
		}

		return retOfferDOList;
	}

	public boolean isBreakSort() {
		return isBreakSort;
	}

	public void setBreakSort(boolean isBreakSort) {
		this.isBreakSort = isBreakSort;
	}

	/**
	 * 
	 * @author LeavesFly
	 * 
	 */
	class BreakSortEntity implements Comparable<BreakSortEntity> {
		private int indexPos;
		private OfferDO offerDO;

		public BreakSortEntity(int indexPos, OfferDO offerDO) {
			this.indexPos = indexPos;
			this.offerDO = offerDO;
		}

		public int getIndexPos() {
			return indexPos;
		}

		public void setIndexPos(int indexPos) {
			this.indexPos = indexPos;
		}

		public OfferDO getOfferDO() {
			return offerDO;
		}

		public void setOfferDO(OfferDO offerDO) {
			this.offerDO = offerDO;
		}

		public int compareTo(BreakSortEntity o) {
			if (indexPos > o.getIndexPos()) {
				return 1;
			} else if (indexPos < o.getIndexPos()) {
				return -1;
			} else {
				return 0;
			}
		}

	}
}

class OfferDO {
	private int order;
	private Long userId;

	public OfferDO(int order, long userId) {
		this.order = order;
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "{" + order + ",����" + userId + "}";
	}

}
