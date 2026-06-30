import sys

n = int(input())
ranges = [tuple(map(int, input().split())) for _ in range(n)]
a, b = zip(*ranges)
a, b = list(a), list(b)

# Please write your code here.
ans = 0

for x in range(1, sys.maxsize+1):
    f = True
    s = x
    for i in range(n):
        s = s * 2
        if not (a[i] <= s <= b[i]):
            f = False
            break
        
    if f:
        ans = x
        break

print(ans)