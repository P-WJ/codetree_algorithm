n = int(input())
arr = []
for i in range(n):
    a, b = input().split()
    arr.append((a, int(b)))

xy = [0,0]
dir = [[1,0], [-1,0], [0,1], [0,-1]] # E, W, N, S
for d, c in arr:
    if d == "E":
        for _ in range(c):
            xy[0] += dir[0][0]
            xy[1] += dir[0][1]
    
    elif d == "W":
        for _ in range(c):
            xy[0] += dir[1][0]
            xy[1] += dir[1][1]

    elif d == "N":
        for _ in range(c):
            xy[0] += dir[2][0]
            xy[1] += dir[2][1]

    elif d == "S":
        for _ in range(c):
            xy[0] += dir[3][0]
            xy[1] += dir[3][1]

for a in xy:
    print(a, end=" ")