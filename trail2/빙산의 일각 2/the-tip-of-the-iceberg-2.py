n = int(input())

h = [int(input()) for _ in range(n)]

# Please write your code here.
ans = 0

for i in range(1, max(h)):
    cnt = 0
    prev = False

    for j in range(n):

        if h[j] > i and prev == False:
            prev = True
            cnt += 1
        elif h[j] <= i:
            prev = False

    ans = max(ans, cnt)


print(ans)