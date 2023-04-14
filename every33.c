//백준 2156 | 포도주 시식

#include <stdio.h>
#define max(a, b) ((a) < (b) ? (b) : (a))

int arr[10001];
int dp[10001];

int main(void)
{
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
        scanf("%d", &arr[i]);
    dp[1] = arr[1];
    dp[2] = arr[1] + arr[2];
    for (int i = 3; i <= n; i++)
    {
        dp[i] = max(dp[i - 2] + arr[i],  dp[i-3] + arr[i - 1] + arr[i]);
        dp[i] = max(dp[i-1], dp[i]);
    }
    printf("%d\n", dp[n]);
    return 0;
}