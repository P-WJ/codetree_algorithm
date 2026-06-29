import sys

n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.
ans = sys.maxsize

for i in range(n):
    arr[i] = arr[i] * 2
    
    for j in range(n):
        if i == j:
            continue

        li = []
        for k in range(n):
            if j == k:
                continue

            li.append(arr[k])
        
        hap = 0
        for k in range(len(li)-1):
            hap += abs(li[k] - li[k+1])
        ans = min(ans, hap)
        
    arr[i] = arr[i] // 2
print(ans)