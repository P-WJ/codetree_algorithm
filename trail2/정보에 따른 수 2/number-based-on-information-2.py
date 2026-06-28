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
    s = []
    n = []
    for j in range(T):
        if c[j] == "S":
            s.append(abs(i-x[j]))
        else:
            n.append(abs(i-x[j]))

    if min(s) <= min(n):
        ans += 1

print(ans)