package study;

//땅따먹기 - 시간초과

class Sol44_1 {
	static int ans;

	void dfs(int[][] land, int row, int prev, int cnt)
	{

		if (row == land.length)
		{
			ans = Math.max(ans, cnt);
			return ;
		}

		for (int col = 0; col < land[row].length; col++)
		{
			if (col == prev) continue ;
			dfs(land, row + 1, col, cnt + land[row][col]);
		}
	}


	int solution(int[][] land) {
		ans = 0;
		dfs(land, 0, 0, 0);

		return ans;
	}
}
