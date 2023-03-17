// 백준 S1문제 1052 | 물병

#include <stdio.h>

int main()
{
    int N;
    int K;
    scanf("%d %d", &N, &K);
    int ans = 0;
    if (K >=  N)
    {
        printf("0");
        return 0;
    }
    else
    {
        int cnt;
        while (1)
        {
            int temp = N;
            cnt = 0;
            while (temp > 0)
            {
                if (temp % 2 != 0)
                    cnt++;
                temp /= 2;
                
            }
            if (K >= cnt)
                break;
            ans++;
            N++;
        }
    }
    printf("%d", ans);
}