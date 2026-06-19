N, T = map(int, input().split())
str = input()
board = [list(map(int, input().split())) for _ in range(N)]

# Please write your code here.

k =  N // 2
r,c,d = k,k,0
dir = [[-1,0], [0,1], [1,0], [0,-1]]

ans = board[r][c]

for cd in str:
    if cd == "L":
        d = (d-1) % 4
    
    elif cd == "R":
        d = (d+1) % 4

    elif cd == "F":
        nr = r + dir[d][0]
        nc = c + dir[d][1]

        if 0 <= nr < N and 0 <= nc < N:
            r, c = nr, nc
            ans += board[r][c]

print(ans)