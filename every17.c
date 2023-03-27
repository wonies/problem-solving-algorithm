//백준 s3 문제 1393 | 전쟁 - 전투

#include <stdio.h>
#include <math.h>

int n, m;
// int white;
// int blue;
int white_arr[100001];
int blue_arr[100001];
char war[101][101];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int g_white;
int g_blue;
int res = 0; 


void dfs(int x, int y, int white, int blue, int c)
{
    if (war[x][y] == 'W')
    {
        white++;
        war[x][y] = 'X';
        g_white = white;
    }
    else if (war[x][y] == 'B')
    {
        blue++;
        war[x][y] = 'X';
        g_blue = blue;
    }
    for (int i=0; i<4 ; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < n && ny < m && (war[nx][ny] == 'W' || war[nx][ny] == 'B'))
            dfs(nx, ny,g_white, g_blue, c);
    }
}


int main(void)
{
    scanf("%d %d ", &n, &m);
    char ch;
    int white = 0;
    int blue = 0;
    for(int i=0; i<n; i++)
    {
        for (int j=0; j<m; j++)
            scanf("%c", &war[i][j]);
    }
    int idx = 0;
    for (int i=0; i<n; i++)
    {
        for (int j=0; j<m; j++)
        {
            if (war[i][j] == 'W' || war[i][j] == 'B')
            {
                dfs(i, j, 0, 0, war[i][j]);
                white_arr[idx] =  g_white;
                blue_arr[idx] = g_blue;
                printf("white arr : %d\n", g_white);
                printf("blue arr : %d\n", g_blue);
                g_white = 0;
                g_blue = 0;
                idx++;
            }
        }
    }
    printf("idx : %d\n", idx);
    for (int i=0; i<idx; i++)
    {
        white += pow(white_arr[i],2);
        blue += pow(blue_arr[i], 2); 
    }
    printf("%d %d\n", white , blue );
}
