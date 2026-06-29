import sys

n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.
ans = sys.maxsize

for i in range(0, 101, 2):
    for j in range(0, 101, 2):
        cnt = 0

        a = 0
        for x, y in points:
            if i < x and j < y:
                a += 1

        b = 0
        for x, y in points:
            if i < x and j > y:
                b += 1
        
        c = 0
        for x, y in points:
            if i > x and j < y:
                c += 1

        d = 0
        for x, y in points:
            if i > x and j > y:
                d += 1


        cnt = max(a, b, c, d)

        ans = min(ans, cnt)

print(ans)