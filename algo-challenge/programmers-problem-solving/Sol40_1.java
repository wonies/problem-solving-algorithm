package study;
// 뒤에 있는 큰 수 찾기 -> 시간초과

class Sol40_1 {

	private int diff(int num1, int num2)
	{
		return num2 - num1;
	}


	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];

		for (int i=0; i<numbers.length-1; i++)
		{
			int max = 0;
			int temp = 0;
			for (int j=i+1; j<numbers.length; j++)
			{
				if (numbers[i] <= numbers[j])
				{
					int dif = diff(numbers[i], numbers[j]);
					if (max < dif)
					{
						max = dif;
						temp = numbers[j];
						break ;
					}
				}

			}
			if (temp == 0)
				answer[i] = -1;
			else
				answer[i] = temp;
		}

		answer[numbers.length-1] = -1;





		return answer;
	}
}
