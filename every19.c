//백준 g5 문제 17265 | 나의 인생에는 수학과 함께

#include <stdio.h>

char arr[6][6]; 
int n;
int dx[] = {1, 0};
int dy[] = {0, 1};
int flag = 0;
int min_val = 2147483647;
int max_val = -2147483647;

void dfs(int x, int y, int value)
{
    if (arr[x][y] >= '0' && arr[x][y] <= '9' && (flag != 0))
    {
        if (flag == 1)
            value += (arr[x][y] - '0');
        else if (flag == 2)
            value *= (arr[x][y] - '0');
        else if (flag == 3)
            value -= (arr[x][y] - '0');
        flag = 0;
    }
    for(int i=0; i<2; i++)
    {
        int nx = dx[i] + x;
        int ny = dy[i] + y;
        if (nx < 0 || nx > n || ny < 0 || ny > n)
            continue;
        if ((nx == n) && (ny == n))
        {
            if (value < min_val)
                min_val = value;
            if (value > max_val)
                max_val = value;
            return;
        }

        if (arr[x][y] == '+')
        {
            flag = 1;
            dfs(nx, ny, value);
        }
        else if (arr[x][y] == '*')
        {
            flag = 2;
            dfs(nx, ny, value);
        }
        else if (arr[x][y] == '-')
        {    
            flag = 3;
            dfs(nx, ny, value);
        } 
        else if (arr[x][y] >= '0' && arr[x][y] <= '9')
            dfs(nx, ny, value);
    }
}

int main()
{
    scanf("%d", &n);
    for (int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
            scanf(" %c", &arr[i][j]);
    }
    dfs(0, 0, arr[0][0] - '0');
    printf("%d %d\n", max_val, min_val);
    return 0;
}
