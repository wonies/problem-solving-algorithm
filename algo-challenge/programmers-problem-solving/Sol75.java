import java.io.*;
import java.util.*;

class Sol75 {

	public int[] solution(int n, long k) {
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<n; i++)
			list.add(i + 1);
		int[] ans = new int[n];
		k--;

		long fact = 1;
		for (int i=2; i<n; i++)
			fact *= i;

		for (int i=0; i<n; i++)
		{
			int idx = (int)(k / fact);
			ans[i] = list.get(idx);
			list.remove(idx);

			if (i < n - 1) {
				k %= fact;
				fact /= (n - 1 -i);
			}
		}
		return ans;
	}
}
