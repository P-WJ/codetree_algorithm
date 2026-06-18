n, m = map(int, input().split())
points = [tuple(map(int, input().split())) for _ in range(m)]

# Please write your code here.

arr = [[0 for _ in range(n+1)] for _ in range(n+1)]

dir = [[1,0],[-1,0],[0,1],[0,-1]]

for i in range(m):
    x, y = points[i]
    arr[x][y] = 1
    cnt = 0
    for dx, dy in dir:
        nx = x + dx
        ny = y + dy

        if 1 <= nx < n+1 and 1 <= ny < n+1 and arr[nx][ny]:
            cnt += 1
    if cnt == 3:
        print(1)
    else:
        print(0)
