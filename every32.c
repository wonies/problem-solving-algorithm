// 백준 2502 || 떡먹는 호랑이


#include <stdio.h>

int a[33];
int b[33];

int main(void)
{
    int d, k;
    scanf("%d %d", &d, &k);
    
    a[1] = 1;
    a[2] = 0;
    b[1] = 0;
    b[2] = 1;

    for(int i=3; i<=d; i++)
    {
        a[i] = a[i-1] + a[i-2];
        b[i] = b[i-1] + b[i-2];
    }
    int dduk=0;
    int dduk2=0;
    int one_day = 0;
    int two_day = 0;
    for (int i=1; i<=k; i++)
    {
        one_day = i;
        dduk = k - (a[d] * i);
        dduk2 = dduk % b[d];
        if (dduk2 == 0)
        {
            two_day = dduk / b[d];
            break;
        }
    }
    printf("%d\n%d\n", one_day, two_day);
}