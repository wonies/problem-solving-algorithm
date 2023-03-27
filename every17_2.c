//백준 s3 문제 1393 | 전쟁 - 전투

#include <stdio.h>

int n, m;
int white_arr[100001];
int blue_arr[100001];
char war[101][101];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int res = 1; 


int dfs(int x, int y, int c)
{
    war[x][y] = 'X';
    for (int i=0; i<4 ; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < m && ny < n && war[nx][ny] == c)
        {
           res++;
           dfs(nx, ny, c);
        }
    }   
    return res;
}


int main(void)
{
    scanf("%d %d", &n, &m);
    int white = 0;
    int blue = 0;
    for(int i=0; i<m; i++)
    {
        for (int j=0; j<n; j++)
            scanf(" %c", &war[i][j]);
    }
    int white_ans =0;
    int blue_ans = 0;

    for (int i=0; i<m; i++)
    {
        for (int j=0; j<n; j++)
        {
            if (war[i][j] == 'W')
            {
                white = dfs(i, j, 'W');
                white_ans += white * white;
            }
            else if (war[i][j] == 'B')
            {
                blue = dfs(i, j, 'B');
                blue_ans += blue * blue;
            }
              res = 1;
        }
      
    }
    
    printf("%d %d\n", white_ans , blue_ans );
}