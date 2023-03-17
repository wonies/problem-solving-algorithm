// 프로그래머스 | 대충 만든 자판

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(const char* keymap[], size_t keymap_len, const char* targets[], size_t targets_len) {
    int* ans = (int*)calloc(targets_len, sizeof(int));
    int  cnt;
    int idx = 0;
    int total;
    for (int i=0; i<targets_len; i++)
    {
        total = 0;
        int len = strlen(targets[i]);
        int flag;
        for (int j=0; j<len; j++)
        {
            cnt = 101;
            flag = 0;
            for (int k=0; k<keymap_len; k++)
            {
                int k_len = strlen(keymap[k]);
                for (int z = 0; z < k_len ; z++)
                {
                    if (targets[i][j] == keymap[k][z])
                    {
                        if (cnt > z)
                            cnt = z + 1;
                        flag = 1;
                        break ;
                    }
                }
              if (cnt == 1)
                    break; 
            }
            if (flag == 1)
                total += cnt;
            else
            {
                total = -1;
                break ; 
            }
        }
      ans[idx++] = total;
    }
        
    return ans;
}