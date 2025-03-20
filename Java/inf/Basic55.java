package inf;


public class Basic55 {

	private static void dfs(int n)
	{
		if (n == 0)
			return ;
		dfs(n/2);
		System.out.print(n % 2);
	}


  	public static void main(String[] args) {
		dfs(11);
	}
}
