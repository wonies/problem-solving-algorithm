package inf;

//크레인 인형뽑기
import java.io.*;
import java.util.*;

public class Basic40 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		int [] pos = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] != 0 && pos[j] == 0)
					pos[j] = i;
			}
		}
		// for(int i=0; i<n; i++)
		// 	System.out.println("pos : " + pos[i]);

		int m = Integer.parseInt(br.readLine());
		int [] arr = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int cnt = 0;
		for (int i=0; i<m; i++)
		{
			int col = arr[i] - 1;
			if (pos[col] >= n)
				continue ;
			// System.out.println("col " + col);
			int k = board[pos[col]][col];
			// System.out.println("current number : " + k);

			if (!stack.isEmpty())
			{
				if (stack.peek() == k)
				{
					stack.pop();
					// System.out.println("stack : " +  k);
					cnt+=2;
				}
				else
					stack.push(k);
			}
			else
			{
				// System.out.println("k : " + k);
				stack.push(k);
			}
			board[pos[col]][col] = 0;
			pos[col]++;

		}
		System.out.println(cnt);

		// for (int i=0; i<n; i++)
		// {
		// 	// StringTokenizer st = new StringTokenizer(br.readLine());
		// 	for (int j=0; j<n; j++)
		// 	{
		// 		System.out.print(arr[i][j]);
		// 	}
		// 	System.out.println();
		// }

	}
}
