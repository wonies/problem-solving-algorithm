// 테이블 해시 함수
import java.io.*;
import java.util.*;


class Sol79 {
	public int solution(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;

		List<int[]> list = new ArrayList<>(Arrays.asList(data));

		list.sort((a, b) -> {
			if (a[col - 1] == b[col - 1])
				return b[0] - a[0];
			return a[col - 1] - b[col - 1];
		});

		// for (int[] row : list)
		//     System.out.println(Arrays.toString(row));

		for (int i=row_begin-1; i<row_end; i++)
		{
			int [] row = list.get(i);
			int s_i = 0;
			for (int val : row)
				s_i += val % (i + 1);
			answer ^= s_i;
		}
		return answer;
	}
}
