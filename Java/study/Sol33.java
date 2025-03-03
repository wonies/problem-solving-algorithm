package study;
//롤케이크 자르기

import java.io.*;
import java.util.*;

class Sol33 {
	public int solution(int[] topping) {
		int len = topping.length;
		int cnt = 0;

		HashSet<Integer> left = new HashSet<>();
		HashMap<Integer, Integer> right = new HashMap<>();

		for (int top: topping)
		{
			right.put(top, right.getOrDefault(top, 0) + 1);
		}

		for (int top: topping)
		{
			left.add(top);
			right.put(top, right.get(top) - 1);

			if (right.get(top) == 0)
				right.remove(top);
			if (left.size() == right.size())
				cnt++;
		}
		return cnt;
	}
}
