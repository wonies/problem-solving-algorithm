package study;

import java.io.*;
import java.util.*;

class Sol24 {
	public int solution(int[] citations) {
		Arrays.sort(citations);

		int n = citations.length;
		int hIndex = 0;

		for (int i = n - 1; i >= 0; i--) {
			int cur = citations[i];
			int paperCount = n - i;

			hIndex = Math.max(hIndex, Math.min(cur, paperCount));
		}

		return hIndex;

	}
}
