R, C = map(int, input().split())
grid = [list(input().split()) for _ in range(R)]

# Please write your code here.
ans = 0

for a in range(1, R):
    for b in range(1, C):
        
        if grid[a][b] == grid[0][0]:
            continue

        for c in range(a+1, R-1):
            for d in range(b+1, C-1):

                if grid[a][b] == grid[c][d]:
                    continue

                if grid[c][d] == grid[R-1][C-1]:
                    continue

                ans += 1


print(ans)