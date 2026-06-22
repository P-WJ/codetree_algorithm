N, M = map(int, input().split())
arr = [input() for _ in range(N)]

# Please write your code here.
ans = 0

dir = [[1,0], [0,1], [-1,0], [0,-1], [1,1], [1,-1], [-1,1], [-1,-1]]

for i in range(N):
    for j in range(M):

        if arr[i][j] == "L":

            
            for dx, dy in dir:
                
                curx = i
                cury = j
                cnt = 0
                
                while True:
                    nx = curx + dx
                    ny = cury + dy

                    if not (0 <= nx < N and 0 <= ny < M):
                        break

                    if arr[nx][ny] != "E":
                        break

                    curx = nx
                    cury = ny
                    cnt += 1

                    if cnt == 2:
                        ans += 1
                        break

print(ans)