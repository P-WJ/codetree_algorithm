n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
ans = 0

for i in range(n):
    
    
    for j in range(n-2):
        cnt = 0
        for k in range(j, j+3):
            
            if grid[i][k] == 1:
                cnt +=1

        ans = max(ans, cnt)

print(ans)