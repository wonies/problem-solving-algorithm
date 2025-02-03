package basic;

public class basic_2 {

	public static void sum_num(int n, int m)
	{
		int sum = 0;
		for (int i = n; i <= m; i++)
		{
			sum += i;
			if (i < m)
				System.out.print(i + " +");
			else
				System.out.print(i + " = " + sum);
		}
	}

	public static void main(String[] args) {
		sum_num(3, 7);
	}
}
