// 프로그래머스 | 햄버거 만들기

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int ingredient[], size_t ingredient_len) {

    int ans = 0;
    int stack[ingredient_len+1];
    int idx = 0;
    
    for(int i=0; i<ingredient_len; i++)
    {
        stack[idx++] = ingredient[i];
        if (idx >= 4)
        {
            if ((stack[idx-1] == 1) && (stack[idx-2] == 3) && (stack[idx-3] == 2) && (stack[idx-4] == 1))
            {
                ans++;
                idx -= 4;
            }
        }
    }
    
    return ans;
}