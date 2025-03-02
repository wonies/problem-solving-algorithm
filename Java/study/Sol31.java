package study;

//뉴스 클러스터링

import java.io.*;
import java.util.*;

class Sol31 {

	private static Map<String, Integer> getMulti(String str)
	{
		Map<String, Integer> map = new HashMap<>();
		str = str.toUpperCase();

		for (int i = 0; i < str.length() - 1; i++)
		{
			char first = str.charAt(i);
			char second = str.charAt(i+1);

			if (Character.isLetter(first) && Character.isLetter(second))
			{
				String pair = "" + first + second;
				map.put(pair, map.getOrDefault(pair, 0) + 1);
			}
		}
		return map;
	}


	public int solution(String str1, String str2) {
		Map<String, Integer> map1 = getMulti(str1);
		Map<String, Integer> map2 = getMulti(str2);

		Set<String> set = new HashSet<>();
		set.addAll(map1.keySet());
		set.addAll(map2.keySet());


		int union = 0;
		int inter = 0;

		for (String str : set)
		{
			int cnt = map1.getOrDefault(str, 0);
			int cnt2 = map2.getOrDefault(str, 0);
			union += Math.max(cnt, cnt2);
			inter += Math.min(cnt, cnt2);
		}

		return union == 0 ? 1 * 65536 : (int) Math.floor(((double) inter / union ) * 65536);
	}
}
