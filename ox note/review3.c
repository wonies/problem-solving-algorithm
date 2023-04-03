#include <stdio.h>

int color[10001];
int graph[10001][10001];
int flag = 0;
int n, m;

void dfs(int v, int c)
{
    color[v] = c;
    for (int i=0; i<n; i++)
    {
        if (graph[v][i] == 1)
        {
            if (color[i] == -1)
                dfs(i, 1-c);
            else if (color[i] == c)
            {
                flag = 1;
                break ;
            }
        }            
    }
}

int main()
{
    scanf("%d %d", &n, &m);

    for (int i=0; i<m; i++)
    {
        int a, b;
        scanf("%d %d", &a, &b);
        graph[a][b] = 1;
        graph[b][a] = 1;
    }
    for (int i=0; i<n; i++)
        color[i] = -1;
    for (int i=0; i<n; i++)
    {
        if (color[i] == -1)
            dfs(i, 0);
        if (flag == 0)
            break ;     
    }
    
    if (flag == 1)
        printf("NO\n");
    else
        printf("YES\n");
}


/*
9 10

0 1

0 2

0 3

1 5

2 5

3 4

5 6

5 8

6 7

7 8
*/