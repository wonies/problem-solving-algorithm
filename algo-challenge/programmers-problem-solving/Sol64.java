package study;

//무방향그래프공부
//전력망을 둘로 나누기

import java.util.*;

public class Sol64 {
	static boolean[] visited;

	public static int bfs(int start, List<List<Integer>> graph)
	{
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		int cnt = 1;
		while (!queue.isEmpty())
		{
			int now = queue.poll();
			for (int next : graph.get(now)){
				if (!visited[next])
				{
					visited[next] = true;
					queue.offer(next);
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static int solution(int n, int[][] wires)
	{
		int ans = -1;
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<=n; i++)
			graph.add(new ArrayList<>());
		for (int [] wire : wires)
		{
			int a = wire[0];
			int b = wire[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		int min = Integer.MAX_VALUE;
		for (int i=0; i<wires.length; i++)
		{
			int a = wires[i][0];
			int b = wires[i][1];
			graph.get(a).remove(Integer.valueOf(b));
			graph.get(b).remove(Integer.valueOf(a));
			visited = new boolean[n + 1];
			int temp = bfs(a, graph);

			int other = n - temp;
			min = Math.min(min, Math.abs(temp - other));

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
