import java.util.*;

class Sol97 {
	public int solution(int[][] points, int[][] routes) {
		Map<Integer, int[]> pointMap = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			pointMap.put(i + 1, points[i]);
		}

		Map<Integer, Map<String, Integer>> timePositionMap = new HashMap<>();

		for (int[] route : routes) {
			int time = 0;
			int[] cur = pointMap.get(route[0]);

			for (int i = 1; i < route.length; i++) {
				int[] next = pointMap.get(route[i]);
				int r1 = cur[0], c1 = cur[1];
				int r2 = next[0], c2 = next[1];

				while (r1 != r2) {
					r1 += (r1 < r2) ? 1 : -1;
					recordPosition(timePositionMap, ++time, r1, c1);
				}

				while (c1 != c2) {
					c1 += (c1 < c2) ? 1 : -1;
					recordPosition(timePositionMap, ++time, r1, c1);
				}

				cur = next;
			}
		}

		int dangerCount = 0;
		for (Map<String, Integer> posCount : timePositionMap.values()) {
			for (int count : posCount.values()) {
				if (count >= 2) dangerCount++;
			}
		}

		return dangerCount;
	}

	private void recordPosition(Map<Integer, Map<String, Integer>> map, int time, int r, int c) {
		map.putIfAbsent(time, new HashMap<>());
		String key = r + "," + c;
		map.get(time).put(key, map.get(time).getOrDefault(key, 0) + 1);
	}
}
