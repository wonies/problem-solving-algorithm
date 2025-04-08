class Sol77 {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] matrix = new int[rows][columns];

		int num = 0;
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<columns; j++)
			{
				matrix[i][j] = ++num;
			}
		}

		for (int[] query : queries)
		{
			int startX = query[0] - 1;
			int startY = query[1] - 1;
			int endX = query[2] - 1;
			int endY = query[3] - 1;
			int prev = matrix[startX][startY];
			int min = prev;


			for (int i=startX + 1; i < endX; i++)
			{
				int cur = matrix[i][startY];
				matrix[i][startY] = prev;
				prev = cur;
				min = Math.min(min, prev);
			}





		}



		return answer;
	}
}
