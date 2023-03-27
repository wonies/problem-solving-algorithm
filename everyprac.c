#include <stdio.h>

int n, m;
int arr[10001][10001];
int color[10001];
int flag = 1;

void    dfs(int v, int c)
{
    color[v] = c;
    for (int i=0; i<n; i++)
    {
        if (arr[v][i] == 1)
        {
            if (color[i] == -1)
                dfs(i, 1-c);
            else if (color[i] == c)
            {
                flag = 0;
                return ;
            }
        }
    }
}

int main(void)
{
    int a, b;
    scanf("%d %d", &n, &m);
    for (int i=0; i<m; i++)
    {
        scanf("%d %d", &a, &b);
        arr[a][b] = 1;
        arr[b][a] = 1;
    }
    for (int i=0; i<n; i++)
        color[i] = -1;
    for (int i=0; i< n; i++)
    {
        if (color[i] == -1)
            dfs(i, 0);
        if (flag == 0)
            break ;
    }
    if (flag == 1)
        printf("{Y}\n");
    else
        printf("{N}");
}