n = int(input())
grid = [[0] * n for _ in range(n)]

# Please write your code here.

dir = [[0,1], [-1,0], [0,-1], [1,0]]

k = n // 2
r,c,d = k,k,0

grid[k][k] = 1

for i in range(2, n*n+1):

    # 이동 먼저
    r += dir[d][0]
    c += dir[d][1]
    grid[r][c] = i

    # 방향 전환
    nd = (d+1) % 4
    nr = r + dir[nd][0]
    nc = c + dir[nd][1]

    # 방향 전환 유효 확인
    if 0 <= nr < n and 0 <= nc < n and grid[nr][nc] == 0:
        d = nd

for i in range(n):
    for j in range(n):
        print(grid[i][j], end = " ")
    print()
