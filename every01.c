// 

#include <string.h> 
#include <stdio.h>

int* solution(const char* s) {
    
    int len = strlen(s);
    int* answer = (int*)calloc(4, len);
    int j=0;
    int flag;
    answer[j++]=-1;
    for(int i=1; i<len; i++)
    {
        flag = 0;
        for(int k=i-1; k>=0; k--)
        {
            if (s[i] == s[k])
            {
                flag = 1;
                answer[j++] = i-k;
                break ;
            }
        }
        if (flag == 0)
            answer[j++] = -1;
        
    }
    return answer;
}