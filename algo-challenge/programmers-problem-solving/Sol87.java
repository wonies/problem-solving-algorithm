// N퀸

class Sol87 {
	public int solution(int n) {
		int answer = 0;
		return dfs(n, 0, new int[n]);
	}

	private int dfs(int n, int row, int[] board)
	{
		if (row == n)
			return 1;
		int cnt = 0;
		for (int col=0; col<n; col++)
		{
			if (isValid(board, row, col))
			{
				board[row] = col;
				cnt += dfs(n, row+1, board);
			}
		}
		return cnt;
	}

	private boolean isValid(int[] board, int row, int col) {
		for (int i=0; i<row; i++)
		{
			if(board[i] == col || Math.abs(board[i] - col) == row - i)
				return false;
		}
		return true;
	}
}
