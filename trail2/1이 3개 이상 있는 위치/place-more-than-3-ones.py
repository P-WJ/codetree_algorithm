n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
ans = 0

dir = [[1,0],[-1,0],[0,1],[0,-1]]

for i in range(n):
    for j in range(n):
        cnt = 0

        if grid[i][j] == 1:
            cnt ++ 1

        for dx, dy in dir:
            nx = i + dx
            ny = j + dy
            
            if nx < n and ny < n and nx >= 0 and ny >= 0:
                if grid[nx][ny] == 1:
                    cnt += 1

        if cnt >= 3:
            ans += 1

print(ans)