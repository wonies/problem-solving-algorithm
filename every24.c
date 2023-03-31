// 백준 s5 13301 | 타일 장식물

#include <stdio.h>

long long dp[82];
int n;

int main()
{
    scanf("%d", &n);
    long long ans= 0;
   
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 2;
    dp[4] = 3;
    for(int i=5; i<= n+1; i++)
        dp[i] = dp[i-2] + dp[i-1];
    ans = (dp[n] + dp[n+1]) * 2;
    printf("%lld\n", ans);
}