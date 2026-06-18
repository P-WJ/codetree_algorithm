N = int(input())
moves = [tuple(input().split()) for _ in range(N)]
dir = [move[0] for move in moves]
dist = [int(move[1]) for move in moves]

# Please write your code here.
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
        
        r = r + dr[di[dir[i]]]
        c = c + dc[di[dir[i]]]
        cnt += 1

        if r == 0 and c == 0:
            ans = cnt
            f = True
            break


print(ans)
