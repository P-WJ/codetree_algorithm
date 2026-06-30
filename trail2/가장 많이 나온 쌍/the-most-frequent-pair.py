n, m = map(int, input().split())
pairs = [tuple(map(int, input().split())) for _ in range(m)]

# Please write your code here.
ans = 0

for a1, b1 in pairs:
    cnt = 0
    for a2, b2 in pairs:
        if (a1 == a2 and b1 == b2) or (a1 == b2 and a2 == b1):
            cnt += 1

    ans = max(ans, cnt)

print(ans)