n = int(input())
grid = [[0] * n for _ in range(n)]

# Please write your code here.

dir = [[0,1], [-1,0], [0,-1], [1,0]]

k = n // 2
r,c,d = k,k,-1

grid[k][k] = 1

for i in range(2, n*n+1):
    nr, nc = r + dir[d][0], c + dir[d][1]

    if 0 <= nr < n and 0 <= nc < n and grid[nr][nc] == 0:
        
        if grid[r + dir[(d+1)%4][0]][c + dir[(d+1)%4][1]] == 0:
            d = (d+1) % 4
            nr, nc = r + dir[d][0], c + dir[d][1]

    else:
        d = (d+1) % 4
        nr, nc = r + dir[d][0], c + dir[d][1]

    r, c = nr, nc
    grid[r][c] = i


for i in range(n):
    for j in range(n):
        print(grid[i][j], end = " ")
    print()