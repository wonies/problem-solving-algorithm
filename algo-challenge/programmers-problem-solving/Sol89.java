//요격시스템
import java.util.*;
import java.io.*;

class Solution {
	public int solution(int[][] targets) {
		int answer = 0;

		Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
		int intercept = targets[0][1];
		answer += 1;

		for (int i = 1; i < targets.length; i++)
		{
			if (targets[i][0] >= intercept)
			{
				answer+=1;
				intercept = targets[i][1];
			}
		}
		return answer;
	}
}
