import sys

N, H, T = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
ans = sys.maxsize

for i in range(N):
    arr[i] = abs(arr[i] - H)

for i in range(N-T+1):
    
    for j in range(i+T-1, N):
        ans = min(ans, sum(arr[i:j+1]))

print(ans)