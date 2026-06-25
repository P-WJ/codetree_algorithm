import sys

n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

# Please write your code here.
ans = sys.maxsize

for i in range(n):
    maxx = 0
    minx = sys.maxsize
    maxy = 0
    miny = sys.maxsize

    for j in range(n):
        if i == j:
            continue

        maxx = max(maxx, x[j])
        minx = min(minx, x[j])
        maxy = max(maxy, y[j])
        miny = min(miny, y[j])

    ans = min(ans, (maxx - minx) * (maxy - miny))

print(ans)