//백준 b3 문제 1152 | 단어의 개수

#include <stdio.h>
#include <string.h>
char word[1000001];

int main() {

  scanf("%[^\n]s", word);
  int len = strlen(word);
  int cnt = 0;
    
  if (word[0] != ' ')
      cnt++; // 처음부터 공백으로만 들어오고 끝나는 경우의 수가 있기 때문이다
    
  for (int i = 1; i < len; i++) {
    if (word[i - 1] == ' ' && word[i] != ' ')
      cnt++;
  }
  printf("%d\n", cnt);
}