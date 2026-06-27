k, n = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(k)]

# Please write your code here.
li = []
ans = 0

for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            continue

        li.append((i,j))

for i in range(len(li)):
    cnt = 0
    for j in range(k):
        f = True
        
        for l in range(n):
            if arr[j][l] == li[i][0] and f:
                cnt += 1
                break

            elif arr[j][l] == li[i][1]:
                f = False

    if cnt == k:
        ans += 1

print(ans)