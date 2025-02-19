package study;

//time-overflow
//fail

class Sol9_wrong
{
	public int solution(String s)
	{
		int answer = -1;
		StringBuilder sb = new StringBuilder(s);
		boolean changed = true;

		while (changed)
		{
			changed = false;
			for (int i=0; i< sb.length()-1; i++)
			{
				if ((sb.charAt(i) == sb.charAt(i+1)))
				{
					sb.delete(i, i+2);
					changed = true;
					break ;
				}
			}
		}
		return (sb.length() == 0) ? 1 : 0;
	}
}
