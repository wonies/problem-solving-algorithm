//백준 s2 문제 1937 | 욕심쟁이판다

#include <stdio.h>

int bamboo[501][501];
int dp[501][501];
int n;
int res;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
#define max(a, b) a > b ? a : b

int dfs(int x, int y, int cnt)
{
    if (dp[x][y] != -1)
        return dp[x][y];
    dp[x][y] = 1;
    for (int i=0; i<4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
            continue;
        if (bamboo[nx][ny] > cnt)
            dp[x][y] = max(dfs(nx, ny, bamboo[nx][ny]) + 1, dfs(x, y, bamboo[x] [y]));
    }
    return dp[x][y];
}

int main()
{
    scanf("%d", &n);
    for (int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            scanf("%d", &bamboo[i][j]);
            dp[i][j] = -1;
        }    
    }
    int path = -2147000;
    for (int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            if (bamboo[i][j] > dp[i][j])
                res = dfs(i, j, bamboo[i][j]);
            if (path < res)
                path = res;
        }
    }    
    printf("%d\n", path);
}