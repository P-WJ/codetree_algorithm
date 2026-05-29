x1, y1, x2, y2 = [0] * 2, [0] * 2, [0] * 2, [0] * 2
x1[0], y1[0], x2[0], y2[0] = map(int, input().split())
x1[1], y1[1], x2[1], y2[1] = map(int, input().split())

# Please write your code here.
offset = 1000

arr = [[0] * (2 * offset + 1) for _ in range(2 * offset + 1)]

for k in range(2):
    x1[k] += offset
    x2[k] += offset
    y1[k] += offset
    y2[k] += offset

    if k != 1:
        for i in range(y1[k], y2[k]):
            for j in range(x1[k], x2[k]):
                arr[i][j] = 1
    else:
        for i in range(y1[k], y2[k]):
            for j in range(x1[k], x2[k]):
                arr[i][j] = 0

minx, miny = 2001, 2001
maxx, maxy = -1, -1
for i in range(2 * offset + 1):
    for j in range(2 * offset + 1):
        if arr[i][j]:
            if minx > j:
                minx = j
            if maxx < j:
                maxx = j
            if miny > i:
                miny = i
            if maxy < i:
                maxy = i

ans = (maxx-minx+1) * (maxy-miny+1)
if maxx == -1:
    print(0)
else:
    print(ans)