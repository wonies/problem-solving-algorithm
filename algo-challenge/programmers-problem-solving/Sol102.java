import java.util.*;

class Sol102 {
	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		int[] answer = new int[balls.length];

		for (int i = 0; i < balls.length; i++) {
			int targetX = balls[i][0];
			int targetY = balls[i][1];
			int minDistSquared = Integer.MAX_VALUE;

			int[][] reflections = {
				{ targetX, -targetY },
				{ targetX, 2 * n - targetY },
				{ -targetX, targetY },
				{ 2 * m - targetX, targetY }
			};

			for (int[] reflected : reflections) {
				int rx = reflected[0];
				int ry = reflected[1];

				int dx = rx - startX;
				int dy = ry - startY;


				if (dx == 0 && startX == targetX) {
					if ((startY < targetY && ry < targetY) || (startY > targetY && ry > targetY)) {
						continue;
					}
				}
				if (dy == 0 && startY == targetY) {
					if ((startX < targetX && rx < targetX) || (startX > targetX && rx > targetX)) {
						continue;
					}
				}

				int distSquared = dx * dx + dy * dy;
				minDistSquared = Math.min(minDistSquared, distSquared);
			}

			answer[i] = minDistSquared;
		}

		return answer;
	}
}
