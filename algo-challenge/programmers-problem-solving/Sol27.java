package study;

import java.util.*;

class Sol27 {
	public int[] solution(String s) {
		s = s.substring(2, s.length() - 2);
		s = s.replace("},{", "-");

		String[] sets = s.split("-");
		Arrays.sort(sets, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		ArrayList<Integer> result = new ArrayList<>();
		HashSet<Integer> elements = new HashSet<>();

		for (String set : sets) {
			String[] numbers = set.split(",");

			for (String numStr : numbers) {
				int num = Integer.parseInt(numStr);

				if (!elements.contains(num)) {
					result.add(num);
					elements.add(num);
				}
			}
		}

		int[] answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}
}
