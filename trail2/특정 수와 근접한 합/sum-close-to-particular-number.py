import sys

N, S = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
ans = sys.maxsize
arr_sum = sum(arr)

for i in range(N):
    for j in range(i+1, N):
        new_sum = arr_sum - arr[i] - arr[j]
        ans = min(ans, abs(new_sum - S))

print(ans)