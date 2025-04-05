//  순열 구하는 로직

import java.io.*;
import java.nio.IntBuffer;
import java.util.*;


public class Permutation {
	static List<List<Integer>> result = new ArrayList<>();
	static boolean[] visited;
	static int[] nums = {1, 2, 3};

	public static void main(String[] args) {
		visited = new boolean[nums.length];
		List<Integer> temp = new ArrayList<>();
		dfs(temp);
		for (List<Integer> perm : result)
			System.out.println(perm);
	}
	public static void dfs(List<Integer> cur){
		if (cur.size() == nums.length){
			System.out.println("    ✅ 저장: " + cur);
			result.add(new ArrayList<>(cur));
			return ;
		}
		for  (int i=0; i<nums.length; i++)
		{
			if (!visited[i])
			{
				visited[i] = true;
				cur.add(nums[i]);
				System.out.println("[DFS] add " + nums[i] + " → cur = " + cur);
				dfs(cur);
				int removed = cur.remove(cur.size() - 1);
				System.out.println("[BACK] remove " + removed + " → cur = " + cur);
				visited[i] = false;
			}
		}
	}
}
