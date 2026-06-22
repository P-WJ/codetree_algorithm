n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
ans = 0

for i in range(0, n-k+1):
    t = sum(arr[i:i+k])
    ans = max(ans, t)

print(ans)