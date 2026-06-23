N, K = map(int, input().split())
arr = []

for _ in range(N):
    c, p = map(int, input().split())
    arr.append((c, p))

# Please write your code here.
li = [0 for _ in range(101)]
ans = 0

for i in range(N):
    li[arr[i][1]] += arr[i][0]

for i in range(101):
    left = max(0, i-K)
    right = min(100, i+K)

    ans = max(ans, sum(li[left: right+1]))

print(ans)