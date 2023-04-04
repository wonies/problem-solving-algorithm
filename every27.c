// 백준 12865 | 평범한 배낭 

#include <stdio.h>
#define max(a, b) a < b ? b : a

int dp[101][100001];
int weight[101];
int value[101];

int main()
{
    int n,k,w,v;
    
    scanf("%d %d", &n, &k);
    for (int i=1; i<=n; i++)
    {
        scanf("%d %d", &weight[i], &value[i]);
    }
    for(int i=1; i<=n; i++)
    {
        for(int j=1; j<=k; j++)
        {
            if (j - weight[i] >= 0)
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
            else
                dp[i][j] = dp[i-1][j];
        }
    }
    printf("%d\n", dp[n][k]);
}