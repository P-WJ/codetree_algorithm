N, K = map(int, input().split())
arr = [int(input()) for _ in range(N)]

# Please write your code here.
ans = 0

arr.sort()

left = 0

for right in range(N):
    while arr[right] - arr[left] > K:
        left += 1
    ans = max(ans, right - left + 1)

print(ans)