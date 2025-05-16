// 아날로그 시계 = 반개만 맞음 ㅠ
public class Sol104 {
	public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
		int start = h1 * 3600 + m1 * 60 + s1;
		int end = h2 * 3600 + m2 * 60 + s2;
		int count = 0;

		for (int t = start; t < end; t++) {
			double hourAngle = (t % 43200) * (360.0 / 43200);
			double minuteAngle = (t % 3600) * (360.0 / 3600);
			double secondAngle = (t % 60) * (360.0 / 60);

			double nextSecondAngle = ((t + 1) % 60) * (360.0 / 60);

			if (crossed(hourAngle, secondAngle, nextSecondAngle)) count++;

			if (crossed(minuteAngle, secondAngle, nextSecondAngle)) count++;
		}

		return count;
	}

	private boolean crossed(double target, double current, double next) {
		if (current > next) {
			return target >= current || target <= next;
		} else {
			return target >= current && target <= next;
		}
	}
}
