#include <stdio.h>

int n;
int arr[101][101];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int find[101];
int cpyarr[101][101];

void dfs(int x, int y, int find)
{
    arr[x][y] -= 1;
    for (int i=0; i<4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 & ny >=0 && nx < n && ny < n && arr[nx][ny] > find)
            dfs(nx, ny, find);

    }

}


int main()
{
    scanf("%d", &n);
    int arr_max = -1;
    for (int i=0; i<n; i++)
    {
        for (int j=0; j<n; j++)
        {
            scanf("%d", &arr[i][j]);
            find[arr[i][j]]++;
            // cpyarr[i][j] = arr[i][j];
            if (find[arr[i][j]] > arr_max)
                arr_max = find[arr[i][j]];
        }
    }

    int cnt = 0;
    int maxi = -2147000;
    for (int k=arr_max; k>0; k--)
    {
        if (find[k] >= 0)
        {
            for(int i=0; i<n; i++)
            {
                for (int j=0; j<n; j++)
                {
                    if (arr[i][j] > find[k])
                    {
                        dfs(i, j, find[k]);
                        cnt ++;
                    }
                }
            }
            if (cnt > maxi)
                maxi = cnt;
        }
    }
    printf("%d\n",maxi);
    
}