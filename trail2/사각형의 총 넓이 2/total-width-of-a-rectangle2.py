n = int(input())
x1, y1, x2, y2 = [], [], [], []
for _ in range(n):
    a, b, c, d = map(int, input().split())
    x1.append(a)
    y1.append(b)
    x2.append(c)
    y2.append(d)

# Please write your code here.
offset = 100

arr = [[0] * (offset * 2 + 1) for _ in range(offset * 2 + 1)] 

for k in range(n):
    x1[k] += offset
    x2[k] += offset
    y1[k] += offset
    y2[k] += offset

    for i in range(y1[k], y2[k]):
        for j in range(x1[k], x2[k]):
            arr[i][j] += 1

ans = 0
for i in range(2 * offset + 1):
    for j in range(2 * offset + 1):
        if arr[i][j] >= 1:
            ans += 1

print(ans)