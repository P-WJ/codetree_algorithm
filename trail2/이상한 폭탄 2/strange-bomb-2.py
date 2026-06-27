N, K = map(int, input().split())
num = [int(input()) for _ in range(N)]

# Please write your code here.
arr = []

for i in range(N):

    left = i - K
    right = i + K + 1

    if i - K <= 0:
        left = 0
    
    if i + K >= N:
        right = N
    
    cnt = 0
    for j in range(left, right):
        if num[j] == num[i]:
            cnt += 1

        if cnt == 2:
            arr.append(num[j])
            break

if len(arr):
    print(max(arr))

else:
    print(-1)