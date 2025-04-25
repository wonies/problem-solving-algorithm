// 두 원 사이의 정수합

public class Sol88 {

	public long solution(int r1, int r2) {
		long answer = 0;

		if (r1 > r2)
			return -1;

		for (int x = 1; x <= r2; x++) {
			int yMax = (int)Math.floor(Math.sqrt((long)r2 * r2 - (long)x * x));
			int yMin = 0;
			if (x < r1)
				yMin = (int)Math.ceil(Math.sqrt((long)r1 * r1 - (long)x * x));
			answer += (yMax - yMin + 1);
		}

		return answer * 4;
	}
}
