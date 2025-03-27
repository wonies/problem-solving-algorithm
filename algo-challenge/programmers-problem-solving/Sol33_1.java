package study;

// 롤케이크 자르기 - 시간초과실패

import java.util.*;

class Sol33_1 {
	public int solution(int[] topping) {
		int answer = -1;
		int len = topping.length;
		Map<Integer,Integer> map = new HashMap<>();
		int left = 0;
		int right = 1;
		Set<Integer> set = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		System.out.println(len);
		int res = 0;

		while (right < len)
		{
			for (int i=0; i<=left ; i++)
			{
				set.add(topping[i]);
			}
			for (int j=right; j <= len - 1; j++)
			{
				set2.add(topping[j]);
			}
			left++;
			right++;

			if (set.size() == set2.size())
			{
				res++;
			}
			set.clear();
			set2.clear();
		}

		return res;
	}
}
