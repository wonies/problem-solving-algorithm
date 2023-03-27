#include <stdio.h>

int n;
int arr[101][101];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int find[101];

int visited[101][101];

void dfs(int x, int y, int find)
{
    visited[x][y] = 1;
    arr[x][y]--;
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] >= find && visited[nx][ny] != 1)
            dfs(nx, ny, find);
    }
}

int main()
{
    scanf("%d", &n);
    int arr_max = -1;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &arr[i][j]);
            if (arr[i][j] > arr_max)
                arr_max = arr[i][j];
        }
    }

    int maxi = -2147000;

    for (int k = arr_max; k >= 0; k--)
    {
        
        int cnt = 0;
        // int flag = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                visited[i][j] = 0;
                if (arr[i][j] >= k)
                {
                    dfs(i, j, k);
                    cnt++;
                    break ;
                }
            }
        }
        if (cnt > maxi)
            maxi = cnt;
    }
    printf("%d\n", maxi);
}
