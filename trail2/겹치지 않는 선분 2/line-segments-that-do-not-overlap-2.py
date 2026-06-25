n = int(input())
lines = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.
ans = 0

for i in range(n):
    cross = False

    for j in range(n):
        
        if i == j:
            continue

        if (lines[i][0] < lines[j][0] and lines[i][1] > lines[j][1]) or (lines[i][0] > lines[j][0] and lines[i][1] < lines[j][1]):
            cross = True
            break

    if not cross:
        ans += 1

print(ans)