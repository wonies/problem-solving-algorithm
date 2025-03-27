//2색칠하기(dfs) | 알고리즘잡스 문제 

#include <stdio.h>

int color[10001];
int graph[10001][10001];
int n, m;
int flag = 1;

void dfs(int v, int c)
{
    color[v] = c;
    for (int i = 0; i < n; i++)
    {
        if (graph[v][i] == 1)
        {
            if (color[i] == -1)
                dfs(i, 1 - c);
            else if (color[i] == c)
            {
                flag = 0;
                return ;
            }
        }
    }
}

int main()
{
    scanf("%d %d", &n, &m);
    for (int i = 0; i < m; i++)
    {
        int a, b;
        scanf("%d %d", &a, &b);
        graph[b][a] = 1; 
        graph[a][b] = 1;
    }
    for (int i = 0; i < n; i++)
        color[i] = -1; 
    for (int i = 0; i < n; i++)
    {
        if (color[i] == -1)
            dfs(i, 0);
        if (flag == 0)
            break ;
    }
    if (flag == 1)
        printf("YES\n");
    else
        printf("NO\n");
    return 0;
}
