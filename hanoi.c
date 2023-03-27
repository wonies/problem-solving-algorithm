#include <stdio.h>

void hanoi(int a, int b, int n)
{
    if (n==1)
    {
        printf("%d->%d\n", a, b);
        return ;
    }
    hanoi(a, 6-a-b, n-1);
    printf("%d->%d\n", a, b);
    hanoi(6-a-b, b, n-1);
}


int main()
{
    int n = 3;
    hanoi(1, 3, n);
    return 0;
}