// 프로그래머스 | 개인정보 수집 유효기간

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int alpha[26];

int* solution(const char* today, const char* terms[], size_t terms_len, const char* privacies[], size_t privacies_len) {
   int* ans = (int*)calloc(privacies_len, 4);
    int idx= 0;
    int year = atoi(strtok(today, ".")) - 2000;
    int month = atoi(strtok(NULL, "."));
    int day = atoi(strtok(NULL, "."));
    
    int ex_term = (year * 12 * 28) + (month * 28) + day; 
    int taken = 0;
    int expired_m = 0;
    
    for (int i=0; i<terms_len; i++)
    {
        taken = strtok(terms[i], " ")[0];
        expired_m = atoi(strtok(NULL, " "));
        alpha[taken - 'A'] = expired_m;
    }
    printf("ex_term: %d\n", ex_term);
    
    int ap=0;
    int ex_date=0;
    int temp= 0;
    int pri_year, pri_month, pri_day = 0;
    
    for(int i=0; i<privacies_len; i++)
    {
        pri_year = atoi(strtok(privacies[i], ".")) - 2000;
        pri_month = atoi(strtok(NULL, "."));
        pri_day = atoi(strtok(NULL, " "));
        ap = strtok(NULL, " ")[0];
        ex_date = (pri_year * 12 * 28) + (pri_month + alpha[ap-'A']) * 28 + pri_day ;
        printf("ex_date: %d\n", ex_date);
        temp = ex_term - ex_date;
        printf("temp: %d\n", temp);
        if (temp >= 0)
            ans[idx++] = i + 1;
    }
    
    
    return ans;
}