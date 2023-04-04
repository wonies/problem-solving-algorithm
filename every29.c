#include <stdio.h>

int dp[41];
int seat[41];

int main()
{
    int n;
    int m;
    scanf("%d", &n);
    scanf("%d", &m);
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for(int i=1; i<=m; i++)
        scanf("%d", &seat[i]);
    for (int j=3; j<=n; j++)
      dp[j] = dp[j-1] + dp[j-2];

    int cnt = 1;
    for(int k=1; k<=m; k++)
        cnt *= dp[seat[k]- seat[k-1] - 1];
    cnt *= dp[n - seat[m]];
    printf("%d\n", cnt);
    return 0;
}