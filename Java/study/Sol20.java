package study;
// 할인행사
import java.util.*;
class Sol20 {
	public int solution(String[] want, int[] number, String[] discount) {
		int limit_day = discount.length - 10 + 1;
		int ten = 10;
		int cnt = 0;

		for (int i = 0; i < limit_day ; i++)
		{
			int [] nums = number.clone();
			for (int j = i; j < i + ten; j++)
			{
				String product = discount[j];
				for (int k=0; k<want.length; k++)
				{
					if (product.equals(want[k]))
						nums[k]--;
				}
			}
			boolean allZero = Arrays.stream(nums).allMatch(num -> num == 0);
			if (allZero)
				cnt++;

		}
		return cnt;
	}
}
