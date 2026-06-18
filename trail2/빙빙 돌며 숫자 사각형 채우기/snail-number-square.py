n, m = map(int, input().split())
arr = [[0] * m for _ in range(n)]

# Please write your code here.
dir = [[0,1], [1,0], [0,-1],  [-1,0]]

r, c = 0, 0
d = 0
arr[r][c] = 1

for i in range(2, n*m+1):

    nr = r + dir[d][0]
    nc = c + dir[d][1]
    
    if 0 <= nr < n and 0 <= nc < m and arr[nr][nc] == 0:
        pass
    else:
        d = (d + 1) % 4
        nr = r + dir[d][0]
        nc = c + dir[d][1]
    
    r, c = nr, nc
    arr[r][c] = i

for i in range(n):
    for j in range(m):
        print(arr[i][j], end = " ")
    print()