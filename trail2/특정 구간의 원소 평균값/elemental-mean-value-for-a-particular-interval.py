n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.
ans = 0

for i in range(n):
    for j in range(i, n):
        if sum(arr[i:j+1]) / len(arr[i:j+1]) in arr[i:j+1]:
            ans += 1

print(ans)

