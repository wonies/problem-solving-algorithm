class Sol77 {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] matrix = new int[rows][columns];

		int num = 0;
		int q = 0;
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<columns; j++)
			{
				matrix[i][j] = ++num;
			}
		}

		//          for (int i=0; i<rows; i++)
		//         {
		//             for (int j=0; j<columns; j++)
		//             {
		//                 System.out.print(matrix[i][j] + " ");
		//             }
		//              System.out.println("");
		//         }


		for (int[] query : queries)
		{
			int startX = query[0] - 1;
			int startY = query[1] - 1;
			int endX = query[2] - 1;
			int endY = query[3] - 1;
			int prev = matrix[startX][startY];
			int min = prev;

			for (int i=startY + 1; i <= endY; i++)
			{
				int cur = matrix[startX][i];
				matrix[startX][i] = prev;
				prev = cur;
				min = Math.min(min, prev);
			}

			for (int i=startX+1; i<=endX; i++)
			{
				int cur = matrix[i][endY];
				// System.out.println("cur " + cur);
				matrix[i][endY] = prev;
				// System.out.print("mat : " + matrix[i][endY]);
				prev = cur;
				min = Math.min(min, prev);
			}

			for (int i=endY-1; i>=startY; i--)
			{
				int cur = matrix[endX][i];
				matrix[endX][i] = prev;
				prev = cur;
				min = Math.min(min, prev);
			}
			for (int i=endX-1; i>=startX; i--)
			{
				int cur = matrix[i][startY];
				matrix[i][startY] = prev;
				prev = cur;
				min = Math.min(min, prev);
			}

			answer[q++] = min;

		}


		//          for (int i=0; i<rows; i++)
		//         {
		//             for (int j=0; j<columns; j++)
		//             {
		//                 System.out.print(matrix[i][j] + " ");
		//             }
		//              System.out.println("");
		//         }


		return answer;
	}
}
