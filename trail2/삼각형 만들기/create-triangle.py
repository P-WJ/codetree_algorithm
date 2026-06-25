n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
offset = 10000
x = [p[0] + offset for p in points]
y = [p[1] + offset for p in points]

# Please write your code here.
ans = 0

for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):

            if x[i] == x[j] == x[k]:
                continue
            
            elif x[i] != x[j] and x[j] != x[k] and x[k] != x[i]:
                continue

            elif y[i] == y[j] == y[k]:
                continue
            
            elif y[i] != y[j] and y[j] != y[k] and y[k] != y[i]:
                continue

            a = abs(max(x[i], x[j], x[k]) - min(x[i], x[j], x[k]))
            b = abs(max(y[i], y[j], y[k]) - min(y[i], y[j], y[k]))

            ans = max(ans, a*b)

print(ans)
