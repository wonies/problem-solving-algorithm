package inf;

public class Basic57 {
	static int[] fibo;

	private static int dfs(int n)
	{
		if (fibo[n] > 0)
			return fibo[n];
		if (n==1)
		{
			fibo[1] = 1;
			return 1;
		}
		if (n==2)
		{
			fibo[2] = 1;
			return 1;
		}
		return fibo[n] = dfs(n-1) + dfs(n-2);
	}


	public static void main(String[] args) {
		// dfs(5);
		fibo = new int[11];
		dfs(10);
		for (int i=1; i<= 10; i++)
			System.out.print(fibo[i] + " ");
	}
}

