n, m = map(int, input().split())

# Please write your code here.

arr = [[0 for _ in range(m)] for _ in range(n)]

dir = [[1,0], [0,1], [-1,0], [0,-1]]

r,c,d = 0,0,0
arr[r][c] = 1

for num in range(2, n*m+1):

    nr, nc = r + dir[d][0], c + dir[d][1]

    if 0 <= nr < n and 0 <= nc < m and arr[nr][nc] == 0:
        pass
    else:
        d = (d+1) % 4
        nr, nc = r + dir[d][0], c + dir[d][1]
    
    r, c = nr, nc
    arr[r][c] = num

for i in range(n):
    for j in range(m):
        print(arr[i][j], end=" ")
    print()