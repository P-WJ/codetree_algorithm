import sys

N = int(input())
seat = list(map(int, input()))

# Please write your code here.
ans = 0

for i in range(N):
    if seat[i] == 1:
        continue
    
    seat[i] = 1

    
    d = sys.maxsize

    for j in range(N):
        if seat[j] != 1:
            continue

        
        for k in range(j+1,N):
            if seat[k] == 1:
                d = min(d, k - j)

    seat[i] = 0
    
    ans = max(ans, d)

print(ans)