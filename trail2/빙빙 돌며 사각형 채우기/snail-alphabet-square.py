n, m = map(int, input().split())

# Please write your code here.
char = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']

arr = [["0" for _ in range(m)] for _ in range(n)]
r,c,d = 0,0,0
dir = [[0,1], [1,0], [0,-1], [-1,0]]

arr[r][c] = char[d]

for i in range(1, m*n):

    nr, nc = r + dir[d][0], c + dir[d][1]

    if 0 <= nr < n and 0 <= nc < m and arr[nr][nc] == "0":
        pass
    else:
        d = (d+1) % 4
        nr, nc = r + dir[d][0], c + dir[d][1]
    
    r, c = nr, nc
    arr[r][c] = char[i % len(char)]
    

for i in range(n):
    for j in range(m):
        print(arr[i][j], end = " ")
    print()
