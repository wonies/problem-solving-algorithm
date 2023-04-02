// 백준 b1 9655 | 돌게임

#include <stdio.h>
#define min(a, b) a < b ? a : b
int dp[1000];

int main()
{
    int n;
    scanf("%d", &n);

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    for(int i=3; i<=n; i++)
        dp[i] = min(dp[i-1] + 1, dp[i-3] + 1);
    if (dp[n] % 2 == 1)
        printf("SK\n");
    else
        printf("CY\n");
}