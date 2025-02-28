package study;

//1차캐시

import java.util.*;

class Sol25 {
	public int solution(int cacheSize, String[] cities) {

		if (cacheSize == 0) {
			return cities.length * 5;
		}

		LinkedList<String> cache = new LinkedList<>();
		int totalTime = 0;

		for (String city : cities) {
			String cityLower = city.toLowerCase();

			if (cache.contains(cityLower)) {
				totalTime += 1;
				cache.remove(cityLower);
				cache.addLast(cityLower);
			}
			else {
				totalTime += 5;

				if (cache.size() >= cacheSize) {
					cache.removeFirst();
				}

				if (cacheSize > 0) {
					cache.addLast(cityLower);
				}
			}
		}

		return totalTime;
	}
}
