package study;

import java.util.*;

public class LRUCache {
	private static int capacity;
	private static LinkedList<String> cacheList;
	private static HashSet<String> cacheSet;

	public LRUCache(int capacity)
	{
		this.capacity = capacity;
		this.cacheList = new LinkedList<>();
		this.cacheSet = new HashSet<>();
	}

	public static int solution(int cacheSize, String [] cities)
	{
		int time = 0;
		for (String city : cities)
		{
			city = city.toLowerCase();
			if (cacheSet.contains(city))
			{
				time += 1;
				cacheList.remove(city);
			}
			else
			{
				time += 5;
				if (cacheList.size() >= capacity)
				{
					String oldest = cacheList.removeFirst();
					cacheSet.remove(oldest);
				}
			}
			cacheList.addLast(city);
			cacheSet.add(city);
		}
		return time;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(LRUCache.solution(3, cities));
	}
}
