//양궁대회
import java.util.*;

class Sol92 {
	int maxDiff = 0;
	int[] ans = {-1};

	public int[] solution(int n, int[] info) {
		dfs(0, n, new int[11], info);
		return ans;
	}

	void dfs(int idx, int remain, int[] ryan, int[] apeach) {
		if (idx == 11) {
			if (remain > 0) ryan[10] += remain;
			int rScore = 0, aScore = 0;
			for (int i=0; i<=10; i++) {
				if (ryan[i] == 0 && apeach[i] == 0) continue ;
				if (ryan[i] > apeach[i]) rScore += (10 - i);
				else aScore += (10 - i);
			}

			int diff = rScore - aScore;
			if (diff > 0) {
				if (diff > maxDiff || (diff == maxDiff && isBetter(ryan, ans))) {
					maxDiff = diff;
					ans = Arrays.copyOf(ryan, 11);
				}
			}

			if (remain > 0) ryan[10] -= remain;
			return ;

		}
		int need = apeach[idx] + 1;
		if (remain >= need) {
			ryan[idx] = need;
			dfs(idx + 1, remain - need, ryan, apeach);
			ryan[idx] = 0;
		}
		dfs(idx + 1, remain, ryan, apeach);
	}


	boolean isBetter(int[] r1, int[] r2) {
		for (int i=10; i>=0; i--) {
			if (r1[i] > r2[i]) return true;
			else if (r1[i] < r2[i]) return false;
		}
		return false;
	}

}
