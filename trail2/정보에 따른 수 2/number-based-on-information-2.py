import sys

T, a, b = map(int, input().split())
c = []
x = []
for _ in range(T):
    char, pos = input().split()
    c.append(char)
    x.append(int(pos))

# Please write your code here.
ans = 0

for i in range(a, b+1):
    s = sys.maxsize
    n = sys.maxsize

    for j in range(T):
        if c[j] == "S":
            s = min(s, abs(i-x[j]))
        else:
            n = min(n, abs(i-x[j]))
            
    if s <= n:
        ans += 1

print(ans)