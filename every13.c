//백준 s4 문제 1643 | 1로 만들기

#include <stdio.h>

int dp[1000001];

int main()
{
    int N;
    scanf("%d", &N);
    int i;
    dp[1] = 0;
    for(i=2; i<=N; i++)
    {
        // if (!(i % 2 == 0) || !(i % 3 == 0))
        dp[i] = dp[i-1] + 1;
        if (i % 2 == 0)
        {
            if (dp[i] > dp[i / 2] + 1)
                dp[i] = dp[i / 2] + 1;
        }
        if (i % 3 == 0)
        {
            if (dp[i] > dp[i / 3] + 1)
                dp[i] = dp[i / 3] + 1;
        }
    }
    printf("%d\n", dp[N]);
}