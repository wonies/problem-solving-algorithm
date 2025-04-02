import java.io.*;
import java.util.*;

class Sol72 {
	public int solution(int N, int[][] road, int K) {
		int answer = 0;
		List<List<int[]>> graph = new ArrayList<>();

		for (int i=0; i<=N; i++)
			graph.add(new ArrayList<>());

		for (int [] r : road)
		{
			int a = r[0];
			int b = r[1];
			int weight = r[2];
			graph.get(a).add(new int[]{ b, weight });
			graph.get(b).add(new int[] { a, weight });
		}

		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[1] = 0;
		for (int i=1; i<=N; i++)
		{
			int minNode = -1;
			int minDist = Integer.MAX_VALUE;
			System.out.println("i : " + i);
			for (int j=1; j<=N; j++)
			{
				if (!visited[j] && dist[j] < minDist)
				{
					minDist = dist[j];
					minNode = j;
				}
			}
			if (minNode == -1) break;
			visited[minNode] = true;

			for (int[] edge: graph.get(minNode))
			{
				int neighbor = edge[0];
				int weight = edge[1];
				if (!visited[neighbor] && dist[neighbor] > dist[minNode] + weight)
				{
					dist[neighbor] = dist[minNode] + weight;
				}
			}
		}
		int ans = 0;
		for (int i=1; i<=N; i++)
			if (dist[i] <= K) ans++;

		return ans;
	}
}
