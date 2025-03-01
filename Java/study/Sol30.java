package study;

//프로세스
import java.util.*;

class Sol30 {
	public int solution(int[] priorities, int location) {
		int answer = 0;

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			queue.add(new int[] {i, priorities[i]});
		}

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			boolean hasHigherPriority = false;
			for (int[] process : queue) {
				if (process[1] > current[1]) {
					hasHigherPriority = true;
					break;
				}
			}

			if (hasHigherPriority) {
				queue.add(current);
			} else {
				answer++;

				if (current[0] == location) {
					return answer;
				}
			}
		}

		return answer;
	}
}
