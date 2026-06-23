import sys

arr = list(map(int, input().split()))

# Please write your code here.
n = len(arr)

ans = sys.maxsize

total = sum(arr)

f = True

for i in range(n):
        sum1 = arr[i]
        
        for j in range(n):
            if j == i:
                continue
            
            for k in range(n):
                if k == i or k == j:
                    continue

                sum2 = arr[j] + arr[k]
                sum3 = total - (sum1 + sum2)
                
                if sum1 == sum2 or sum2 == sum3 or sum3 == sum1:
                    f = False
                    continue
                f= True
                ans = min(ans, max(sum1, sum2, sum3) - min(sum1, sum2, sum3))

if f:
    print(ans)
else:
    print(-1)