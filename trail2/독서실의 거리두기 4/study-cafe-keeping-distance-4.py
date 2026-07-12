n = int(input())
seat = list(input())

# Please write your code here.
ans = 0

for i in range(n):
    for j in range(i+1, n):
        if seat[i] == "0" and seat[j] == "0":
            seat[i] = seat[j] = "1"
            
            d = n
            for a in range(n):
                for b in range(a+1, n):
                    if seat[a] == "1" and seat[b] == "1":
                        d = min(d, b-a)

            ans = max(ans, d)

            seat[i] = seat[j] = "0"

print(ans)