n = int(input())
moves = [tuple(map(int, input().split())) for _ in range(n)]
a, b, c = zip(*moves)
a, b, c = list(a), list(b), list(c)

# Please write your code here.
arr = [0, 1, 2, 3]
ans = [0] * 4
for i in range(n):
    tmp = arr[a[i]]
    arr[a[i]] = arr[b[i]]
    arr[b[i]] = tmp

    ans[arr[c[i]]] += 1

print(max(ans))