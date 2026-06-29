n, m = map(int, input().split())
arr = [0] + list(map(int, input().split()))

#Please write your code here.
ans = 0

for i in range(n+1):
    cnt = 0
    start = i
    for j in range(m):

        cnt += arr[arr[start]]
        start = arr[start]
    
    ans = max(ans, cnt)

print(ans)