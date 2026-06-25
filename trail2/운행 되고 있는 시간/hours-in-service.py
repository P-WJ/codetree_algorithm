n = int(input())
times = [tuple(map(int, input().split())) for _ in range(n)]
a = [t[0] for t in times]
b = [t[1] for t in times]

# Please write your code here.
ans = 0

for i in range(n):
    arr = [0 for _ in range(1001)]
    for j in range(n):
        
        if i == j:
            continue

        for k in range(a[j], b[j]):
            if arr[k] != 0:
                continue
            
            arr[k] += 1

    ans = max(ans, sum(arr))

print(ans)