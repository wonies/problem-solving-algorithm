package inf;

//매출액의 종류
import java.io.*;
import java.util.*;

public class Basic34_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[n];

		for (int i=0; i<n; i++)
			numbers[i] = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new HashMap<>();
		int[] res = new int[n-m+1];

		for (int i=0; i<m; i++)
			map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);

		res[0] = map.size();

		int idx = 0;

		for (int i=1; i<n-m+1; i++)
		{
			int left = numbers[i - 1];
			map.put(left, map.get(left) - 1);
			if (map.get(left) == 0)
				map.remove(left);
			int right = numbers[i + m - 1];
			map.put(right, map.getOrDefault(right, 0) + 1);
			res[i] = map.size();
		}

		for (int i=0; i<n-m+1; i++)
			System.out.print(res[i] + " ");
	}
}
