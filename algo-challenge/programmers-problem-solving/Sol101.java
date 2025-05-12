//유사 칸토어 비트열
class Sol101 {
	public long solution(int n, long l, long r) {
		int answer = 0;
		return countOne(n, l - 1, r - 1);
	}

	private long countOne(int n, long l, long r) {
		if(n==0) return 1;
		long len = (long) Math.pow(5, n-1);
		long cnt = 0;

		for (int i=0; i<5; i++) {
			long start = len * i;
			long end = len * (i + 1) - 1;

			if (r < start || l > end) continue ;
			if (i == 2) continue ;

			long newL = Math.max(l, start) - start;
			long newR = Math.min(r, end) - start;
			cnt += countOne(n-1, newL, newR);
		}
		return cnt;
	}
}
