// 백준 s3 문제 2579 | 계단오르기

#include <stdio.h>

#define max(a, b) a > b ? a : b;

int main()
{
	int i, n;
	int arr[301] ={0, };
	int dp[301] = {0, };
	scanf("%d", &n);
	i = 1;
    for (int i=1; i<=n; i++)
        scanf("%d", &arr[i]);
	dp[1] = arr[1];
	dp[2] = arr[1] + arr[2];
	i = 3;
	while (i <= n)
	{
		dp[i] = max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
		i++;
	}
	printf("%d", dp[n]);
}