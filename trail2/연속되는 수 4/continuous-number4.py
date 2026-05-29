n = int(input())
arr = [int(input()) for _ in range(n)]

# Please write your code here.
cnt = 1
max_cnt = 0
for i in range(n-1):
    if arr[i] < arr[i+1]:
        cnt += 1
    else:
        max_cnt = max(max_cnt, cnt)
        cnt = 1

max_cnt = max(max_cnt, cnt)
print(max_cnt)