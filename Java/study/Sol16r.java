package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Sol16r {
	public static int solution(int k, int[] numbers) {
		int answer = 0;
		HashMap<Integer, Integer> counts = new HashMap<>();

		for (int num : numbers)
			counts.put(num, counts.getOrDefault(num, 0) + 1);

		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(counts.entrySet());
		Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));

		int cnt = 0;

		for (Map.Entry<Integer, Integer> entry : list)
		{

			if (k - entry.getValue() >= 0)
			{
				cnt++;
				k -= entry.getValue();
			}
			else if (entry.getValue() > k && k > 0)
			{
				cnt++;
				return cnt;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		int[] tan = {1, 3, 2, 5, 4, 5, 2, 3};
		int[] tan2 = {1, 3, 2, 5, 4, 5, 2, 3};
		int[] tan3 = {1, 1, 1, 1, 2, 2, 2, 3};
		int[] tan4 = {1000, 2000, 2000, 1000};
		int[] tan5 = {1};
		System.out.println(solution(6, tan));
		System.out.println(solution(4, tan2));
		System.out.println(solution(2, tan3));
		System.out.println(solution(2, tan4));
		System.out.println(solution(1, tan5));
	}

}
