package study;

import java.io.*;
import java.util.*;

class Sol39 {
	private HashMap<String, Integer> setAlpha()
	{
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<26; i++)
		{
			char c = (char)('A' + i);
			map.put(String.valueOf(c), i + 1);
		}
		return map;
	}

	public int[] solution(String msg)
	{
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<String, Integer> map = setAlpha();
		int seq = 27;
		int idx = 0;
		while (idx < msg.length())
		{
			String cur = "";
			String next = "";

			cur = String.valueOf(msg.charAt(idx));
			int i = idx;

			while (i < msg.length()) {
				if (i+1 < msg.length()) {
					next = cur + msg.charAt(i+1);
					if (map.containsKey(next))
					{
						cur = next;
						i++;
					}
					else {
						break;
					}
				} else {
					break ;
				}
			}
			res.add(map.get(cur));
			if (i + 1 < msg.length())
				map.put(cur + msg.charAt(i+1), seq++);
			idx = i + 1;

		}
		return res.stream().mapToInt(Integer::intValue).toArray();
	}
}
