X, Y = map(int, input().split())

# Please write your code here.
ans = 0

for i in range(X, Y+1):
    total = 0
    for j in range(len(str(i))):
        total += int(str(i)[j])
    ans = max(ans, total)

print(ans)