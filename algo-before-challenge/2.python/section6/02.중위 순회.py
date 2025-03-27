
def dfs(v):
    if v > 7:
        return
    else:
        dfs(v*2)
        print(v, end='')
        dfs(v*2+1)
        
dfs(1)