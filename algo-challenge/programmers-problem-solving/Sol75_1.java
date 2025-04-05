
import java.io.*;
import java.util.*;

//12, 13번 시간초과 (메모리초과) / 효율성테스트 실패
class Sol75_1 {
	static List<List<Integer>> permutation = new ArrayList<>();
	static boolean [] visited;

	private static void dfs(int n, List<Integer> arr)
	{
		if (n == arr.size())
		{
			permutation.add(new ArrayList<>(arr));
			return ;
		}
		for (int i=0; i<n; i++)
		{
			if (!visited[i])
			{
				visited[i] = true;
				arr.add(i + 1);
				dfs(n, arr);
				arr.remove(arr.size()-1);
				visited[i] = false;
			}
		}

	}


	public int[] solution(int n, long k) {
		int[] answer = new int[n];

		visited = new boolean[n];
		List<Integer> temp = new ArrayList<>();
		dfs(n, temp);
		List<Integer> kth = permutation.get((int)(k-1));
		for (int i=0; i<n; i++)
			answer[i] = kth.get(i);

		return answer;
	}
}
