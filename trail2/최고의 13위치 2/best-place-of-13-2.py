n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
ans = 0
for i in range(n):
    for j in range(n-2):
        
        a = arr[i][j] + arr[i][j+1] + arr[i][j+2]

        for k in range(n):
            for l in range(n-2):
                
                if k == i:
                    if  not(j+2 < l or l+2 < j):
                        continue


                b = arr[k][l] + arr[k][l+1] + arr[k][l+2]
                    
                ans = max(ans, a+b)

print(ans)