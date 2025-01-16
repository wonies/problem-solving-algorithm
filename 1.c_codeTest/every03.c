//프로그래머스 | 카드뭉치

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char* solution(const char* cards1[], size_t cards1_len, const char* cards2[], size_t cards2_len, const char* goal[], size_t goal_len) {
    char* ans = (char*)calloc(4, 1);
    
    int check = 0;
    int card1_idx = 0;
    int card2_idx = 0;
    
    for (int i=0; i<goal_len; i++)
    {
        int flag = 0;
              
        while (card1_idx < cards1_len)
        {
            if (strcmp(goal[i], cards1[card1_idx])==0)
            {
                flag = 1;
                check = 1;
                card1_idx++;
            }
            else
            {
                check = 0;
                flag = 0;
            }
            break ;
        }
        if (flag == 0)
        {
            
            while (card2_idx < cards2_len)
            {
                if (strcmp(goal[i], cards2[card2_idx])==0)
                {
                    check = 1;
                    card2_idx++;
                }
                else
                {
                    check = 0;
                    flag = -42;
                }
                break ; 
            }
        }
        if (check == 0)
        {
            break ;
        }
    }
        
    if (check == 1)
        ans = "Yes";
    else
        ans = "No";
 
     
    
    return ans;
}