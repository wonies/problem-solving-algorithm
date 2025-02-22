package study;

//귤 고르기
import java.io.*;
import java.util.*;

public class Sol16 {
	public int solution(int k, int[] numbers) {
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
}
