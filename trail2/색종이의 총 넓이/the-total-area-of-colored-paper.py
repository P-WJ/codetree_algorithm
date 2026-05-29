n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x, y = zip(*points)
x, y = list(x), list(y)

# Please write your code here.
offset = 100

arr = [[0] * (2 * offset + 1) for _ in range(2 * offset + 1)]

for k in range(n):
    for i in range(y[k], y[k] + 8):
        for j in range(x[k], x[k] + 8):
            arr[i][j] = 1

ans = 0
for i in range(2 * offset + 1):
    for j in range(2 * offset + 1):
        if arr[i][j] == 1:
            ans += 1

print(ans)