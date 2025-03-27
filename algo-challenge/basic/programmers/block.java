package programmers;//프로그래머스 숫자블록

class block {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin + 1)];
        
        for (int i = 0; i < answer.length; i++)
        {
            long num = begin + i;
            answer[i] = findDivisor(num);
        }
        return answer;
    }
    
    private int findDivisor(long num)
    {
        if (num == 1) return 0;
        int divi = 1;
        for (int i=2; i<= Math.sqrt(num); i++)
        {
            if (num % i == 0)
            {
                if(num / i <= 10000000) {
                    return (int)(num / i);
                }

                if (i <= 10000000) {
                    divi = i;
                }
            }
        }
        return divi;
    }
}