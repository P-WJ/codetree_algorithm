n = int(input())
grid = [list(input()) for _ in range(n)]
k = int(input())

# Please write your code here.
r, c, d = 0, 0, 0
dr = [1, 0, -1, 0]
dc = [0, -1, 0, 1]

a = [1, 0, 3, 2] # /
b = [3, 2, 1, 0] # \

if (k-1) // n == 0:
    r, c = 0, (k-1) % n
    d = 0

elif (k-1) // n == 1:
    r, c = (k-1) % n, n-1
    d = 1

elif (k-1) // n == 2:
    r, c = n-1, (n-1) - (k-1) % n
    d = 2

elif (k-1) // n == 3:
    r, c = (n-1) - (k-1) % n, 0
    d = 3

cnt = 0

while 0 <= r < n and 0 <= c < n:
    if grid[r][c] == "/":
        r, c = r + dr[a[d]], c + dc[a[d]]
        d = a[d]
    
    elif grid[r][c] == "\\":
        r, c = r + dr[b[d]], c + dc[b[d]]
        d = b[d]

    cnt += 1

print(cnt)