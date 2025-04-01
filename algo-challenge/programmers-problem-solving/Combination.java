import java.util.*;

class Combination {

	public void combination(String order, int start, int depth, int target, StringBuilder sb, List<String> res)
	{
		if (depth == target)
		{
			res.add(sb.toString());
			return ;
		}
		for (int i=start; i<order.length(); i++)
		{
			sb.append(order.charAt(i));
			combination(order, i+1, depth+1, target, sb, res);
			sb.deleteCharAt(sb.length() -1);
		}
	}


	public List<String> getCombi(String order, int target)
	{
		List<String> res = new ArrayList<>();
		char[] arr =order.toCharArray();
		Arrays.sort(arr);
		order = new String(arr);
		combination(order, 0, 0, target, new StringBuilder(), res);
		return res;
	}



	public static void main(String[] args) {
		Combination finder = new Combination();
		String order = "ABC";
		int target = 2;
		List<String> combi = finder.getCombi(order, target);
		System.out.println("combination : " + combi);
	}
}
