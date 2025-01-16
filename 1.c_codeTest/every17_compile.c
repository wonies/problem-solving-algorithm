//백준 s3 문제 1393 | 전쟁 - 전투

#include <stdio.h>
#include <math.h>

int n =6, m=3;
char war[101][101];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int res =1;
int oo;
int dfs(int x, int y, int c)
{
    war[x][y] = 'X';
    // int res = 1;
    for (int i=0; i<4 ; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < m && ny < n && war[nx][ny] == c)
        {
           //res += dfs(nx, ny, c);
        
            res++;
           dfs(nx, ny, c);
          
        }
    }   
    return res;
}


int main(void)
{
    // scanf("%d %d", &n, &m);
  
    char ch;
    int white = 0;
    int blue = 0;
  

    war[0][0] = 'W';
    war[0][1] = 'B';
    war[0][2] = 'W';
    war[0][3] = 'W';
    war[0][4] = 'W';
    war[0][5] = 'W';
    war[1][0] = 'B';
    war[1][1] = 'B';
    war[1][2] = 'B';
    war[1][3] = 'B';
    war[1][4] = 'B';
    war[1][5] = 'B';
    war[2][0] = 'W';
    war[2][1] = 'W';
    war[2][2] = 'B';
    war[2][3] = 'B';
    war[2][4] = 'B';
    war[2][5] = 'B';
    
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
