//백준 s4 문제 1643 | 1로 만들기 재귀 (시간초과)

#include <stdio.h>

int cnt;
int mincnt = 2147000;

void check(int num)
{
    if(num == 1)
    {
        if (cnt < mincnt)
            mincnt = cnt;
        return ;
    }
    if(num%3 == 0)
    {
       cnt++;
       check(num/3);
       cnt--;
    }
    if(num%2 ==0)
    {
        cnt++;
        check(num/2);
        cnt--;
    }
    if (num > 1)
    {
        cnt++;
        check(num-1);
        cnt--;
    }
}

int main()
{
    int n;
    scanf("%d", &n);
    check(n);
    printf("%d\n", mincnt);
}