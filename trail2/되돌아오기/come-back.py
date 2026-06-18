N = int(input())
moves = [tuple(input().split()) for _ in range(N)]
dir = [move[0] for move in moves]
dist = [int(move[1]) for move in moves]

# Please write your code here.
arr = [[0 for _ in range(2001)] for _ in range(2001)]
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
di = {"N":0, "S":1, "E":2, "W":3}
r, c = 0, 0

cnt = 0
ans = -1
f = False
for i in range(N):
    if f:
        break
    for _ in range(dist[i]):
        
        nr = r + dr[di[dir[i]]]
        nc = c + dc[di[dir[i]]]

        if nr == 0 and nc == 0:
            ans = cnt + 1
            f = True

        if -1000 <= nr < 1000 and -1000 <= nc < 1000:
            r = nr
            c = nc
            cnt += 1

print(ans)
