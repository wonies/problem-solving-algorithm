// 프로그래머스 | 바탕 화면 정리

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int* solution(const char* wallpaper[], size_t wp_col) {
    int* ans = (int*)calloc(4, 4);
    int wp_row = 0;
    int x1 = 50, x2 = 0 , y1 = 50, y2 = 0;
    int temp1, temp2, temp3 = 2147954;
    int cnt = 0;
    wp_row = strlen(wallpaper[0]);

    for (int i=0; i<wp_col; i++)
    {
        for (int j=0; j<wp_row; j++)
        {
            if (wallpaper[i][j] == '#')
            {
                temp1 = i;
                temp2 = j;
                if (temp1 < x1)
                    x1 = temp1;
                if (temp1 > x2)
                    x2 = temp1;
                if (temp2 < y1)
                    y1 = temp2;
                if (temp2 > y2)
                    y2 = temp2;
            }
                
            ans[0] = x1;
            ans[1] = y1;
            ans[2] = x2 + 1;
            ans[3] = y2 + 1;
          
        }
    }
    
    return ans;
}