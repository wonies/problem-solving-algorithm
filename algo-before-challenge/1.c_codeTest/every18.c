//백준 2468 s1 문제 | 안전가옥

#include <stdio.h>

int n;
int arr[101][101];
int cpy[101][101];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int ans = -1;
int cnt;
void dfs(int x, int y)
{
    cpy[x][y] = 0;
    for (int i=0; i<4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >=0 && nx < n && ny < n && cpy[nx][ny] != 0)
            dfs(nx, ny);

    }
}

void makecpy(int k)
{
    for (int i=0; i<n; i++)
    {
        for (int j=0; j<n; j++)
        {
            cpy[i][j] = arr[i][j];
            if (cpy[i][j] <= k)
                cpy[i][j] = 0;
        }
    }
}

void safety(int safe)
{
    for(int k=0; k<safe; k++)
    {
        makecpy(k);
        int cnt = 0;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (cpy[i][j] != 0)
                {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        if (cnt > ans)
            ans = cnt;
    }
}

int main()
{
    scanf("%d", &n);
    int arrmax = -1;

    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            scanf("%d", &arr[i][j]);
            if (arr[i][j] > arrmax)
                arrmax = arr[i][j];
        }
    }   
    safety(arrmax);
    printf("%d\n", ans);
}