package study;

class Sol35 {
	public int solution(String word) {
		int sum = 0;
		int ans = 0;
		String alphas = "AEIOU";

		int[] weights = new int[5];
		for (int i=0; i<5; i++)
		{
			sum = sum * 5 + 1;
			weights[i] = sum;
		}

		for (int i=0; i<word.length(); i++)
		{
			char c = word.charAt(i);
			int idx = alphas.indexOf(c);
			ans += idx * weights[4-i];
		}
		ans += word.length();
		return ans;
	}
}
