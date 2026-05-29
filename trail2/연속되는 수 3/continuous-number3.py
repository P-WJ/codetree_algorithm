N = int(input())
arr = [int(input()) for _ in range(N)]

# Please write your code here.
cnt = 1
ans = 0
for i in range(N-1):
    if arr[i] > 0 and arr[i+1] > 0:
        cnt += 1
    
    elif arr[i] < 0 and arr[i+1] < 0:
        cnt += 1
    
    else:
        ans = max(ans, cnt)
        cnt = 1
        

ans = max(ans, cnt)
print(ans)