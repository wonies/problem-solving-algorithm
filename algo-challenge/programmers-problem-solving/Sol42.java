package study;

//주식가격(통과코드)
class Sol42 {
	public int[] solution(int[] prices)
	{
		int []answer = new int[prices.length];

		for(int i = 0; i < prices.length - 1; ++i)
		{
			for(int j = i; j < prices.length - 1; ++j)
			{
				if(prices[i] <= prices[j])
					answer[i]++;
				else
					break;
			}
		}
		return answer;
	}
}
