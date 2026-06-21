n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
ans = 0

for i in range(n):
    
    for j in range(n-2):
        cnt = grid[i][j] + grid[i][j+1] + grid[i][j+2]
        ans = max(ans, cnt)

print(ans)