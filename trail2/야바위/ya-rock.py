n = int(input())
moves = [tuple(map(int, input().split())) for _ in range(n)]
a, b, c = zip(*moves)
a, b, c = list(a), list(b), list(c)

# Please write your code here.
ans = 0

for i in range(1, 4):

    arr = [0] * 4
    arr[i] = 1

    score = 0

    for j in range(n):
        arr[a[j]], arr[b[j]] = arr[b[j]], arr[a[j]]

        if arr[c[j]]:
            score += 1

    ans = max(ans, score)

print(ans)