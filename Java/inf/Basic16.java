package inf;
// time limit
import java.util.*;
import java.io.*;

public class Basic16 {

	public static int fibonacci(int n)
	{
		if (n <= 1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++)
			if (i == n)
				System.out.print(fibonacci(i));
			else
				System.out.print(fibonacci(i) + " ");
	}
}
