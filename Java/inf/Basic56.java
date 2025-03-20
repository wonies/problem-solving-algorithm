package inf;


public class Basic56 {
	static int cnt;
	private static int dfs(int n)
	{
		if (n==1)
			return 1;
		return n * dfs(n-1);
	}


	public static void main(String[] args) {
		cnt = 0;
		// dfs(5);
		System.out.println(dfs(5));
	}
}
