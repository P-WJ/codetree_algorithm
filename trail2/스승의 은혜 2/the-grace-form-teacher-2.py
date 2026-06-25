N, B = map(int, input().split())
P = [int(input()) for _ in range(N)]

# Please write your code here.
P.sort()

ans = 0

for i in range(N):
    
    coupon = P[i] // 2

    if coupon > B:
        continue

    total = coupon
    cnt = 1

    for j in range(N):

        if i == j:
            continue

        if total + P[j] > B:
            continue

        else:
            total += P[j]
            cnt += 1

    ans = max(ans, cnt)

print(ans)