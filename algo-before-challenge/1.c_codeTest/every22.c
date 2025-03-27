//백준 g1 문제 17202 | 핸드폰 번호 궁합

#include <stdio.h>
#include <string.h>

char one[9];
char two[9];
char phone[20];
int arr[20];
int ans;

int main()
{
    int j=0;
    int k=0;
    scanf("%8s\n%8s", one, two);
    for (int i=1; i<17; i++)
        if (!(i % 2 == 0))
            phone[i] = one[j++];
        else
            phone[i] = two[k++];

    int cnt = 16;

    for(int i = 1; i < 17; ++i)
        arr[i] = phone[i] - '0';
    
    while (cnt > 2)
    {   
        for (int i=1; i<cnt; i++)
            arr[i] = (arr[i] + arr[i+1]) % 10;
        cnt -= 1;
    }

    ans = arr[1] * 10 + arr[2];
    if (ans < 10)
        printf("%c%d\n", '0', ans);
    else
        printf("%d\n", ans);
}