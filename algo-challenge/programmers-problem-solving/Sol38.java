package study;

class Sol38 {

	private String toBase(int num, int k)
	{
		if (num == 0) return "0";

		StringBuilder str = new StringBuilder();
		String digits = "0123456789ABCDEF";

		while (num > 0)
		{
			str.append(digits.charAt(num % k));
			num /= k;
		}
		return str.reverse().toString();
	}



	private String toBaseString(int base, int total)
	{
		StringBuilder str = new StringBuilder("0");

		for (int i=1; i <= total; i++)
		{
			str.append(toBase(i, base));
		}
		return str.toString();
	}

	private String ansToTube(String res, int total, int turn, int size)
	{
		StringBuilder ans = new StringBuilder();

		for (int i=0; i<res.length(); i++)
		{
			if (i % total == (turn-1))
			{
				ans.append(res.charAt(i));
				if (ans.length() == size) return ans.toString();
			}

		}
		return ans.toString();
	}

	public String solution(int n, int t, int m, int p) {
		String str = toBaseString(n, t*m);
		String ans = ansToTube(str, m, p, t);

		return ans;
	}
}
