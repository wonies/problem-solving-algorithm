//계단오르기
#include <stdio.h>

#define max(a, b) a > b ? a : b

int arr[301];
int dp[301];

int main()
{
    int n;
    scanf("%d", &n);

    for(int i=1; i<=n; i++)
        scanf("%d", &arr[i]);
    dp[1] = arr[1];
    dp[2] = arr[1] + arr[2];

    for(int i=3; i<=n; i++)
        dp[i] = max(arr[i] + arr[i-1] + dp[i-3], dp[i-2] + arr[i]);
    printf("%d\n", dp[n]);
}