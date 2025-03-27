package programmers;//[PCCP 기출문제] 2번 / 퍼즐 게임 챌린지

import java.util.*;

class puzzle {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int res = 0;
        int len = diffs.length;
        long limits = limit;
        
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        System.out.println("right");
        
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (solve(mid, diffs, times, limit, len))
            {
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return left;
    }

    private boolean solve(int level,int[] diffs, int[] times, long limit, int len)
    {
        long totalTime = 0;
        
        for (int i = 0; i < len; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                int fails = diffs[i] - level;
                totalTime += (times[i] + (i > 0 ? times[i-1] : 0)) * fails + times[i];
            }
            
            if (totalTime > limit) {
                return false;
            }
        }
        
        return true;
    }
    
}
