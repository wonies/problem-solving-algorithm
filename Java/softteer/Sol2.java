package softteer;

import java.io.*;
import java.util.*;

public class Sol2 {
	static int cnt;
	static int n;
	static int m;
	static ArrayList<int[]> vec = new ArrayList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean [][] visited;
	static int [][] arr;

	public static void dfs(int row, int col, int idx)
	{
		if (row == vec.get(idx)[0] && col == vec.get(idx)[1])
		{
			if (idx == m - 1)
			{
				cnt++;
				return ;
			}
			else
			{
				idx++;
			}
		}
		visited[row][col] = true;
		for (int i=0; i<4; i++)
		{
			int r = row + dx[i];
			int c = col + dy[i];
			if (r<1 || r>n || c <1 ||  c>n)
				continue;
			if (!visited[r][c] && arr[r][c] == 0)
				dfs(r, c, idx);
		}
		visited[row][col] = false;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		visited = new boolean[n+1][n+1];

		for (int i=1; i<=n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int j=0; j<m; j++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			vec.add(new int[]{a, b});
		}
		dfs(vec.get(0)[0], vec.get(0)[1], 1);
		System.out.println(cnt);
	}
}


