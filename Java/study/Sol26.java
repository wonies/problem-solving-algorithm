package study;

//기능개발

import java.util.*;

class Sol26 {
	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answer = new ArrayList<>();
		Queue<Integer> daysQueue = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {

			int remainingProgress = 100 - progresses[i];
			int daysNeeded = (remainingProgress + speeds[i] - 1) / speeds[i];

			daysQueue.offer(daysNeeded);
		}

		while (!daysQueue.isEmpty()) {
			int currentDay = daysQueue.poll();
			int count = 1;

			while (!daysQueue.isEmpty() && daysQueue.peek() <= currentDay) {
				daysQueue.poll();
				count++;
			}

			answer.add(count);
		}

		int[] result = new int[answer.size()];
		for (int i = 0; i < answer.size(); i++) {
			result[i] = answer.get(i);
		}

		return result;
	}
}
