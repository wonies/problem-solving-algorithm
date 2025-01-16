import sys

sys.stdin = open("inputs/07.txt", "rt")

def DFS(level):
    if (level == m):
        print(" ".join(map(str, res[:m])))
    else:
        for i in range(1, n+1):
            res[level] = i
            DFS(level+1)        


n, m = map(int, input().split())
res = [0] * m

DFS(0)
