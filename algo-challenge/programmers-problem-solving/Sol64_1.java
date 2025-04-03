import java.io.*;
import java.util.*;

//dfs버전

public class Sol64_1 {

	public static int dfs(int node, List<List<Integer>> graph, boolean[] visited)
	{
		visited[node] = true;
		int cnt = 1;
		for (int next: graph.get(node))
		{
			if (!visited[next])
				cnt += dfs(next, graph, visited);
		}
		return cnt;
	}



	public static int solution(int n, int [][] wires)
	{
		int cnt = 0;
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<=n; i++)
			graph.add(new ArrayList<>());

		for (int [] wire: wires)
		{
			int a = wire[0];
			int b = wire[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		int min = Integer.MAX_VALUE;

		for (int [] wire: wires)
		{
			int a = wire[0];
			int b = wire[1];

			graph.get(a).remove(Integer.valueOf(b));
			graph.get(b).remove(Integer.valueOf(a));

			boolean []visited = new boolean[n + 1];
			int temp = dfs(a, graph, visited);
			int temp_other = n - temp;
			int diff = Math.abs(temp - temp_other);
			min = Math.min(min, diff);
			graph.get(a).add(b);
			graph.get(a).add(b);
			graph.get(b).add(a);

		}
		return min;
	}


	public static void main(String[] args) {
		int[][] arr = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		System.out.println(solution(9, arr));
	}
}
