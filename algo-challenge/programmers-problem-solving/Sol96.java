//순위검색

import java.util.*;

class Sol96 {
	Map<String, List<Integer>> map = new HashMap<>();

	public int[] solution(String[] info, String[] query) {
		for (String i : info) {
			String[] parts = i.split(" ");
			String[] keys = {parts[0], parts[1], parts[2], parts[3]};
			int score = Integer.parseInt(parts[4]);
			makeCombi(keys, 0, "", score);
		}

		for (List<Integer> list : map.values()) {
			Collections.sort(list);
		}

		int [] answer = new int[query.length];
		for (int i=0; i<query.length; i++) {
			String q = query[i].replaceAll(" and "," ");
			String[] parts = q.split(" ");
			String key = parts[0] + parts[1] + parts[2] + parts[3];
			int score = Integer.parseInt(parts[4]);

			if (map.containsKey(key)) {
				List<Integer> list = map.get(key);
				answer[i] = countScore(list,score);
			} else {
				answer[i] = 0;
			}
		}
		return answer;
	}

	private void makeCombi(String[] arr, int depth, String key, int score) {
		if (depth == 4) {
			map.computeIfAbsent(key, k->new ArrayList<>()).add(score);
			return ;
		}
		makeCombi(arr, depth + 1, key + arr[depth], score);
		makeCombi(arr, depth + 1, key + "-", score);
	}

	private int countScore(List<Integer> list, int score) {
		int left = 0, right = list.size();
		while (left < right) {
			int mid = (left + right) / 2;
			if (list.get(mid) < score) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return list.size() - left;
	}


}
