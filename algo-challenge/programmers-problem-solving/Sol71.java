import java.io.*;
import java.util.*;
// 71번째, 메뉴리뉴얼 문제

class Sol {
	public static void combi(String order, int target, int start, int depth, StringBuilder sb, Map<String, Integer> res)
	{
		if (depth == target)
		{
			char[] arr = sb.toString().toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);
			res.put(key, res.getOrDefault(key, 0) + 1);
			return ;
		}
		for (int i=start; i<order.length(); i++)
		{
			sb.append(order.charAt(i));
			combi(order, target, i+1, depth+1, sb, res);
			sb.deleteCharAt(sb.length()-1);
		}
	}


	public static String[] solution(String[] orders, int[] course) {
		List<String> ans = new ArrayList<>();

		for (int x : course) {
			Map<String, Integer> res = new HashMap<>();
			for (String order : orders)
			{
				char[] arr = order.toCharArray();
				Arrays.sort(arr);
				order = new String(arr);
				combi(order, x, 0, 0, new StringBuilder(), res);
			}
			// System.out.println(res);
			int max = res.values().stream().max(Integer::compare).orElse(0);
			for (Map.Entry<String, Integer> entry : res.entrySet())
			{
				if (entry.getValue() == max && max > 1)
					ans.add(entry.getKey());
			}
		}
		Collections.sort(ans);
		return ans.toArray(new String[0]);
	}

	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int [] courses = {2, 3, 4};

		String[] res = solution(orders, courses);
		System.out.println(Arrays.toString(res));
	}
}
