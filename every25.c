//백준 14606 | 피자

#include <stdio.h>

int dp[11];

int main()
{
    int n;
    scanf("%d", &n);
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 3;
    for(int i=4; i<n; i++)
        dp[i] = (i - 1) + dp[i-1];
    printf(dp[n]);
}