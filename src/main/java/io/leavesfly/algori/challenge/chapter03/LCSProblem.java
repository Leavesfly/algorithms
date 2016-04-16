package io.leavesfly.algori.challenge.chapter03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author leavesfly
 * 
 */
public class LCSProblem {

	public static <E> List<E> getLongestCommonSubsequence(List<E> s_1,
			List<E> s_2) {
		int[][] longestNum = new int[s_1.size()][s_2.size()];

		// ��̬�滮�����
		for (int i = 1; i <= s_1.size(); i++) {
			for (int j = 1; j <= s_2.size(); j++) {
				if (s_1.get(i - 1).equals(s_2.get(j - 1))) {
					longestNum[i][j] = longestNum[i - 1][j - 1];
				} else {
					longestNum[i][j] = Math.max(longestNum[i - 1][j],
							longestNum[i][j - 1]);
				}
			}
		}

		System.out.println("length of LCS:"
				+ longestNum[s_1.size()][s_2.size()]);

		int s_1Position = s_1.size();
		int s_2Position = s_2.size();
		List<E> result = new ArrayList<E>();

		while (s_1Position != 0 && s_2Position != 0) {
			if (s_1.get(s_1Position - 1).equals(s_2.get(s_2Position - 1))) {
				result.add(s_1.get(s_1Position - 1));
				s_1Position--;
				s_2Position--;
			} else if (longestNum[s_1Position][s_2Position - 1] >= longestNum[s_1Position - 1][s_2Position]) {
				s_2Position--;
			} else {
				s_1Position--;
			}
		}

		Collections.reverse(result);

		return null;
	}
}
