R, C = map(int, input().split())
arr = [list(input().split()) for _ in range(R)]

# Please write your code here.
ans = 0

for a in range(1, R-1):
    for b in range(1, C-1):
        
        if arr[0][0] == arr[a][b]:
            continue


        for c in range(a+1, R-1):
            for d in range(b+1, C-1):

                if arr[a][b] == arr[c][d]:
                    continue

                if arr[c][d] == arr[R-1][C-1]:
                    continue

                ans += 1

print(ans)