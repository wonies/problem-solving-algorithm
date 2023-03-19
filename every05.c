//프로그래머스 | 둘만의 암호

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* solution(const char* s, const char* skip, int index) {
    
    int s_len = strlen(s);
    int skip_len = strlen(skip);
    char* ans = (char*)calloc(s_len + 1, 1);

    int idx = 0;
    for (int i = 0; i < s_len; i++)
    {
        int cnt = 0;
        int total = index;
        char c = s[i];
        int flag;
        while(total != 0)
        {
            c++;
            flag = 0;
            if (c > 'z')
                c = c - 'z' + 'a' - 1;
            for (int j = 0; j< skip_len; j++)
            {
                if (c == skip[j])
                {
                    flag = 1;
                    break ;
                }
            }
            if (flag == 0)
                total--;
        }
        ans[idx++] = c;
    }
    ans[s_len] = '\0';
    return ans;
}