n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

# Please write your code here.
ans = 9999999999

for i in range(1, n-1):

    s = 0
    for j in range(0, n-1):
        if j == i:
            continue
        
        if j+1 == i:
            s += abs(x[j] - x[j+2]) + abs(y[j] - y[j+2])

        else:
            s += abs(x[j] - x[j+1]) + abs(y[j] - y[j+1])

    ans = min(s, ans)

print(ans)