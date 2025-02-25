package study;

//time-limit

class Sol21_01 {
	public int[] solution(int n, long left, long right) {
		int[][] matrix = new int[n][n];
		int len = (int)right - (int)left + 1;
		int[] arr = new int [n * n];
		int[] ans = new int[len];

		int k = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				matrix[i][j] = Math.max(i, j) + 1;
				arr[k++] = matrix[i][j];
			}
		}

		k = 0;
		for (int i=(int)left; i<=(int)right; i++)
		{
			ans[k++] = arr[i];
		}

		return ans;
	}
}
