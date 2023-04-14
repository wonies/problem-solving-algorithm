// 백준 2294 || 동전 2

#include <stdio.h>
#define min(a, b) a < b ? a : b

int dp[10001];
int val[101];

int main()
{
    int n, k;
    scanf("%d %d", &n, &k);
    for (int i=1; i<=10001; i++)
        dp[i] = 10001;
    
    for (int i=1; i<=n; i++)
    {
        scanf("%d", &val[i]);
        // dp[i] = val[i];
    }
    
    for (int i=1; i<=n; i++)
    {
        for (int j=val[i]; j<=k; j++)
        {
            //if (j - val[i] >= 0)
                dp[j] = min(dp[j], dp[j - val[i]] + 1);
        }
    }
    if (dp[k] == 10001)
        printf("-1\n");
    else
        printf("%d\n", dp[k]);
}