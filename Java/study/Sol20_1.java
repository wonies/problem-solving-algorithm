package study;

import java.io.*;
import java.util.*;

public class Sol20_1 {
	public int solution(String[] want, int[] number, String[] dis)
	{
		int ans = 0;
		Map<String, Integer> wantMap = new HashMap<>();
		for (int i=0; i<want.length; i++)
			wantMap.put(want[i], number[i]);
		Map<String, Integer> curMap = new HashMap<>();
		for (int i=0; i<10; i++)
			curMap.put(dis[i], curMap.getOrDefault(dis[i], 0) + 1);
		if (checkWant(wantMap, curMap)) ans++;

		for (int i = 10; i  < dis.length; i++)
		{
			curMap.put(dis[i-10], curMap.get(dis[i-10]) - 1);
			if (curMap.get(dis[i-10]) == 0) curMap.remove(dis[i-10]);
			curMap.put(dis[i], curMap.getOrDefault(dis[i], 0 ) + 1);
			if (checkWant(wantMap, curMap)) ans++;
		}
		return ans;
	}

	private boolean checkWant(Map<String, Integer> want, Map<String, Integer> cur){
		for (String key : want.keySet())
			if (!cur.containsKey(key) || cur.get(key) != want.get(key)) return false;
		return true;
	}
}
