//백준 s1 문제 2667 | 단지번호 붙이기 

#include <stdio.h>

int arr[25][25];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int ans[625];
int idx;
int cnt;

void dfs(int x, int y, int n)
{
    if (arr[x][y] == 1)
    {
        ans[idx]++;
        arr[x][y] = 0;
    }
    for (int i=0; i<4; i++)
    {
       int nx = x + dx[i];
       int ny = y + dy[i];
       if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 1)
            dfs(nx, ny, n);
    }
}

int main()
{
    int n;
    scanf("%d", &n);
    for (int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
            scanf("%1d", &arr[i][j]);
    }
    
    for (int i=0; i<n; i++)
    {
        for (int j=0; j<n; j++)
        {
            if (arr[i][j] == 1)
            {
                cnt++;
                dfs(i, j, n);
                idx++;
            }
        }    
    }
    printf("%d\n", cnt);
    for(int i=0; i < cnt; i++)
        for(int j=i+1; j < cnt; j++)
        {
            if(ans[i] > ans[j])
            {
                int temp = ans[i];
                ans[i] = ans[j];
                ans[j] = temp;
            }
        }
    for(int i=0; i < cnt; i++)
        printf("%d\n", ans[i]);
}
