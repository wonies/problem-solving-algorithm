// 3XN타일링
class Sol98 {
	public int solution(int n) {

		if (n % 2 == 1)
			return 0;
		int[] dp = new int[n + 1];
		final int MOD = 1000000007;

		dp[0] = 1;
		if (n >= 2) dp[2] = 3;

		for (int i=4; i<=n; i+=2)
			dp[i] = (int)(((long)dp[i - 2] * 4 - dp[i - 4] + MOD) % MOD);


		return dp[n];
	}
}
