// 백준 s5 14916 | 거스름돈

#include <stdio.h>
#define min(a, b)  a < b ? a : b 
int dp[100001];


int main()
{
    int n;
    scanf("%d", &n);
    dp[0] = 0;
    dp[1] = -1;
    dp[2] = 1;
    dp[3] = -1;
    dp[4] = 2;
    dp[5] = 1;
    for(int i=6; i<=n; i++)
    {
        // dp[i] = min(dp[i-5] + 1, dp[i-2] + 1);
        if (i % 5 == 0)
            dp[i] = dp[i-5] + 1;
        else if (i % 2 ==0)
            dp[i] = dp[i-2] + 1;
        else
        {
            dp[i] = min(dp[i-5]+1, dp[i-2]+1);
        }
        if (dp[i] == 0)
        {
            printf("-1\n");
            return 0;
        }
    }
    printf("%d\n", dp[n]);
}