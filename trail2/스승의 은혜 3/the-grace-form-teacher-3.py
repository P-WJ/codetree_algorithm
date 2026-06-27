N, B = map(int, input().split())
gifts = [tuple(map(int, input().split())) for _ in range(N)]

# Please write your code here.
ans = 0
gifts.sort(key = lambda x: (x[0] + x[1], x[0]))

for i in range(N):
    cnt = 0

    total = gifts[i][0] // 2 + gifts[i][1]
    
    if total > B:
            continue
    
    cnt += 1
    
    for j in range(N):

        if i == j:
            continue

        if total + gifts[j][0] + gifts[j][1] > B:
            continue

        total += gifts[j][0] + gifts[j][1]
        cnt += 1
    
    ans = max(ans, cnt)

print(ans)