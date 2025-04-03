//서버증설횟수. sol68

class Sol68 {
	public int solution(int[] players, int m, int k) {
		int cnt = 0;
		int len = players.length;
		int[] server = new int[len + k];

		for (int i=0; i<len; i++)
		{
			int need = players[i] / m;
			if ( server[i] >= need )
			{
				continue ;
			}
			else
			{
				int realNeed = need - server[i];
				for (int j=i; j<i+k; j++)
				{
					server[j] += realNeed;
				}
				cnt += realNeed;
			}
		}
		return cnt;
	}
}
