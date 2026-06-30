N, K = map(int, input().split())
arr = [int(input()) for _ in range(N)]

# Please write your code here.
ans = 0

for i in range(1, 10001):
    
    cnt = 0
    for x in arr:
        if i <= x <= i + K:
            cnt += 1

    ans = max(ans, cnt)

print(ans)