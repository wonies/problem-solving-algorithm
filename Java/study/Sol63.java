package study;

// 시소짝꿍 => 답은 맞지만 시간초과 에러
// n제곱이기 때문인 듯

class Sol63 {
	public long solution(int[] weights) {
		long cnt = 0;

		int [][] ratio = {
			{1, 1},
			{2, 1},
			{3, 2},
			{4, 3},
			{3, 4},
			{2, 3},
			{1, 2}
		};


		for (int i = 0; i < weights.length - 1; i++)
		{
			for (int j = i + 1; j < weights.length; j++)
			{
				for (int[] r : ratio)
				{
					int itemp = weights[i] * r[1];
					int rtemp = weights[j] * r[0];
					if (itemp == rtemp)
					{
						cnt++;
						break ;
					}
				}
			}
		}


		return cnt;
	}
}
