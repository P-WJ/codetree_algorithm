N, C, G, H = map(int, input().split())
ranges = [tuple(map(int, input().split())) for _ in range(N)]

# Please write your code here.
ans = 0

for i in range(-1, 1002):
    total = 0

    for j in range(N):
        if i < ranges[j][0]:
            total += C

        elif i > ranges[j][1]:
            total += H

        else:
            total += G

    ans = max(ans, total)

print(ans)